WITH MAIN_T AS (
    SELECT 
        HISTORY.CAR_ID, 
        (END_DATE - START_DATE) AS DAYS, 
        CAR.DAILY_FEE, 
        CASE  WHEN (END_DATE - START_DATE) > 90 THEN 100-5
              WHEN (END_DATE - START_DATE) > 30 THEN 100-7
              WHEN (END_DATE - START_DATE) > 7  THEN 100-10 
              ELSE 100
        END AS DR,
        HISTORY.HISTORY_ID AS HISTORY_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY HISTORY 
    LEFT JOIN CAR_RENTAL_COMPANY_CAR CAR ON 1 = 1 
    AND CAR.CAR_ID = HISTORY.CAR_ID 
    WHERE CAR_TYPE = '트럭' 
), BASE_T AS (
    SELECT 
        MAIN_T.CAR_ID, 
        MAIN_T.HISTORY_ID,
        (MAIN_T.DAILY_FEE * MAIN_T.DR * 0.01) * MAIN_T.DAYS AS FEE 
    FROM MAIN_T 
), RESULT_T AS(
    SELECT CAR_ID, MAX(FEE) AS FEE
    FROM BASE_T T
    GROUP BY CAR_ID
)

SELECT 
    BASE.HISTORY_ID,
    BASE.FEE
FROM RESULT_T RESULT
LEFT JOIN BASE_T BASE ON 1=1
AND BASE.CAR_ID = RESULT.CAR_ID
AND BASE.FEE = RESULT.FEE
ORDER BY FEE DESC, HISTORY_ID DESC

