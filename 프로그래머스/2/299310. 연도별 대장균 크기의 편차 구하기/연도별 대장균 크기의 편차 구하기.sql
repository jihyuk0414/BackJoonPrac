-- 코드를 작성해주세요

SELECT A.YEAR_DATE AS YEAR, B.SIZE_OF_COLONY_MAX-A.SIZE_OF_COLONY AS YEAR_DEV, A.ID AS ID
FROM (SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR_DATE, SIZE_OF_COLONY, ID FROM ECOLI_DATA) 
A INNER JOIN 
(SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR_DATE, MAX(SIZE_OF_COLONY) AS SIZE_OF_COLONY_MAX
FROM ECOLI_DATA GROUP BY YEAR(DIFFERENTIATION_DATE)) B 
ON A.YEAR_DATE = B.YEAR_DATE
ORDER BY YEAR, YEAR_DEV