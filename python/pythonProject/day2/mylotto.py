import random

def fn_lotto(num):
    lotto_list = []
    for i in range(num):
        lotto_num = set()
        while len(lotto_num) < 6:
            lotto_num.add(random.randint(1, 45))
        lotto_list.append(lotto_num)

    return lotto_list

if __name__ == '__main__':
    print('자체 실행')
    print(fn_lotto(3))
else:
    print('다른 곳에서 실행')