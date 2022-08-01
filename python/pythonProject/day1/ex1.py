import random
print('='*10, ' 로또 생성기','='*10)
num = int(input('로또 수량을 입력하세요:'))
for i in range(num):
    lotto = set()
    while len(lotto) < 6:
        ran = random.randint(1, 45)
        lotto.add(ran)
    print(lotto)
print('='*10, ' 행운을 빌어요','='*10)
