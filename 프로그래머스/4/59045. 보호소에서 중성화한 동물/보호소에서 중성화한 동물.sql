-- 코드를 입력하세요
SELECT A.ANIMAL_ID , A.ANIMAL_TYPE, A.NAME 
FROM ANIMAL_INS AS A INNER JOIN ANIMAL_OUTS AS B ON A.ANIMAL_ID = B.ANIMAL_ID 
WHERE (A.SEX_UPON_INTAKE IN ('Intact Male','Intact Female'))
AND (B.SEX_UPON_OUTCOME IN ('Spayed Male','Spayed Female','Neutered Male','Neutered Female'))