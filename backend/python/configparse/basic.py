#-*- coding: utf-8 -*-
from configparser import ConfigParser

cfg = ConfigParser()
cfg.optionxform = str # 默认会将key全部转换为lowercase, 添加此配置保持case
cfg.read('config.ini')

'''
默认全部的value被当做字符串处理
c.get         
c.getboolean  
c.getfloat    
c.getint

字符串插值
    BasicInterpolation
        需要在相同section或[DEFAULT]
        %(var)s
    ExtendedInterpolation
        ${var}
        可以跨section

    c = ConfigParser()
    c._DEFAULT_INTERPOLATION = configparser.ExtendedInterpolation
'''
print(cfg.sections())
print(cfg.get('installation', 'library'))
print(cfg.getboolean('debug', 'log_errors'))
cfg.set('server','host','127.0.0.1')
cfg.set('server','port','2000')
cfg['Paths'].get('home_dir')

with open('config.ini','wt') as f:
    cfg.write(f)
