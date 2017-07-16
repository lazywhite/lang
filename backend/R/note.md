brew install r
Rscript /path/to/file.R

vector包含基本数据类型
list包含Robject

.libPaths() 查看包路径
library() 查看所有可用包

library("package name") 加载包

c(ele1, ele2...) 如果其中有一个元素为character, 则其他元素强制转变为charater

通过下标从vector取元素, 从1开始

R不支持多行注释, 使用下面的技巧
    if(FALSE){
        "multi line comment
        multi line comment"
    }

Robject
    Vectors
        Logical
        Numeriic
        Integer
        Complex
        Character
        Raw

    Lists
    Arrays
    Factors
    Data Frames
    Matrics

Operator
    Arithmetic
        +   
        -
        *
        /
        %% 求余
        %/% 整除
        ^ 指数
    Relational
        >
        <
        ==
        <=
        >=
        !=
    Logical
        完全比较
            &
            |
            !
        仅比较第一个
            &&
            ||
    Assignment
        left assignment
            =
            <-
            <<-
        right assignment
            ->
            ->>
    Miscellaneous
        :       生成序列        v <-  2:8(包含上下边界)
        %in%    成员检测        if(6 %in% v){}
        %*%     矩阵运算        


cat("var is", var, "\n") #打印多个variable
ls() 列出当前可用变量
ls(pattern="var") 列出匹配pattern的所有变量
paste() 字符串拼接
nchar(string) 字符串长度
toupper(string)
tolower(string)
substring(string, first, last)  从1开始计数
charToRaw(string)

.var  隐藏变量
ls(all.name = TRUE) 列出包括隐藏变量的所有变量

rm(.var) 删除变量

if(boolean_expression){
} else if{

} else{

}

switch(expression, case1, case2, case3...)

repeate{
    command
    if(condition){
        break
    }
    if(condition){
        next
    }
}

while(test_expression){
    statement
}
for(value in vector){
    statement
}


LETTERS[1:2]  # [1] "A" "B"
letttters[1:2]  # [1] "a" "b"

func_name <- function(arg1, arg2=default, arg3...){
    statement
}
func_name(arg1=val1, arg3=val3)
返回值是函数体中最后一条表达式的值
函数的参数是lazy evaluatied

built-in function
    seq(20, 30, by=0.5)
    mean(20:30)
    max(20:30)
    min(20:30)
    sum(20:30)
    paste(20:30)

a <- print(20)
print(a) # 20


sort(vector, decreasing=TRUE)  


m = matrix(col(3:14), ncol=4, byrow=FALSE)
m = matrix(col(3:14), nrow=4, byrow=TRUE) 

m[row index, col index] 用下标访问矩阵元素
m[row index,] 获取整行元素
m[,col index] 获取整列元素

t(m) 矩阵的转置

矩阵公理
    A的转置的转置是A
    (KA)的转置等于K倍A的转置, K为实数
    A + B的转置等于A的转置 加 B的转置
    (A * B) 的转置等于 B的转置 乘 A的转置

对称矩阵
    a[i,j] = a[j,i]

矩阵的乘法
    仅当第一个矩阵的列数等于第二个矩阵的行数才有意义
    一个A[m, p] 矩阵 与 B[p, n]矩阵乘积为 C[m, n] 矩阵
    val <- m %*% n

矩阵的除法
    A/B 等于A乘以B的逆矩阵

逆矩阵
    如果AB = BA = E, 则B为A的逆矩阵,  E为单位矩阵的倍数
    如果A有逆矩阵, 则称A为可逆的, 非奇异的
    可逆矩阵一定是n阶方阵
    A的逆矩阵的逆矩阵为A
    |A|为A的行列式的值

伴随矩阵
    A的逆矩阵乘以|A|为伴随矩阵

单位矩阵
    从左上角到右下角的元素全为1, 其他为0



矩阵加减法
    两个矩阵必须有同样的行数和列数


a <- array(c(1:9), dim=c(3,3,2)) 创建两个3x3的矩阵
a[row_index, col_index, matrix_index]
a[,,matix_index]
    


cbind() 用vector创建data frame

