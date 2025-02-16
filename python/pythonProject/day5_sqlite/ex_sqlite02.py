# 데이터 삽입
import sqlite3
conn = sqlite3.connect('./example.db')
cur = conn.cursor()
# 1. 문자열 사용 query 호출
cur.execute("""INSERT INTO stocks VALUES('2006-01-05', 'BUY', 'RHAT', 100, 35.14)
""")
# 2. tuple 사용
date = '2006-01-07'
trans = 'BUY'
symbol = 'RHAT'
qty = 100
price = 35.16
cur.execute("""INSERT INTO stocks VALUES(?, ?, ?, ?, ?)""", (date, trans, symbol, qty, price))
# 3. dict named param
data = {"date":date, "trans":trans, "symbol":symbol, "qty":qty, "price":price}
cur.execute("""INSERT INTO stocks
                VALUES(:date, :trans, :symbol, :qty, :price)
""", data)
# 4. list
cur.execute("""INSERT INTO stocks
                VALUES(:1, :2, :3, :4, :5)
""", [date, trans, symbol, qty, price])
# 여러 건
data_list = [(date, trans, symbol, qty, price)
             ,(date, trans, symbol, qty, price)
             ,(date, trans, symbol, qty, price)
             ,(date, trans, symbol, qty, price)]
cur.executemany("""INSERT INTO stocks
                    VALUES(?, ?, ?, ?, ?)""",data_list)
print(cur.rowcount)
conn.commit()
conn.close()

