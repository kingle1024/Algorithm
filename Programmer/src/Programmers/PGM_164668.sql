WITH MAIN_T AS (
    SELECT
        WRITER_ID
         , sum(PRICE) TOTAL_SALES
        # *
    FROM USED_GOODS_BOARD BOARD
    WHERE BOARD.STATUS = 'DONE'
    GROUP BY WRITER_ID
    HAVING TOTAL_SALES >= 700000
)
select
    MAIN_T.WRITER_ID AS USER_ID
     , USR.NICKNAME
     , MAIN_T.TOTAL_SALES
from MAIN_T
         LEFT JOIN USED_GOODS_USER USR
                   ON MAIN_T.WRITER_ID = USR.USER_ID
ORDER BY MAIN_T.TOTAL_SALES ASC