-- 코드를 입력하세요

WITH RECURSIVE HOURS AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR+1 FROM HOURS WHERE HOUR<23
)

SELECT B.HOUR AS HOUR, CASE 
WHEN 
HOUR(A.DATETIME) IS NULL THEN 0 
ELSE COUNT(*)
END AS COUNT
FROM ANIMAL_OUTS AS A RIGHT OUTER JOIN HOURS AS B ON HOUR(A.DATETIME) = B.HOUR
GROUP BY B.HOUR
ORDER BY B.HOUR
