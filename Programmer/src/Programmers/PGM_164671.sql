SELECT ('/home/grep/src/' || UGF.BOARD_ID || '/' || UGF.FILE_ID || UGF.FILE_NAME || UGF.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE UGF
WHERE BOARD_ID = (
    SELECT UGB.BOARD_ID
    FROM USED_GOODS_BOARD UGB
    WHERE UGB.VIEWS = (
        SELECT MAX(U_BOARD.VIEWS)
        FROM USED_GOODS_BOARD U_BOARD
    )
)
ORDER BY UGF.FILE_ID DESC