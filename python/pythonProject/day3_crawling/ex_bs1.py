# -*- coding:utf-8 -*-
from bs4 import BeautifulSoup
import requests

url = 'https://movie.naver.com/movie/point/af/list.naver?&page=1'
resp = requests.get(url)
print(resp)
print(resp.text)

soup = BeautifulSoup(resp.text, 'html.parser')
# print(soup)
# 구조화되게 출력
# print(soup.prettify())
table = soup.select_one('.list_netizen')
print(table)
trs = table.find_all('tr')
# 제목, 평점, 상세url, 댓글
for tr in trs:
    a = tr.select_one('.title a ')
    if a:
        title = a.text
        url = a.get('href')
        em = tr.select_one('.list_netizen_score em')
        score = em.text

        print(title, score, url)

        td = tr.select_one('.title')
        text_tag = str(td).split('<br/>')
        if len(text_tag) > 1:
            msg = text_tag[1].split('\n')
            reply = msg[0].strip()
        else:
            pass
        user = tr.select_one('.author').text
        aaa = tr.find_all('td')[2]
        date_tag = str(tr.find_all('td')[2]).split('<br/>')
        if len(date_tag) > 1:
            date = date_tag[1].replace('<td>','')
            info = "제목:{0} "
        print('제목:',title, '영화평가:',reply, '평점:',score, '상세정보:', url, 'id:',user)

print("="*100)
for tr in trs:
    a= tr.select_one('.num .author')

    if a:
        name = a.text
        print(name)

for tr in trs:
    a = tr.select_one('.num ')
    if a:
        td = tr.select_one('.num')
        text_tag = str(td).split('<br/>')
        if len(text_tag) > 1:
            msg = text_tag[1].split('\n')
            reply = msg[0].strip()
        else:
            pass
        user = tr.select_one('.author').text
        print('제목:', title, '영화평가:', reply, '평점:', score, '상세정보:', url, 'id:', user)

