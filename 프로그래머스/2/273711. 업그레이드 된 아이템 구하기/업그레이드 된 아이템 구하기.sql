-- 코드를 작성해주세요

SELECT J.NEXT_ITEM_ID AS ITEM_ID, I.ITEM_NAME AS ITEM_NAME, I.RARITY AS RARITY
FROM ITEM_INFO AS I INNER JOIN 
(SELECT B.ITEM_ID AS NEXT_ITEM_ID FROM ITEM_INFO A INNER JOIN ITEM_TREE B ON A.ITEM_ID=B.PARENT_ITEM_ID
WHERE PARENT_ITEM_ID IS NOT NULL AND A.RARITY = 'RARE') AS J ON I.ITEM_ID = J.NEXT_ITEM_ID
ORDER BY I.ITEM_ID DESC