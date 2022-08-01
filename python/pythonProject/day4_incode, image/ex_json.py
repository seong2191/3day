import json
import  requests
from bs4 import BeautifulSoup
import csv
stock_data = []
for i in range(1, 38):
    url = 'https://sports.news.naver.com/wfootball/record/index?category=epl&year=2021&tab=player'.format(str(1))
    res = requests.get(url)
    soup = BeautifulSoup(res.text, 'html.parser')
    print(soup.text)
    jsonObj = json.loads(soup.text)
    print(jsonObj)
#     stock_list = jsonObj['stocks']
#     for stock in stock_list:
#         stock_data.append([stock['itemCode'], stock['stockName'], stock['closePrice']])
# with open('stock.csv', 'w', encoding='utf-8') as f:
#     write = csv.writer(f, delimiter='|', quotechar='"')
#     for i in stock_data:
#         write.writerow(i)
