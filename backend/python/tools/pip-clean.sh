#!/bin/bash
# 默认pip uninstall不会自动删除依赖包
pip show $1|grep Requires|sed 's/Requires: //g; s/,//g'|xargs pip uninstall -y $1
