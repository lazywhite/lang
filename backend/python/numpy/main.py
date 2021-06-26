# -*- coding: utf-8 -*-
import numpy as np
'''
tips
    np.set_printoptions(threshold='nan') # 默认打印有省略
    一个ndarray只存储一种类型的元素
    broadcast: 为了满足矩阵运算, 在特定情况下改变array shape
    b = np.view(a) 浅拷贝
    b = np.copy(a) 深拷贝
    np.random.random() # 一个随机float number
    a = np.random.randn(5, 3) #  5行3列
    a = np.random.randint(5, 15, size=(2, 4)) # 2行4列随机整数

np.r_
np.c_

np.newaxis
np.nan 

主要功能
    多维数组计算
    线性代数
    针对shape的傅里叶变换

ndarray attribute
    rank
    axes
    ndim 维数    行数
    shape 维度   (行数, 列数)
    size 元素数
    dtype 每个元素的类型
        itemsize 每个元素的大小
        name 类型名称
    data 存储的所有元素
    flags

ndarray manipulation
    change shape
        reshape()
        flat # 迭代器
        flatten() 
        ravel()
    transpose operations
        transpose()
        T
        rollaxis
        swapaxes
    change dimensions
        broadcast()
        broadcast_to()
        expand_dims
        squeeze
    joining array
        vstack((a, b) 垂直合并
        hstack((a, b)) 水平合并
        column_stack(a, b) 将两个1维数组合并为二维数组
        concatenate((a, b, b, a))
    splitting
        split
        hsplit
        vsplit
    add remove elements
        resize
        append
        insert
        delete
        unique


dtype
    bool
    inti 由平台决定
    float16
    float32
    float64 float 
    int8
    int16
    int32
    int64
    uint8
    uint16
    uint64
    complext64
    complext128 complex
    string

String dtype method
    add()
    multiply()
    center()
    capitalize()
    title()
    lower()
    upper()
    split()
    splitlines()
    strip()
    join()
    replace()
    decode()
    encode()



数学运算
    一元
        np.power(a, 2)
        np.ceil(a)
        np.floor(a)
        np.sqrt(a)
        np.exp(a)
        np.log(a)
        np.nonzero(a) 输出非0的元素的坐标
        np.diff(a) 相邻元素相差

    二元
        np.add(a, b)
        np.add(a, b)
        np.subtract(a, b)
        np.multiply(a, b)
        np.divide(a, b)

    三角函数
        np.sin()
        np.cos()
        np.tan()
        np.cot()
        np.arcsin()
        np.arccos()
        np.degrees() # 将数值转化为角度
    统计
        np.ptp(a, axis=n) 返回最大值减去最小值
        np.cumsum() 累加, 元素个数与array相同
        np.max(a, axis=0) # axis=0按列, axis=1按行
        np.min(a, axis=0) # 
        np.percentile()
        np.median() 中间值, 必定为某元素
        np.mean() 平均值
        np.average() 带权重的平均值
        np.sum()
            a.sum(axis=0)) # 按列和
            a.sum(axis=1)) # 按行和
        
        np.var()  sqrt(mean(abs(x - x.mean())**2))
    sort, search, count
        sort()
        argsort()
        lexsort()
        argmax()
        argmin()
        nonzero()
        where()
        extract()

    矩阵运算
        dot()
        vdot()
        inner()
        matmul()
        determinant
        solve()
        inv()

构造ndarray
    np.empty()
    np.zeros()
    np.ones()
    np.asarray(list)
    np.frombuffer()
    np.arange()
    np.fromiter()
    np.logspace()
    np.linspace()
    np.fromfunction()
        def f(x, y):
            return x * y

        a = np.fromfunction(f, (3, 3), dtype=np.int) # 将元素的坐标作为输入



导入导出
    np.save_text("file", array)
    b = np.load_text("file")
    np.save("file", array)
    array = np.load("file")

遍历
    np.nditer(a)
'''


