import os
root = os.getcwd()
def fn_remove_file(file_nm):
    file_list = os.listdir(root)
    for file in file_list:
        if file_nm in file:
            msg = input(file + ' 을 삭제할까요?(y/n) 종료 (q)')
            if msg.lower() == 'y':
                remove_file = os.path.join(root, file)
                print('='*100)
                os.remove(remove_file)
                print(remove_file)
                print('삭제함', '=' * 95)
            elif msg.lower() == 'n':
                pass
            elif msg.lower() == 'q':
                print('취소됨.')
                break
            else:
                print('다시 입력하세요')
    print('해당 폴더에 없음')
    print('종료 :','=' * 100)
if __name__ == '__main__':
    fn_remove_file('test')





