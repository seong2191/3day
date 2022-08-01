import os
root = '/'
for dirpath, dirname, filenames in os.walk(root):
    print(dirpath, dirname, filenames)