#-*- coding: utf-8 -*-
from configparser import ConfigParser, ExtendedInterpolation

cfg = ConfigParser(interpolation=ExtendedInterpolation())

cfg.read("extend.ini")
print(cfg.get("hdfs", "data_path"))
