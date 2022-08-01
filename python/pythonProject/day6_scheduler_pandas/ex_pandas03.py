from day5_sqlite.mydb import Mydb
import pandas as pd
db = Mydb()

mem_table = pd.read_sql(""" SELECT * FROM member WHERE mem_name like '%'||:nm||'%' """, con=db.conn, params={"nm": "김"})
print(mem_table.head())

# 데이터 접근 iloc[행 인덱스, 열 인덱스], loc[행인덱스]
print(mem_table.iloc[0,2])
print(mem_table.loc[0])
print(mem_table.columns)
for i, row in mem_table.iterrows():
    print(i,'번째',row['MEM_NAME'])
