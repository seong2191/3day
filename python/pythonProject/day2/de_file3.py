import os
root = '/'
# 재귀함수
def fn_search_file(path):
    try:
        path_list = os.listdir(path)
        for file in path_list:
            file_path_nm = os.path.join(path, file)
            if os.path.isdir(file_path_nm):
                fn_search_file(file_path_nm)
            else:
                print(file_path_nm)
    except Exception as e:
        print(str(e))

fn_search_file(root)