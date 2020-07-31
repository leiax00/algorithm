# coding=utf-8
import os
import sys

custom_paths = []

work_path = os.getcwd()
custom_paths.append(work_path)

sys.path.extend(custom_paths)
print('aaaa:', custom_paths)
print(sys.path)
