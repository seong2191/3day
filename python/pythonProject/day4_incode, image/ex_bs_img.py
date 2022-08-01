import urllib.request as req
import os
path = os.getcwd()
imgdir = path +'/img/'
if os.path.isdir(imgdir):
    print('폴더있음')
else :
    # 폴더생성
    os.mkdir(imgdir)

url = 'https://search.pstatic.net/common/?src=https%3A%2F%2Fssl.pstatic.net%2Fsstatic%2Fpeople%2F191%2F202206131034174801.png&type=u120_150&quality=95'
req.urlretrieve(url, imgdir + 'top.jpeg')