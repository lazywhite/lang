# -*- coding: utf-8 -*-
'''
pip install xlrd
'''
import sys
reload(sys)
sys.setdefaultencoding('utf-8')
import xlrd
import sys
target = sys.argv[1]
excel = xlrd.open_workbook(target)

sheets_num = len(excel.sheets())
'''
col, row均从0开始计算
'''

for x in xrange(sheets_num):
    sheet = excel.sheets()[x]

    for i in xrange(0, sheet.nrows):
        data = sheet.row_values(i)
        print data

