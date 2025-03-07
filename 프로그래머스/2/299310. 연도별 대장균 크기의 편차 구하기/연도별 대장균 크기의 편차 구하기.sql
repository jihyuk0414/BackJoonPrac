-- 코드를 작성해주세요

SELECT B.YEAR, B.MAXVAL - A.SIZE_OF_COLONY AS YEAR_DEV, A.ID AS ID
FROM ECOLI_DATA AS A INNER JOIN (
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, MAX(SIZE_OF_COLONY) AS MAXVAL
FROM ECOLI_DATA 
GROUP BY YEAR(DIFFERENTIATION_DATE)) AS B ON YEAR(A.DIFFERENTIATION_DATE) = B.YEAR
ORDER BY B.YEAR,YEAR_DEV