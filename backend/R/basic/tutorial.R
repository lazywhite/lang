## 注释以'#'开头
print("hello") # 打印语句
#install.packages("plotrix")  # 安装模块
myString <- "hello"  # 变量赋值


apple <- c("red", "green", "yellow")
print(apple)
print(class(apple))


# list
lits <- list(c(1, 3, 4 , 5), TRUE, 21.3, sin)
print(lits)
print(class(lits))

# matrics, two-dimensional rectangular data set 
M = matrix(c('a', 'b', 'c', 'd', 'e', 'f'), nrow=2, ncol=3, byrow=TRUE)
print(M)
print(class(M))

# array: any number of dimensions
a <- array(c("green", "blue"), dim=c(3, 3, 3))
print(a)



# factors: vector and distincct value of elements in the vector
apple_colors <- c('green','green','yellow','red','red','red','green')
factor_apple <- factor(apple_colors)
print(factor_apple)
print(nlevels(factor_apple))  

# data frames: a list of vectors of equal length
BMI <- 	data.frame(
   gender = c("Male", "Male","Female"),
   height = c(152, 171.5, 165),
   weight = c(81,93, 78),
   Age = c(42,38,26)
)
print(BMI)
print(class(BMI))

