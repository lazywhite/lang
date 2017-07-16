# 线性回归
# y = ax + b
# y 因变量, x 自变量, a  b 为系数


# The predictor vector.
x <- c(151, 174, 138, 186, 128, 136, 179, 163, 152, 131)

# The resposne vector.
y <- c(63, 81, 56, 91, 47, 57, 76, 72, 62, 48)

# Apply the lm() function.
relation <- lm(y~x)

print(relation)
print(summary(relation))

# 结果预测
a <- data.frame(x = 170)
result <-  predict(relation,a)
print(result)
