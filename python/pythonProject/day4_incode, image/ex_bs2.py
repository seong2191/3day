from bs4 import BeautifulSoup
from urllib import parse
import  urllib.request as req

# 위키문헌 윤동주
#https://ko.wikisource.org/wiki/%EC%A0%80%EC%9E%90:%EC%9C%A4%EB%8F%99%EC%A3%BC

query = '저자:윤동주'
print('url 인코딩: ', parse.quote(query))
print('url 디코딩: ', parse.unquote('%EC%A0%80%EC%9E%90:%EC%9C%A4%EB%8F%99%EC%A3%BC'))
url = 'https://ko.wikisource.org/wiki/' + parse.quote(query)
# url = 'https://ko.wikisource.org/wiki/' + query <- error
res = req.urlopen(url)
soup = BeautifulSoup(res, 'html.parser')
print(soup.prettify())