SELECT DISTINCT cp1.CART_ID
FROM CART_PRODUCTS cp1
JOIN CART_PRODUCTS cp2 ON cp1.CART_ID = cp2.CART_ID
WHERE cp1.NAME = 'Milk'
AND cp2.NAME = 'Yogurt'
ORDER BY cp1.CART_ID;