import cx_Oracle
# pip instal cx_Oracle
def fn_get_memuser(param):
    conn = cx_Oracle.connect('java','oracle','localhost:1521/XE')
    print(conn.version)
    with conn:
        cur = conn.cursor()
        # 김씨만 조회
        cur.execute("""SELECT mem_id
                        , mem_name
                        , mem_job
                        , mem_mail
                    FROM member
                    WHERE mem_name LIKE '%'||:1||'%'
        """, [param])
        rows = cur.fetchall()
        return rows

    # 이름의 포함 텍스트를 입력받아 조회 결과를 리턴하는 함수를 만드시오
    # input : str, return: list

while True:
    msg = input('이름으로 조회:')
    mem_list = fn_get_memuser(msg)
    for mem in mem_list:
        print(mem)
    if (msg == 'q'):
        break



