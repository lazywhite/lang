class BSTreeNode:
    def __init__(self,value=None,left=None,right=None):
        self.value=value
        self.left=left
        self.right=right

def ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3):
    pNodeA1.left=pNodeA2
    pNodeA1.right=pNodeA3

########################################################################
##                    编程之美1.1让cpu曲线听你指挥                       ##
########################################################################
## 解法一：让cpu跑idle和busy两个不同的循环，控制时间比例，busy可用空循环，idle可
##        用sleep()
import time
def algorithm1():
    while True:
        #调整适当的n,运行时间也是0.01秒,这个n不对
        for i in range(9600000):
            pass
        time.sleep(0.01)

def algorithm2():
    busytime=0.02
    idletime=0.01
    while True:
        startTime=time.time()
        while time.time()-startTime<busytime:
            print(time.time()-startTime)
        time.sleep(idletime)

import math
def algorithm3():
    count=200#抽样频率
    busy=[0]*count
    idle=[0]*count
    for i in range(count):
        busy[i]=(1+math.sin(math.pi*i*2/count))/count#0~2之间－》0~0.01之间
        idle[i]=0.01-busy[i]
    j=0
    while True:
        startTime=time.time()
        j=j%200
        while time.time()-startTime<busy[j]:
            print(time.time()-startTime)
        time.sleep(idle[j])
        j=j+1

def test1_1():
    #algorithm1()
    #algorithm2()
    algorithm3()

########################################################################
##            编程之美1.2输出将帅的所有位置(只能用一个变量)                 ##
########################################################################
def getPosition():
    #假设A,B的位置为0～9,把B放在10位上
    #1 2 3
    #4 5 6
    #7 8 9
    for i in range(11,100):
        if (i%10==0) or i%10%3==(i//10)%3:
            continue
        print('B:{},A:{}'.format(i%10,i//10))

def test1_2():
    getPosition()

########################################################################
##                    编程之美1.3 翻转烙饼，使其有序                      ##
########################################################################
# 注意这里不是一般的排序问题，max的位置你是知道的，只能用'翻转'操作
# 考虑这样一种算法，把最大的那个烙饼翻到最下面需要2次操作，完成之后，对上面的n-1的烙饼
#                重复这一算法，这样最多只要2(n-1)次操作就可以完成


class CPrefixSorting:

    def __init__(self,pCakeArray,nCakeCnt):
        self.m_nCakeCnt=nCakeCnt#烙饼个数
        self.m_nMaxSwap=self.UpBound(nCakeCnt);#最多交换次数。根据前面的推断，这里最多为m_nCakeCnt * 2
        self.m_CakeArray=list(pCakeArray)#烙饼信息数组
        self.m_SwapArray=[0]*self.m_nMaxSwap#交换结果数组
        self.m_ReverseCakeArray=list(pCakeArray)#当前翻转烙饼信息数组
        self.m_ReverseCakeArraySwap=[0]*self.m_nMaxSwap#当前翻转烙饼交换结果数组
        self.m_nSearch=0#当前搜索次数信息


     # 计算烙饼翻转信息
     # @param
     # pCakeArray	存储烙饼索引数组
     # nCakeCnt	烙饼个数
     #
    def Run(self):
        self.Search(0)

     # 输出烙饼具体翻转的次数
    def Output(self):
        print(self.m_ReverseCakeArray)
        print(self.m_ReverseCakeArraySwap[0:self.m_nMaxSwap])
        print("\n |Search Times| : %d\n"%self.m_nSearch);
        print("Total Swap times = %d\n"%self.m_nMaxSwap);


    # 寻找当前翻转的上界
    def UpBound(self,nCakeCnt):
         return nCakeCnt*2

    # 寻找当前翻转的下界
    def LowerBound(self,pCakeArray,nCakeCnt):
        ret = 0
        # 根据当前数组的排序信息情况来判断最少需要交换多少次
        for i in range(1,nCakeCnt):
               # 判断位置相邻的两个烙饼，是否为尺寸排序上相邻的
            t = pCakeArray[i] - pCakeArray[i-1];
            if (t == 1) or (t == -1):
                pass
            else:
                ret+=1
        return ret


     # 排序的主函数
    def Search(self,step):
        #print('step:%d'%step)
        self.m_nSearch+=1

        # 估算这次搜索所需要的最小交换次数
        nEstimate = self.LowerBound(self.m_ReverseCakeArray,self.m_nCakeCnt)
        #print('lower bound:%d'%nEstimate)
        if (step + nEstimate >= self.m_nMaxSwap):
            return

        # 如果已经排好序，即翻转完成，输出结果
        if self.IsSorted(self.m_ReverseCakeArray,self.m_nCakeCnt):
            print('find min step:%d'%step)
            self.m_nMaxSwap = step;
            self.Output()
            return


        # 递归进行翻转
        # 这里是一个遍历的枚举算法，枚举出每个可能的交换方式，然后剪枝
        for i in range(1,self.m_nCakeCnt):
            #print('change:%d'%i)
            #依次交换
            self.Revert(0, i)
            self.m_ReverseCakeArraySwap[step] = i
            #递归的操作子序列
            self.Search(step + 1)
            #注意完成之后要还原，继续搜索
            self.Revert(0, i)

     # true : 已经排好序
     # false : 未排序
    def IsSorted(self,pCakeArray,nCakeCnt):
        for i in range(1,nCakeCnt):
            if(pCakeArray[i-1] > pCakeArray[i]):
               return False
        return True


    # 翻转烙饼信息
    def Revert(self, nBegin,nEnd):
        if nBegin>=nEnd:
            return
        self.m_ReverseCakeArray[nBegin:nEnd+1]=reversed(self.m_ReverseCakeArray[nBegin:nEnd+1])
        #print(self.m_ReverseCakeArray)

def test1_3():
    a=CPrefixSorting([3,2,1,6,5,4,9,8,7,0],10)
    a.Run()




########################################################################
##                    编程之美1.4 买书问题                               ##
########################################################################
# 共5种，每本8块，买2本不同的书折扣5%，3本10%，4本20%，5本25%，
# 同一种折扣规则只能使用一次：也即：
# 如果买了2本1，一本2，那么最多只能对其中一本1和一本2使用5%折扣，另一本1就不能折扣了
# 这里贪心策略行不通
# 算法一 动态规划，缩小为较小的子问题
Recount=[1,0.95,0.9,0.8,0.75]#折扣
def buyBook(inputList):
    #如果有一个<0
    sortedInputList=sorted(inputList,reverse=True)
    if sortedInputList[0]<0:
        return 99999
    #如果有0或者1
    #买得最多的那本数量
    maxBookCount=sortedInputList[0]
    if maxBookCount==0:
        return 0
    if maxBookCount==1:
        #print('buy:',end='')
        #print(sortedInputList)
        count=sortedInputList.count(1)
        return count*8*Recount[count-1]
    a,b,c,d,e=sortedInputList
    return min([buyBook([1,0,0,0,0])+buyBook([a-1,b,c,d,e]),
                buyBook([1,1,0,0,0])+buyBook([a-1,b-1,c,d,e]),
                buyBook([1,1,1,0,0])+buyBook([a-1,b-1,c-1,d,e]),
                buyBook([1,1,1,1,0])+buyBook([a-1,b-1,c-1,d-1,e]),
                buyBook([1,1,1,1,1])+buyBook([a-1,b-1,c-1,d-1,e-1])])

def test1_4():
    print(buyBook([2,2,2,1,1]))


########################################################################
##                    编程之美1.5 快速找出故障机器                        ##
########################################################################
# 如果仅有一台机器出了故障，可以使用找异或值的方法，只需要存一个变量
def findOneBroken(alist):
    result=0
    for i in range(len(alist)):
        result=alist[i]^result
    return result
# 如果两台机器出了故障且是不同的
def findTwoBrokenDiff(alist):
    tempresut=findOneBroken(alist)
    numer=findnumber(tempresut)
    result1=0
    result2=0
    #分成两类，这个位数上是一的和不是一的
    for i in range(len(alist)):
        if alist[i]&numer==0:
            result1=alist[i]^result1
        else:
            result2=alist[i]^result2
    return result1,result2

# 一个二进制数最低的一个为1的位数，并且提取出来
def findnumber(i):
    k=0
    endNumer=i&1
    while endNumer!=1:
        k+=1
        endNumer=(i>>1&1)
    return 1<<k

from functools import reduce
#使用'不变量的方法求解'，总的id和减去剩下的就是坏掉的id和x+y=a
#如果两个id不同还需要一个方程可以用x*y=b
def findbrokenWithEquation(origin,now):
    originSum=sum(origin)
    nowSum=sum(now)
    originMul=reduce(lambda x,y:x*y,origin)
    nowMul=reduce(lambda x,y:x*y,now)
    a=originSum-nowSum
    b=originMul/nowMul
    return (a+math.sqrt(a**2-4*b))/2,abs(a-math.sqrt(a**2-4*b))/2


def test1_5():
    print(findOneBroken([1,1,2,2,3,4,4,5,5,6,6]))
    print(findTwoBrokenDiff([1,1,2,2,3,4,5,5,6,6]))
    print(findbrokenWithEquation([1,1,2,2,3,3,4,4,5,5,6,6],[1,1,2,2,3,4,5,5,6,6]))
    print(findbrokenWithEquation([1,1,2,2,3,3,4,4,5,5,6,6],[1,1,2,2,4,4,5,5,6,6]))
    print(findnumber(6))



########################################################################
##                    编程之美1.6 饮料供货                             ##
########################################################################
# 饮料的总容量有上限V，求一种组合使得总满意度最大
# 结果第k种饮料的数量＊满意度＋减去第k种饮料的最优结果
#  使用动态规划，并且可以纪录子问题的解


# 子问题的记录项表，假设从i到T种饮料中，
                            	# 找出容量总和为V'的一个方案，满意度最多能够达到
                           	# opt（V'，i，T-1），存储于opt[V'][i]，
                           	# 初始化时opt中存储值为-1，表示该子问题尚未求解

opt=[]
def Cal(V,type,C,H,T):
    global ret
    print(ret)
    #最多T种饮料
    if type == T:
        if V==0:
            return 0
        else:
            return -9999

    if V < 0:
        return -9999
    elif(V == 0):
          return 0
    elif(opt[V][type] != -1):
          return opt[V][type]    	# 该子问题已求解，则直接返回子问题的解；
                                 	# 子问题尚未求解，则求解该子问题
    temp=0
    for i in range(C[type]):
        #去掉一种饮料算子问题的最优解
        #去掉的方法有0～C[type]（这种饮料的最大值）种，取这几种结果中最大的
        temp = Cal(V-i*C[type],type-1)
        print(temp)
        if(temp != -9999):
            temp += H[type] * i
            if(temp > ret):
                ret = temp
    opt[V][type]=ret
    return ret


def memoize(f):
    memo = {}
    def helper(a,b,c,d,e):
        if (a,b) not in memo:
            memo[(a,b)] = f(a,b,c,d,e)
        return memo[(a,b)]
    return helper

def test1_6():
    V=10#总容量
    T=10#T种饮料
    type=T
    ret=0
    opt=[[-1]*(V+1)]*(T+1)
    C=[100]*T
    H=[100]*T
    m_Cal=memoize(Cal)
    print(m_Cal(1000,T,C,H,T))


########################################################################
##                    编程之美1.7 光影切割问题                          ##
########################################################################
# 此算法的核心是先寻找分块数和交点数的关系式，然后可以发现交点数就是和边界交点次序的
# 逆序数，从而问题转发为逆序数问题

#寻找逆序数
#逆序数是归并排序的副产品
num = 0
def merge_sort(data):
    if (len(data)<=1):
        return data
    index  =  len(data)//2
    lst1 = data[:index]
    lst2 = data[index:]
    left = merge_sort(lst1)
    right = merge_sort(lst2)
    return merge(left, right)

#这里merge算法不是很高效，待改
def merge(lst1, lst2):
    """to Merge two list together"""
    list = []
    while(len(lst1)>0 and len(lst2)>0):
        data1 = lst1[0]
        data2 = lst2[0]
        if (data1<=data2):
            list.append(lst1.pop(0))
        else:
            global num
            num = num + len(lst1)
            list.append(lst2.pop(0))
    if(len(lst1)>0):
        list.extend(lst1)
    else:
        list.extend(lst2)
    return list

def test1_7():
    merge_sort([4,3,2,1])
    print(num)


########################################################################
##                    编程之美1.8 电梯算法                             ##
########################################################################
# 电梯只停一层楼，停在哪里乘客要爬楼梯最少
# 此题的关键在于寻找delta函数，如果停在i层楼，要爬总数是Y层，有N1,N2,N3分别指实际目标
# 在i层之下，i层，i层之上,那么停在i+1层要爬Y+N1+N2-N3，i-1层:Y-N1+N2+N3，可以看出
# 当N1+N2-N3<0的时候应改i+1,N2+N3-N1<0->i-1;=0,i不变，因此只要找到这样的i,使得
# N1+N2-N3>=0;N2+N3-N1>=0


def findFloor(alist):
    for i in range(len(alist)):
        N1=sum(alist[:i])
        N2=alist[i]
        N3=sum(alist[i+1:])
        if N1+N2-N3>=0 and N2+N3-N1>=0:
            return i

def test1_8():
    print(findFloor([4,0,3,2,1,0,4,0,8]))


########################################################################
##                 编程之美1.9 高效率地安排见面会                        ##
########################################################################
# 如四个见面会起止时间分别为A[1,5],B[2,3],C[3,4],D[3,6]求最少需要安排多少面试地点
# （多少人来面试?）
# 最优的算法是把开始时间结束时间都排序，遍历时遇到一个B(开始时间)m+1;遇到一个E:m-1
# 这样m遍历过程中的最大值就是解
def findMinPlace(list):
    total=[]
    for item in list:
        total.append((item[0],'B'))
        total.append((item[1],'E'))
    total=sorted(total,key=lambda x:x[0])
    print(total)
    m=0
    maxm=0
    for i in range(len(total)):
        if total[i][1]=='B':
            m+=1
            if m>maxm:
                maxm=m
        else:
            m-=1

    return maxm





#如果是一对于的问题，即n个学生对m个项目中的一个或者几个感兴趣，怎样安排可以使得项目介绍 的总时间最短
# 这个是典型的图的着色问题，对于图使用最少的颜色使得对于任何一个边，边的两个顶点颜色都不一样
# 两个典型的解法：1.回溯法 2.贪心法
# 1.回溯法,输入n个点，m个颜色，m从低到高看有没有解，可以找到最小的解m

def ColorOk(k,G,color): #判断顶 点k的着⾊色是否发⽣生冲突
    for i in range(k):
        if G[k][i]==1 and color[i]==color[k]:
            return False
    return True


def GraphColor(n,m,G):
    color=[0]*n
    k=0
    while k>=0:
        color[k]=color[k]+1
        while color[k]<=m:
            if ColorOk(k,G,color):
                break
            else:
                color[k]=color[k]+1#搜索下一个颜⾊
        if color[k]<=m and k==n-1: #求解完毕,输出解
            print(color)
            return
        elif(color[k]<=m and k<n-1):
            k=k+1 #处理下⼀一个顶点
        else:
            color[k]=0;
            k=k-1; #回溯



def ColorOk2(i,k,n,G,color): #判断顶 点k的着⾊色是否发⽣生冲突
    for j in range(n):
        if G[i][j]==1 and color[j]==k:
            return False
    return True

#贪心法
def GraphColor2(n,G):
    color=[0]*n
    color[0]=1
    k=1
    while color.count(0)!=0:
        for i in range(n):
            if color[i]==0 and ColorOk2(i,k,n,G,color):
                color[i]=k
        k+=1
    print(k,color)


def test1_9():
    print(findMinPlace([[1,5],[2,3],[3,4],[3,6]]))




    G=[[1,1,1,0,0],
       [1,1,1,1,1],
       [1,1,1,0,1],
       [0,1,0,1,1],
       [0,1,1,1,1]]
    GraphColor(5,3,G)#m最小是3的时候有解，说明m最小可以是3
    GraphColor2(5,G)#找到的不是最优解



########################################################################
##                        编程之美1.11-1.13 取石头                         ##
########################################################################
#1.11
#每次取一个或者两个相邻的，求必胜策略
#取中间的一个（奇数），或中间两个（偶数），这样对手取任何石头，取他对称的石头即可

#1.12 A分堆，B先取
#关键是找出安全局面：（1，1）是安全局面，先取的输
#                =>(1,x) x>1不是安全局面，因为对手可以一步转化为自己的安全局面
#                =>(m,m) m>1 是安全局面 因为对手怎么取，都不能一步变成安全局面，循环不变式
# 所以N为偶数的时候，分成两堆相同的，可以保证自己赢
# N是奇数的时候，(1,1,1)是非安全局面
#              (1,1,x)是非安全局面
#              (1,2,x)是安全局面
#              (1,x,x)是非安全局面对手取1，（x,x）安全
#              (1,x,y)x!=y 是非安全局面，因为对手可以转换为(1,2,x)
#


#1.13 有两堆石头，可以从两堆取等数量，或者其中一堆取任意

########################################################################
##                        编程之美1.14 连连看                         ##
########################################################################
# 算法的核心是广度优先搜索，对于A一步可以到达的领域集合中如果有有A',那么A，A'距离为0转折
#  对于A一步可以到达的空格子的领域集合中如果有A'，那么距离为1转折｀｀｀｀｀`````



########################################################################
##                        编程之美1.15 数独                          ##
########################################################################
# 见C++程序

########################################################################
##                        编程之美1.16 24点                          ##
########################################################################
#递归算法
# 见C＋＋程序


########################################################################
##                   编程之美2.1 求二进制数字中1的个数                    ##
########################################################################

#1.求余数的方法
def findOnes(number):
    sum_one=0
    while number:
        sum_one+=number%2
        number=number//2
    return sum_one

#2.位操作方法，思路同上，只是表述不一样
def findOnes2(number):
    sum_one=0
    while number:
        sum_one+=number&0x1
        number=number>>1
    return sum_one

#3.位操作，基于这样的常用方法：使得一个二进制数a最低的1变成0方法是；a＝a&（a-1）
def findOnes3(number):
    sum_one=0
    while number:
        number=number&(number-1)
        print(number)
        sum_one+=1
    return sum_one

#4. 查表法，既然是8位二进制数，直接把256个结果存在一个字典里就可以了
# 算法略


#5 算法5 用1，不断移动来看每一位上是不是1
def findOnes5(number):
    k=1
    sum_one=0
    for i in range(1,32):
        if number&k:
            sum_one+=1
        k=k<<1
    return sum_one

def test2_1():
    print(findOnes3(7))
    print(findOnes5(7))

########################################################################
##                       编程之美2.2 不要被阶乘吓倒                      ##
########################################################################
#1.求N！二进制表示中末尾0的个数
# 分析后发现，只要求5的指数次数即可
def endZeros(numberN):
    ret=0
    while numberN:
        ret+=numberN//5
        numberN=numberN//5
    return ret

#由于python不会溢出，可以用这个算法验证结果
def endZeros2(numberN):
    ret=0
    resultN=reduce(lambda x,y:x*y,range(1,numberN+1))
    print(resultN)
    while resultN%10==0:
        ret+=1
        resultN=resultN//10
    return ret

#2.求N！二进制表示中最低位1的位置
# 首先看一个二进制数，最低的1的位置就是可以被2整除的次数＋1，（不能整除说明最后一位是1了）
# 这样就转化成求N！中质因数2的个数，即N/2+N/4+```
def findLowestOne(numberN):
    ret=0
    while numberN:
        numberN=numberN>>1
        ret+=numberN
    return ret


#由于python不会溢出，可以用这个算法验证结果
def findLowestOne2(numberN):
    ret=0
    resultN=reduce(lambda x,y:x*y,range(1,numberN+1))
    while resultN%2==0:
        ret+=1
        resultN=resultN>>1
    return ret

def test2_2():
    print(endZeros(100))
    print(endZeros2(100))
    print(findLowestOne(100))
    print(findLowestOne2(100))

########################################################################
##                       编程之美2.3 寻找水王                           ##
########################################################################
# 水王发帖的数量大于N/2找到他
# 思路核心是大于N/2，那么删除掉两个不一样的，剩下的还是大于N/2,
# 如果给他计数那么，不一样的－1，一样的＋1，那么水王的id一定能>1

def findMostCommon(list):
    tempResult=0
    countOfTempResult=0
    for item in list:
        if countOfTempResult==0:
            tempResult=item
        if item==tempResult:
            countOfTempResult+=1
        else:
            countOfTempResult-=1
    return tempResult

#算法二 用一个hash表保存频数
#算法三 既然>N/2,那么如果找出数组第N/2 大的数，那么这个数就是频数大于N/2的数
#所以算法就转换成了O(N)算法的寻找第k大数


import  random
def Partition(alist,start,end):
    index=random.randint(start,end)
    alist[index],alist[end]=alist[end],alist[index]
    small=start-1
    index=start
    while index<end:
        if alist[index]<alist[end]:
            small+=1
            if small!=index:
                alist[small],alist[index]=alist[index],alist[small]
        index+=1
    small+=1
    alist[small],alist[end]=alist[end],alist[small]
    return small

def findKLargest(alist,begin,end,k):
    mid=Partition(alist,begin,end)
    if mid==k:
        return alist[k]
    elif mid>k:
        return findKLargest(alist,begin,mid-1,k)
    else:
        return findKLargest(alist,mid+1,end,k-mid)


def test2_3():
    print(findMostCommon([1, 2, 3, 4, 2, 5, 2, 2, 3, 2, 5, 2]))
    print(findKLargest([1, 2, 3, 4, 2, 5, 2, 2, 3, 2, 5, 2],0,11,6))


########################################################################
##                       编程之美2.4  1的数目                           ##
########################################################################
# 找出1.....N中N个数字中1的数目：如1,2,3,4,5,6,7,8,9,10,11,12 中有5个1

# 算法1，直接遍历求解，复杂度为O(N*logN)
def findOnesToN(numberN):
    def findOnesOfN(numberN):
        ret=0
        while numberN:
            ret+=(numberN%10==1)
            numberN=numberN//10
        # print(ret)
        return ret
    ret=0
    for i in range(1,numberN+1):
        ret+=findOnesOfN(i)
    return ret


# 算法2，1的个数为个位1+十位1+...
def findOnesToN2(n):
    iCount = 0
    iFactor = 1

    iLowerNum = 0
    iCurrNum = 0
    iHigherNum = 0

    while n // iFactor:
        #低位，当前位，高位
        iLowerNum = n - (n //iFactor) * iFactor
        iCurrNum = (n // iFactor) % 10
        iHigherNum = n // (iFactor * 10)

        if iCurrNum==0:
            iCount += iHigherNum * iFactor
        elif iCurrNum== 1:
            iCount += iHigherNum * iFactor + iLowerNum + 1
        else:
            iCount += (iHigherNum + 1) * iFactor

        iFactor *= 10

    return iCount



def test2_4():
    print(findOnesToN(12))
    print(findOnesToN2(99))


########################################################################
##                    编程之美2.5 数组中k个最大的数                      ##
########################################################################
#算法一 排序
def findKMax(list,k):
    return sorted(list)[-k:]

import random
#算法二 递归算法
#递归的分成两组，Sa,Sb其中Sa中的元素都小于Sb
def patition(list):
    a=list[len(list)//2]
    Sa=[]
    Sb=[]
    for item in list:
        if item>=a:
            Sa.append(item)
        else:
            Sb.append(item)
    return (Sa,Sb)

def findKMax2(list,k):
    if k<=0:
        return []
    if len(list)<=k:
        return list
    Sa,Sb=patition(list)

    a=findKMax2(Sa,k)
    b=findKMax2(Sb,k-len(Sa))
    # print(a,b)
    return a+b


#算法三 使用一个长度为k的最小堆作为数据结构保存最大的k个数
# 保持堆性质，对于位置i
def min_heapify(list,i):
    K=len(list)
    p=i#父亲节点
    while i < K:
        # 左儿子
        q = 2 * p + 1
        if q >= K:
            break
        # 如果有右儿子而且有儿子更小
        if q < K-1  and  list[q + 1] < list[q]:
            q = q + 1;
        if list[q]< list[p]:#违反堆性质
            list[p],list[q] = list[q],list[p]#交换
            p = q
        else:
            break

def build_Heap(list):
    i=len(list)//2
    while i>=0:
        min_heapify(list,i)
        i-=1
    return list

def findKMax3(list,k):
    heap=list[:k]
    heap=build_Heap(heap)
    for item in list[k:]:
        if item<=heap[0]:
            break
        else:
            heap[0]=item
            min_heapify(heap,0)
    return heap

#算法四 桶排序，计数排序的思想
def findKMax4(list,k):
    numCount=[0]*len(list)
    for item in list:
        numCount[item]+=1
    result=[]
    sumCount=0
    i=len(numCount)-1
    while sumCount<=k:
        sumCount+=numCount[i]
        result.extend([i]*numCount[i])
        i-=1
    return result


def test2_5():
    alist=list(range(20000))
    # print(findKMax(alist,10))
    # print(findKMax2(alist,10))
    # print(build_Heap([23,2,12,2,43,5,3,6,7]))
    print(findKMax3(alist,20))
    print(findKMax4(alist,20))


########################################################################
##                    编程之美2.6 精确表示浮点数                        ##
########################################################################
# 得出推导公式 10^m*Y-Y=b1b2..bm


########################################################################
##                    编程之美2.7 最大公约数问题                        ##
########################################################################
# 基本解法：辗转相除法
def gcd(a,b):
    if b==0:
        return a
    else:
        return gcd(b,a%b)


# 解法2：大整数取模消耗较大，考虑到x>y，的时候 f(x,y)＝f(x-y,y)这样可以化成小整数求解
# 但是缺点是迭代次数变多了
def bigIntGcd(a,b):
    if a<b:
        return bigIntGcd(b,a)
    if b==0:
        return a
    else:
        return bigIntGcd(a-b,b)



# 算法3:对偶数除以2，减小运算次数
def isEven(n):
    return n&1==0


def bigIntGcd2(a,b):
    if a<b:
        return bigIntGcd(b,a)
    if b==0:
        return a
    else:
        if isEven(a):
            if isEven(b):
                return bigIntGcd2(a>>1,b>>1)<<1
            else:
                return bigIntGcd2(a>>1,b)
        else:
            if isEven(b):
                return bigIntGcd2(a,b>>1)
            else:
                return bigIntGcd2(a-b,b)



def test2_7():
    print(gcd(36,27))
    # print(bigIntGcd(131111811222,2131112))
    print(bigIntGcd2(131111811222,2131112))


########################################################################
##                    编程之美2.8 找符合条件的整数                       ##
########################################################################
# 给定一个正整数N，求最小正整数M使得N＊M十进制表示中只有0或1
# 遍历X

import itertools
def findM(n):
# 算法会重复遍历，待改进
    i=0x1
    while i<99999999999:
        b=int('{0:b}'.format(i))
        if b%n==0:
            return b,b//n
        i+=1

def test2_8():
    print(findM(99))


########################################################################
##               编程之美2.10 寻找数组中的最大最小值                     ##
########################################################################
# 1.如果看成独立的两个问题，至少需要2N次比较
# 2.对数组中的元素两两比较，每两个数中，大的都放在奇数位小的放在偶数位，这样需要N/2+N次比较
#   这种算法不一定要改变原数组，遍历的时候得到两位中的大的和小的，把小的和min，大的和max比较即可
# 3.分治算法，也需要3N/2次比较


########################################################################
##                  编程之美2.11 寻找最近的点对                         ##
########################################################################
# 典型的分治算法的题目
# 如果事数组，可以用桶排序，只要O(N)时间（放入桶中－N，扫瞄一遍桶－N）


########################################################################
##                  编程之美2.12 快速寻找满足条件的两个数                 ##
########################################################################
# 找出一个数组中的两个数字a,b，使得其和为c
# 先排序的两个算法：注意这里只是找一个解，如果要找出所有解，可以用算法2或者算法3变化一下
# 算法1

def findSumC(list,c):
    list=sorted(list)
    sumab=0
    for i in range(len(list)-1):
        a,b=list[i],list[i+1]
        sumab=a+b
        if sumab==c:
            return a,b
        elif sumab>c:
            break

# 算法2 首尾变化，这里已经改成了找所有解
def findSumC2(list,c):
    list=sorted(list)
    a=0
    b=len(list)-1
    resut=[]
    while a<b:
        sumab=list[a]+list[b]
        if sumab==c:
            resut.append((list[a],list[b]))
            a+=1
        elif sumab<c:
            a+=1
        else:
            b-=1


    return resut


# 算法3 使用哈希表
def findSumC3(list,c):
    adict={}
    result=[]
    for item in list:
        adict[item]=1
    # print(adict)
    for item in list:
        #?
        if c-item<item:
            break
        if c-item in adict:
            result.append((item,c-item))
    return result

def test2_12():
    print(findSumC(list(range(100)),25))
    print(findSumC2(list(range(100)),25))
    print(findSumC3(list(range(100)),25))


########################################################################
##                  编程之美2.13 求字数组的最大乘积                    ##
########################################################################
# N维数组,找一个字数组N-1维,使得数组乘积最大，只能用乘法
# 算法一，从低到高，排除那个i，计算剩下的乘积

def findMaxN_1(list):
    result=0
    for i in range(len(list)):
        temp=reduce(lambda x,y:x*y,list[:i]+list[i+1:])
        if temp>result:
            result=temp

    return result

# 算法2 计算整个乘积P，P=0;>0;<0三种情况
def findMaxN_2(list):
    temp=reduce(lambda x,y:x*y,list)
    if temp==0:
        i=list.index(0)
        temp=reduce(lambda x,y:x*y,list[:i]+list[i+1:])
        if temp<0:
            temp=0
    elif temp>0:
        i=list.index(min([item for item in list if item>0]))
        temp=reduce(lambda x,y:x*y,list[:i]+list[i+1:])
    else:
        i=i=list.index(max([item for item in list if item<0]))
        temp=reduce(lambda x,y:x*y,list[:i]+list[i+1:])

    return  temp

def test2_13():
    print(findMaxN_1([12,3,2,4,345,32,12]))
    print(findMaxN_2([12,-3,0,4,345,32,12]))


########################################################################
##                  编程之美2.14 求子数组之和的最大值                    ##
########################################################################
# 这个题都烂了，不写了，不会的面壁


########################################################################
##                  编程之美2.15 求子数组之和的最大值(二维)                ##
########################################################################
# 思路是存储部分和,把解转化为部分和（根据右上角的位置，算其和整个图的左下角组成的图形面积）的函数


########################################################################
##                  编程之美2.16 数组中的最长递增子序列                  ##
########################################################################
'待补＋逆序数'











########################################################################
##                      编程之美2.17 数组循环移位                       ##
########################################################################
# [a,b,c,d,e]=>[e,a,b,c,d]
# [abcd1234]算法的核心是:交换abcd,1234的位置，如何交换呢，可以用三次逆序实现:
#  1.abcd 逆 [dcba1234]
#  2.1234 逆 [dcba4321]
#  3.整个  逆 [1234abcd]  完成


#注意这个是演示算法，实际reverse可以只用一个变量\
def leftMoveN(alist,N):
    N=N%len(alist)
    alist[:N]=list(reversed(alist[:N]))
    alist[N:]=list(reversed(alist[N:]))
    # print(alist)
    return list(reversed(alist))

def test2_17():
    print(leftMoveN([12,3,2,4,345,32,12],1))

########################################################################
##                      编程之美2.18 数组分割                           ##
########################################################################
#2n个元素的数组，找到两个子数组，n维使得其和尽量相等
#如果数组的总和是sum,那么找到一个最接近sum/2即可，不妨设<=sum/2
#使用动态规划的思想，若F[i][j][k]表示从i个元素中取j个使得其尽量接近k，那么
# F[i][j][k]=max(F[i-1][j][k],F[i-1][j-1][k-A[j]]+A[j])
#                 取了第i个元素，没取第i个元素

'这道题是背包问题，待补充背包问题的算法介绍'
def findTwoN(list,n):
    sumList=sum(list)
    print(sumList)
    F=[[[0]*(sumList//2+1)]*(n+1)]*(2*n+1)
    Path=F.copy()
    # print(F)
    nLimit=n
    for i in range(1,2*n+1):
        nLimit==min(i,n)
        for j in range(1,nLimit+1):
            for k in range(1,sumList//2+1):
                # print(i,j,k)
                F[i][j][k]=F[i-1][j][k]
                if(k>=list[i-1] and F[i][j][k]<F[i-1][j-1][k-list[i-1]]+list[i-1]):
                    F[i][j][k]=F[i-1][j-1][k-list[i-1]]+list[i-1]
                    Path[i][j][k]=1

    return F[2*n][n][sumList//2]


#可以F[i]始终与F[i-1]有关，可降维
def findTwoN2(list,n):
    sumList=sum(list)
    print(sumList)
    F=[[0]*(sumList//2+1)]*(n+1)
    # print(F)
    nLimit=n
    for i in range(1,2*n+1):
        nLimit==min(i,n)
        for j in range(1,nLimit+1):
            for k in range(1,sumList//2+1):
                # print(i,j,k)

                if(k>=list[i-1] and F[j][k]<F[j-1][k-list[i-1]]+list[i-1]):
                    F[j][k]=F[j-1][k-list[i-1]]+list[i-1]


    return F[n][sumList//2]

def test2_18():
    print(findTwoN([12,3,2,4,34,32,12,5],4))
    print(findTwoN2([12,3,2,4,34,32,12,5],4))

########################################################################
##                      编程之美3.1 字符串移位的包含问题                  ##
########################################################################
# 字符串'ABCD'循环移动之后包含'DAB'
# 此题的核心是'ABCD'=>'ABCDABCD'其中的3字符字串就是可以得到的所有3字符字串

#类似题目，移动字符串ABCD12向右移动两位,12ABCD,但是最多使用两个变量空间
# 一个做法同上拼接后切割,但是这样需要多余的空间,不符合要求，这种做法实际就是字符串复制
# 算法1:  算法 2.17 用三次旋转实现，线性时间，但是只使用一个旋转用的变量

#算法2:双指针移动法：对于一个字符串或者数组123456789,要向左移动m位,那么可以用两个指针
# p1=0;p2=p1+m;p1,p2一边向前移动一边交换p1,p2，对于末尾的递归实现上述步骤可以实现移动
# 如1234，m=2,=>3214=>3412 完成。12345,m=2 32145=》34125=》34521=》34512

#stl里的rotate算法，用到了gcd的原理
def leftRotate(astr,n,m,head,tail):

    #n 待处理部分的字符串长度，m：待处理部分的旋转长度
    #head：待处理部分的头指针，tail：待处理部分的尾指针

    # 返回条件
    if head == tail or m <= 0:
        return astr
    p1=head
    p2=head+m

    #1、左旋：对于字符串abc def ghi gk，
    #将abc右移到def ghi gk后面，此时n = 11，m = 3，m’ = n % m = 2;
    #abc def ghi gk -> def ghi abc gk

    k = (n - m) - n % m   #p1，p2移动距离，向右移六步

        #---------------------
        #解释下上面的k = (n - m) - n % m的由来：
        #以p2为移动的参照系：
        #n-m 是开始时p2到末尾的长度，n%m是尾巴长度
        #(n-m)-n%m就是p2移动的距离
        #比如 abc def efg hi
        #开始时p2->d,那么n-m 为def efg hi的长度8，
        #n%m 为尾巴hi的长度2，
        #因为我知道abc要移动到hi的前面，所以移动长度是
        #(n-m)-n%m = 8-2 = 6。
        #*/
    i=0
    while i<k:
        astr[p1],astr[p2]=astr[p2],astr[p1]
        i+=1
        p1+=1
        p2+=1
        # print (i,p1,p2)
    print (astr,n-k,n,m,p1,p2,head,tail)
    return rightRotate(astr, n - k, n % m, p1, tail)  #结束左旋，下面，进入右旋

def rightRotate(astr,n,m,head,tail):
    if head == tail or m <= 0:
        return astr

    #2、右旋：问题变成gk左移到abc前面，此时n = m’ + m = 5，m = 2，m’ = n % m 1;
    #abc gk -> a gk bc

    p1 = tail
    p2 = tail - m

    #p1，p2移动距离，向左移俩步
    k = (n - m) - n % m;
    i=0
    while i<k:
        astr[p1],astr[p2]=astr[p2],astr[p1]
        i+=1
        p1-=1
        p2-=1
    print (astr,n-k,n,m,p1,p2,head,tail)
    return leftRotate(astr, n - k, n % m, head, p1)#再次进入上面的左旋部分，
    #3、左旋：问题变成a右移到gk后面，此时n = m’ + m = 3，m = 1，m’ = n % m = 0;
    #a gk bc-> gk a bc。 由于此刻，n % m = 0，满足结束条件，返回结果。

'''
   1、对于正整数m、n互为质数的情况，通过以下过程得到序列的满足上面的要求：
 for i = 0: n-1
      k = i * m % n;
 end

    举个例子来说明一下，例如对于m=3,n=4的情况，
        1、我们得到的序列：即通过上述式子求出来的k序列，是0, 3, 2, 1。
        2、然后，你只要只需按这个顺序赋值一遍就达到左旋3的目的了：
    ch[0]->temp, ch[3]->ch[0], ch[2]->ch[3], ch[1]->ch[2], temp->ch[1]; （*）

    ok，这是不是就是按上面（*）式子的顺序所依次赋值的序列阿?哈哈，很巧妙吧。当然，以上只是特例，作为一个循环链，相当于rotate算法的一次内循环。

2、对于正整数m、n不是互为质数的情况（因为不可能所有的m，n都是互质整数对），那么我们把它分成一个个互不影响的循环链，
所有序号为 (j + i * m) % n（j为0到gcd(n, m)-1之间的某一整数，i = 0:n-1）会构成一个循环链，一共有gcd(n, m)个循环链，对每个循环链分别进行一次内循环就行了。

    综合上述两种情况，可简单编写代码如下：

//④ 所有序号为 (j+i *m) % n (j 表示每个循环链起始位置，i 为计数变量，m表示左旋转位数，n表示字符串长度)，
//会构成一个循环链（共有gcd(n,m)个，gcd为n、m的最大公约数），

//每个循环链上的元素只要移动一个位置即可，最后整个过程总共交换了n次
//（每一次循环链，是交换n/gcd(n,m)次，共有gcd(n,m)个循环链，所以，总共交换n次）。

void rotate(string &str, int m)
{
    int lenOfStr = str.length();
    int numOfGroup = gcd(lenOfStr, m);
    int elemInSub = lenOfStr / numOfGroup;

    for(int j = 0; j < numOfGroup; j++)
        //对应上面的文字描述，外循环次数j为循环链的个数，即gcd(n, m)个循环链
    {
        char tmp = str[j];

        for (int i = 0; i < elemInSub - 1; i++)
            //内循环次数i为，每个循环链上的元素个数，n/gcd(m,n)次
            str[(j + i * m) % lenOfStr] = str[(j + (i + 1) * m) % lenOfStr];
        str[(j + i * m) % lenOfStr] = tmp;
    }
}
'''


## 根据上面的描述，写出算法3
def moveGcd(astr,m):
    lenS=len(astr)
    numOfGroup=gcd(lenS,m)
    elemInSub=lenS//numOfGroup

    for j in range(numOfGroup):

        #对应上面的文字描述，外循环次数j为循环链的个数，即gcd(n, m)个循环链
        temp=''
        for  i in range(elemInSub - 1):
            #内循环次数i为，每个循环链上的元素个数，n/gcd(m,n)次
            astr[(j + i * m) % lenS] = astr[(j + (i + 1) * m) % lenS]
        astr[(j + i * m) % lenS] = temp

    return  astr


def test3_1():
    astr='helloworld'
    print (leftRotate(list(astr),10,3,0,9))
    print (moveGcd(list(astr),3))



########################################################################
##                      编程之美3.2 电话号码对应英语单词                 ##
########################################################################


########################################################################
##                      编程之美3.3 计算字符串的相似度                   ##
########################################################################
# 编辑距离的问题a,b的距离＝min(F(a[1:],b[:],F(a[:],b[1:],F(a[1:],b[1:])+1

class Memoize:
    def __init__(self, f):
        self.f = f
        self.memo = {}
    def __call__(self, *args):
        if not args in self.memo:
            self.memo[args] = self.f(*args)
        return self.memo[args]


def findMinDistance(a,b,aBegin,aEnd,bBegin,bEnd):
    if aBegin>aEnd:
        if bBegin>bEnd:
            return 0
        else:
            return bEnd-bBegin+1
    if bBegin>bEnd:
        if aBegin>aEnd:
            return 0
        else:
            return aEnd-aBegin+1
    if(a[bBegin]==b[bBegin]):
        return findMinDistance(a,b,aBegin+1,aEnd,bBegin+1,bEnd)
    else:
        t1=findMinDistance(a,b,aBegin+1,aEnd,bBegin+2,bEnd)
        t2=findMinDistance(a,b,aBegin+2,aEnd,bBegin+1,bEnd)
        t3=findMinDistance(a,b,aBegin+2,aEnd,bBegin+2,bEnd)
        return min(t1,t2,t3)+1

def test3_3():
    f=Memoize(findMinDistance)
    print(f('hello','world',0,4,0,4))


########################################################################
##                      编程之美3.4 无头单链表中删除节点                  ##
########################################################################
# 很巧妙的方法A->B->C->D
# 要删除B直接删除不行，因为A->这个链会被切断，那么要做的就是既能保留这个链，又能把B给
# 删除了，做法是先把C和B的数据互换，然后删除C，接上next链,B->next=C->next即可




########################################################################
##                      编程之美3.5 最短摘要的生成                      ##
########################################################################
# 即找最短包含子列表
# 使用双指针法，首尾指针移动

def isAllExisted(sourceList,targetlist,pBegin,pEnd):
        ret=True
        for item in targetlist:
            ret=ret and sourceList[pBegin:pEnd].count(item)!=0
        return ret

def findMinLengthSub(sourceList,targetlist):
    pBegin = 0                     	# 初始指针
    pEnd = 0                       	# 结束指针
    nTargetLen = 99999                  	# 目标数组的长度为N
    nAbstractBegin = 0          	# 目标摘要的起始地址
    nAbstractEnd = 0          	# 目标摘要的结束地址

    while True:

    # 假设包含所有的关键词，并且后面的指针没有越界，往后移动指针
        while pEnd <len(sourceList) and not isAllExisted(sourceList,targetlist,pBegin,pEnd):
            pEnd+=1

     # 假设找到一段包含所有关键词信息的字符串
        while isAllExisted(sourceList,targetlist,pBegin,pEnd):
            if pEnd-pBegin < nTargetLen:
                nTargetLen = pEnd-pBegin
                nAbstractBegin = pBegin
                nAbstractEnd = pEnd-1
            pBegin+=1

        if pEnd >= len(sourceList):
            break
    return nTargetLen,nAbstractBegin,nAbstractEnd

def test3_5():
    f=Memoize(findMinDistance)
    print(findMinLengthSub(["ab","ef","cd","gh","ij","k","c","ef","t","ij","yz"],['ef','ij']))


########################################################################
##                   编程之美3.7 判断两个链表是否相交                     ##
########################################################################
# 方法较多 见http://blog.163.com/song_0803/blog/static/4609759720120910373784/
# 1.用hash表 2.第一条链遍历的时候标记每一个节点，第二条中有标记过的就相交（实质同1）
# 3.把其中一条首尾相连，那么另一条有环则相交  4.看两条链最后一个节点是否相同

# 求出这个交点呢？上面的方法1,2还可以使用但是需要另外的空间
#另一种方法 5.相遍历一遍两条链发现长度为a,b a>b，那么第二次遍历的
#             时候第一条先走a-b步，然后同时走，一边比较每一个节点



########################################################################
##                   编程之美3.8 队列中取最大值问题                      ##
########################################################################
# O(1)内完成，enqueue,dequeue,findmax操作，做法是使用双数组，同步更新



########################################################################
##                  编程之美3.9 求二叉树中节点的最大距离                ##
########################################################################
#简单的递归，最大距离是一个节点左右深度最大深度子树之和+1
#同时返回深度和最大距离
def findMaxDistance(root):
    if root==None:
        return 0,0
    distanceL,heightL=findMaxDistance(root.left)
    distanceR,heightR=findMaxDistance(root.right)
    return heightL+heightR+1,max(heightL,heightR)+1


#            10
#         /      \
#       5        12
#       /\
#      4  7
def Test3_9():
    pNode10 = BSTreeNode(10);
    pNode5 = BSTreeNode(5)
    pNode12 = BSTreeNode(12)
    pNode4 = BSTreeNode(4)
    pNode7 = BSTreeNode(7)
    ConnectTreeNodes(pNode10, pNode5, pNode12)
    ConnectTreeNodes(pNode5, pNode4, pNode7)

    print (findMaxDistance( pNode10))



if __name__=='__main__':
    Test3_9()