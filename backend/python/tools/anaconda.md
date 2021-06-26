1. 下载安装包
https://mirrors.tuna.tsinghua.edu.cn/anaconda/archive/

2. 设置国内源
.condarc
    channels:
      - https://mirrors.aliyun.com/pypi/simple/
      - defaults
    show_channel_urls: true

3. 使用
conda update <package> # 升级包
conda list # 列出软件包
conda install scikit-learn # 安装包
conda install scikit-learn --no-update-dependencies# 跳过依赖升级

conda-env list # 列出所有环境
conda env create --name user/ml python=3.6 # 建立新环境

source activate ml # 进入conda环境
source deactive # 离开环境
