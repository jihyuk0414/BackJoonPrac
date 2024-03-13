-- 코드를 입력하세요
SELECT ROUND(AVG(DAILY_FEE))
from CAR_RENTAL_COMPANY_CAR
group by car_type
having car_type = "SUV"


