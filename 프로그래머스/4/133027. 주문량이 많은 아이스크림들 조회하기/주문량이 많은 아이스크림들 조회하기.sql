-- 코드를 입력하세요
SELECT A.FLAVOR
FROM FIRST_HALF A INNER JOIN JULY B ON A.FLAVOR = B.FLAVOR
GROUP BY A.FLAVOR
ORDER BY SUM(B.TOTAL_ORDER)+MAX(A.TOTAL_ORDER) DESC
LIMIT 3 