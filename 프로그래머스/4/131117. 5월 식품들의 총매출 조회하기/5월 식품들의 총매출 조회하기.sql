-- 코드를 입력하세요
SELECT PRODUCT_ID,PRODUCT_NAME,SUM(AMOUNT)*PRICE AS TOTAL_PRICE
FROM FOOD_PRODUCT NATURAL JOIN FOOD_ORDER
WHERE YEAR(PRODUCE_DATE)= 2022 AND MONTH(PRODUCE_DATE)=05
GROUP BY PRODUCT_ID
ORDER BY TOTAL_PRICE DESC, PRODUCT_ID ASC