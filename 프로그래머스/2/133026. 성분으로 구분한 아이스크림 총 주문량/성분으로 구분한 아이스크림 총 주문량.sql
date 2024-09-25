-- 코드를 입력하세요
SELECT INGREDIENT_TYPE,SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF A INNER JOIN ICECREAM_INFO B ON (A.FLAVOR=B.FLAVOR)
GROUP BY INGREDIENT_TYPE 
ORDER BY SUM(TOTAL_ORDER) 
