# 광학문자인식
# pip install pytesseract
# sudo apt install tesseract-ocr tesseract-ocr-script-hang tesseract-ocr-script-hang-vert
# pip install Image
import re

import pytesseract
import image
eng = pytesseract.image_to_string('./test.gif')
text = re.sub('[\n\|]','', eng).strip()
#print(text)
hangeul = pytesseract.image_to_string('./hangeul.jpeg', lang='Hangul')
text2 = re.sub('[\n\|]','',hangeul).strip()
#print(text2)
num = pytesseract.image_to_string('./num.jpg', lang='Hangul')
print(num)