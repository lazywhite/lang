##本部分来自剑指offer

########################################################################
##              第一章 例题 寻找单向链表的倒数第k个节点               ##
########################################################################
## 使用双指针法，一个指针先移动k步，然后两个指针一起移动，先移动的到链表尾部的时候，后移动指向倒数第k个
# 双指针法在寻找次序等方面是很有用的方法见编程之美3.5
## 生成最短摘要，（最小子列表）

class OneWayListNode:
    def __init__(self,value=None,next=None):
        self.value=value
        self.next=next

def lastKNode(head,k):
    k1=head
    k2=head
    i=0
    while i<k:
        k1=k1.next
        if not k1:
            break
        i+=1
    else:
        while k1.next:
            k1=k1.next
            k2=k2.next
        return k2
    print('k out of range')

def test1():
    head=OneWayListNode(0)
    parentNode=head
    for i in range(1,100):
        node=OneWayListNode(i)
        parentNode.next=node
        parentNode=node

    print(lastKNode(head,50).value)
    print(lastKNode(head,101))




########################################################################
##            第二章  例题2  sizeof的问题                            ##
########################################################################
# 求下面sizeof(p)的大小 32位
#1.int p[]={1,2,3,4,5}   #20
#2.int p2=p              #4
#3.char *p="hello"      ;#4
#4.char p2[]="hello";#6但是strlen(p)为5-有效长度 #等价于char p2[]={'h','e','l','l','o','w','o','r','l','d','\0'}
#5.char p3[]={'h','e','l','l','o','w','o','r','l','d'};//12

# getSize(int data[])
# {
#     return sizeof(data)
# }
#6.getSize(p)  #4 数组作为函数的参数传递时会退化为同类型指针




########################################################################
##                 第二章  例题3  二维有序数组中查找                  ##
########################################################################
# 已知一个二维数组，横向纵向都是递增的，例如：
#1 2 3 4
#2 3 4 5
#3 4 5 6
#5 6 7 8
#查找其中的一个数，有则返回，无则返回None

# 算法1，为简单起见，只要求返回一个满足要求的元素
# 可以观察到，每次选取右上角的元素a是个很好的二分的方法，如果target<a，那么a
# 所在的列可以不用搜索了，如果target>a,那么a所在的行不用搜索了
# 可以分析 算法复杂度为O(2n)

#m,n为行列数
def findKOfMatrix(matrix,k,m,n):
    while True:
        if matrix[m][n]>k:
            n-=1
        elif matrix[m][n]<k:
            m+=1
        else:
            return m,n
        if m==0 and n==0:
            return None


# 算法2 使用递归，拆分成几个小的格子
# todo

def test3():
    matrix=[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
    print(findKOfMatrix(matrix,7,0,3))



########################################################################
##                 第二章  例题5  从尾到头打印链表                    ##
########################################################################
# 思路是用栈或者递归，实际一样 递归就是栈
def printListReverse(head):
    if head.next:
        printListReverse(head.next)
    print(head.value)


def test2_5():
    head=OneWayListNode(0)
    parentNode=head
    for i in range(1,100):
        node=OneWayListNode(i)
        parentNode.next=node
        parentNode=node

    printListReverse(head)


########################################################################
##                  第二章  例题6  重建二叉树                         ##
########################################################################
# 已知前序，或中序，后序遍历（2个）的结果，重建二叉树
# 前序，中序，后序，都是对根节点访问的相对次序而言的
# 已知一个二叉树前序，中序遍历的结果分别是1,2,4,7,3,5,6,8   ;   4,7,2,1,5,3,8,6


class BSTreeNode:
    def __init__(self,value=None,left=None,right=None):
        self.value=value
        self.left=left
        self.right=right

def ReBuildTreeWithFandM(Flist,Mlist):
    def findRoot(Flist,Mlist):
        if len(Mlist)>0:
            return Flist.pop(0)
        else:
            return None

    root=BSTreeNode(findRoot(Flist,Mlist))
    if root.value:
        print(root.value,end='')
        rootIndex=Mlist.index(root.value)
        root.left=ReBuildTreeWithFandM(Flist,Mlist[:rootIndex])
        root.right=ReBuildTreeWithFandM(Flist,Mlist[rootIndex+1:])
        return root
    else:
        return None



def test2_6():
    root=ReBuildTreeWithFandM([1,2,4,7,3,5,6,8],[4,7,2,1,5,3,8,6])

    print()

    def printTree(root):
        if root==None:
            return

        printTree(root.left)
        print(root.value,end='')
        printTree(root.right)


    printTree(root)

########################################################################
##               第二章  例题7  用两个栈实现一个队列                  ##
########################################################################
# 思路是一个栈stack1中放逆序的（先进先出），当需要删除的时候从stack2（正序）中
# 删除，当stack2是空的时候，把stack1中的元素依次pop到stack2中来，插入时插入到stack1
# 也即进：stack1，出：stack2
class queueWithTwoStack:
    def __init__(self):
        self.stack1=[]
        self.stack2=[]

    def push(self,item):
        self.stack1.append(item)

    def pop(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

# 同理可以用两个queue实现一个stack
# 每次pop的时候，把有元素的那个queue 除了最后一个都pop到另一个queue
class stackWithTwoQueue:
    def __init__(self):
        self.queue1=[]
        self.queue2=[]

    def push(self,item):
        if self.queue1:
            self.queue1.append(item)
        else:
            self.queue2.append(item)

    def pop(self):
        if self.queue1:
            tempqueue1=self.queue1
            tempqueue2=self.queue2
        else:
            tempqueue2=self.queue1
            tempqueue1=self.queue2

        while len(tempqueue1)>1:
            tempqueue2.append(tempqueue1.pop(0))
        return tempqueue1.pop(0)


def test2_7():
    queue=queueWithTwoStack()
    for i in range(10):
        queue.push(i**2)

    for i in range(10):
        print(queue.pop(),end=' ')

    print()

    stack=stackWithTwoQueue()
    for i in range(10):
        stack.push(i**2)
    for i in range(10):
        print(stack.pop(),end=' ')



########################################################################
##                      第二章  例题8_1  快速排序                       ##
########################################################################
# 基础，主要是partition算法要记住，原地的高效partition是快速排序的关键
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

def quickSort(alist,start,end):
    if start==end:
        return
    index=Partition(alist,start,end)
    if index>start:
        quickSort(alist,start,index-1)
    if index<end:
        quickSort(alist,index+1,end)
    return alist


def test2_8_1():
    print(quickSort([2,9,3,6,4,5],0,5))

########################################################################
##               第二章  例题8  寻找旋转数组中的最小元素             ##
########################################################################
# 旋转数组1,2,3,4,5->3,4,5,1,2
# 可以看出数组实际上分成了两段有序的子数组，所以可以用双指针法结合二分搜索
# 注意下面的算法没有考虑数组元素相同时候的特殊情况
def findMinOfRotateList(alist,begin,end):
    if end-begin==1:
        return begin,end
    Mid=(begin+end)//2
    if alist[Mid]>alist[begin]:
        return findMinOfRotateList(alist,Mid,end)
    elif alist[Mid]<alist[end]:
        return findMinOfRotateList(alist,begin,Mid)


def test2_8():
    alist=list(range(10))
    alist=alist[5:]+alist[:5]
    print (alist)
    print (findMinOfRotateList(alist,0,9))

########################################################################
##                  第二章  例题9  斐波那契数列的变种                ##
########################################################################
# 如之前看到的石子游戏问题，青蛙跳台阶问题:青蛙可以一次跳1级，或者一次跳
# 2级，那么n级台阶的跳法可以有f(n)种：第一次跳有两种选择，1,2那么
# f(n)=f(n-1)+f(n-2) 这个思考的方法有点像动态规划，但是它是从第一步开始考虑
# 而不是考虑与上一步的关系



########################################################################
##                  第二章  例题10  二进制中1的个数                   ##
########################################################################
#见编程之美中的四种算法
#1.求余数 2.移位 3.最低1置0法 4.查表法



########################################################################
##         第二章  例题14  把数组中的奇数都放在前面偶数放在后面       ##
########################################################################
# 又是简单的双指针法，不写了



########################################################################
##                       第二章  例题16  反转链表                    ##
########################################################################
# 要用三个指针
#class OneWayListNode:
def reverseNodeList(aListHead):
    if not aListHead.next:
        return aListHead

    head=aListHead.next
    pre=aListHead
    pre.next=None

    while head.next:
        next=head.next
        head.next=pre
        pre=head
        head=next
    head.next=pre
    return head

def test2_16():
    head=OneWayListNode(0)
    parentNode=head
    for i in range(1,10):
        node=OneWayListNode(i)
        parentNode.next=node
        parentNode=node

    newHead=reverseNodeList(head)
    while newHead.next:
        print (newHead.value,end='')
        newHead=newHead.next
    print (newHead.value,end='')



########################################################################
##           第二章  例题18  判断一棵树是否是另一棵树的子树            ##
########################################################################
# 两步递归，首先递归找到如targetRoot value相同的节点，然后递归判断其左右子树是否都一样

#BSTreeNode
def hasSubtree(originTree,targetTree):
    result=False
    if originTree and targetTree:
        if originTree.value==targetTree.value:
            result=tree1IsEqualToTree2(originTree,targetTree)
        if not result:
            result=hasSubtree(originTree.left,targetTree) or hasSubtree(originTree.left,targetTree)
    return result


def tree1IsEqualToTree2(tree1,tree2):
    if not tree2:
        return True
    if not tree1:
        return False
    if tree1.value!=tree2.value:
        return False
    else:
        return tree1IsEqualToTree2(tree1.left,tree2.left) and tree1IsEqualToTree2(tree1.right,tree2.right)




# 树中结点含有分叉，树B是树A的子结构
#                  8                8
#              /       \           / \
#             8         7         9   2
#           /   \
#          9     2
#               / \
#              4   7

def ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3):
    pNodeA1.left=pNodeA2
    pNodeA1.right=pNodeA3

def Test2_18():

    pNodeA1 = BSTreeNode(8)
    pNodeA2 = BSTreeNode(8)
    pNodeA3 = BSTreeNode(7)
    pNodeA4 = BSTreeNode(9)
    pNodeA5 = BSTreeNode(2)
    pNodeA6 = BSTreeNode(4)
    pNodeA7 = BSTreeNode(7)

    ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3)
    ConnectTreeNodes(pNodeA2, pNodeA4, pNodeA5)
    ConnectTreeNodes(pNodeA5, pNodeA6, pNodeA7)

    pNodeB1 = BSTreeNode(8)
    pNodeB2 = BSTreeNode(9)
    pNodeB3 = BSTreeNode(2)

    ConnectTreeNodes(pNodeB1, pNodeB2, pNodeB3)

    print (hasSubtree(pNodeA1, pNodeB1))


########################################################################
##                    第二章  例题20  顺时针打印矩阵                ##
########################################################################
#1    2    3    4
#5    6    7    8
#9    10   11   12
#13   14   15   16
#1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10

#首先找出子问题
#这里发现，把打印一圈看成一个子问题是很方便的，每一个子问题的起点，即左上
#角的坐标是有规律的
def PrintMatrixClockwisely(matrix):
    start=0
    rows=len(matrix)
    columns=len(matrix[0])
    while rows>2*start and  columns>2*start:
        printCircle(matrix,start)
        start+=1

def printCircle(matrix,start):
    rows=len(matrix)
    columns=len(matrix[0])
    endX=columns-start-1
    endY=rows-start-1

    # 从左到右打印一行
    for i in range(start,endX+1):
        print (matrix[start][i],end=' ')

    # 从上到下打印一列
    for i in range(start+1,endY+1):
        print (matrix[i][endX],end=' ')

    # 从右到左打印一行
    for i in range(endX-1,start-1,-1):
        print (matrix[endY][i],end=' ')

    # 从下到上打印一行
    for i in range(endY-1,start,-1):
        print (matrix[i][start],end=' ')

def test2_20():
    matrix=[list(range(1,5)),list(range(5,9)),list(range(9,13)),list(range(13,17))]
    PrintMatrixClockwisely(matrix)

########################################################################
##                        转换密码  python 代码                     ##
########################################################################
def codeString(aString):
    i=len(aString)-1;
    while i>=0:
        aChar=aString[i]
        asciiCode=ord(aChar)*2+10
        if asciiCode>115:
            asciiCode=asciiCode//3
        i-=1
        print(chr(asciiCode),end='')

def testCodeString():
    codeString('1234567')


########################################################################
##            第二章  例题22  已知入栈顺序，求出栈序列的可能性         ##
########################################################################

#输入列表表示push的次序，从前往后
# 回溯法，重看此算法！
def printPushOrder(pushStack,popStack,printStack):
    # print(pushStack,popStack,printStack)
    if pushStack or popStack:
        if  popStack:
            # print (popStack)
            printStack.append(popStack.pop())
            printPushOrder(pushStack,popStack,printStack)
            popStack.append(printStack.pop())
        if pushStack:
            popStack.append(pushStack.pop(0))
            #print (popStack)
            printPushOrder (pushStack,popStack,printStack)
            pushStack.insert(0,popStack.pop())


    else:
        print (list(printStack))


def test2_22():
    pushStack=[1,2,3,4,5]
    printPushOrder(pushStack,[],[])


########################################################################
##     第二章  例题24  判断一个序列是不是二叉搜索树的后序遍历结果     ##
########################################################################
def verifySequenceOFBST(aList,begin,end):
    if end<=begin:
        return False
    #根
    root=aList[end]
    i=begin
    #寻找左子树
    while i<end:
        if aList[i]>root:
            break
        i+=1
    j=i
    #寻找右子树
    while j<end:
        if aList[j]<root:
            return False
        j+=1

    left=True
    if i>begin+1:
        left=verifySequenceOFBST(aList,begin,i-1)
    right=True
    if i<end-1:
        right=verifySequenceOFBST(aList,i,end-1)
    return left and right


def test2_24():
    alist=[5,7,6,9,11,10,8]
    print (verifySequenceOFBST(alist,0,len(alist)-1))


########################################################################
##                第二章  例题25  二叉树中和为某一值的路径            ##
########################################################################
# 递归加回溯，为什么要回溯？循环不变式要保证
# 把访问的结点入栈，访问左结点，不行出栈 访问右结点，不行 此节点出栈 回到父结点

def findPathWithSum(treeRoot,path,expectedSum,currentSum):
    currentSum+=treeRoot.value
    path.append(treeRoot.value)
    if expectedSum==currentSum:
        print (path)
    if treeRoot.left:
        findPathWithSum(treeRoot.left,path,expectedSum,currentSum)
    if treeRoot.right:
        findPathWithSum(treeRoot.right,path,expectedSum,currentSum)

    currentSum-=treeRoot.value
    path.pop()

#            10
#         /      \
#       5        12
#       /\
#      4  7
# 有两条路径上的结点和为22
def Test2_25():
    pNode10 = BSTreeNode(10);
    pNode5 = BSTreeNode(5)
    pNode12 = BSTreeNode(12)
    pNode4 = BSTreeNode(4)
    pNode7 = BSTreeNode(7)
    ConnectTreeNodes(pNode10, pNode5, pNode12)
    ConnectTreeNodes(pNode5, pNode4, pNode7)

    findPathWithSum( pNode10,[], 22,0);



########################################################################
##                      第二章  例题26  复杂链表的复制                ##
########################################################################
# 不仅有next 还有sibling指向链表中的任意一个节点
class ComplexListNode:
    def __init__(self,value=None,next=None,sibling=None):
        self.value=value
        self.next=next
        self.sibling=sibling

#算法一，分成三个步骤，1.复制链表结点，插在原始链表之间a->b->c=>a->a'->b->b'->c->c'
#2.复制所有的sibling指针  3.拆分成两个链表

def Clone(pHead):
    #1.
    CloneNodes(pHead)
    #2.
    ConnectSiblingNodes(pHead)
    #3.
    return ReconnectNodes(pHead)

#1.
def CloneNodes(pHead):
    pNode = pHead;
    while(pNode != None):
        pCloned =ComplexListNode(pNode.value,pNode.next)
        pNode.next = pCloned
        pNode = pCloned.next

#2.
def ConnectSiblingNodes(pHead):
    pNode = pHead
    while(pNode != None):
        pCloned = pNode.next
        if pNode.sibling:
            pCloned.sibling=pNode.sibling.next
        pNode = pCloned.next

#3.
def ReconnectNodes(pHead):
    pNode = pHead;
    pClonedHead = None
    pClonedNode = None

    if(pNode != None):
        pClonedHead = pClonedNode = pNode.next
        pNode.next = pClonedNode.next
        pNode = pNode.next

    while(pNode != None):
        pClonedNode.next =  pNode.next
        pClonedNode = pClonedNode.next
        pNode.next = pClonedNode.next
        pNode = pNode.next

    return pClonedHead


#算法二 另一种思路 复制的时候吧对应关系(a,a')保存到一个字典中，这样a->b 就对应于a'->b'
#算法三 类似于拓扑排序，复制的时候先复制那个sibling，如果有了就拿出来，没有就复制
#       这个算法不能用于有sibling指针有循环的情况
def clone2(pHead):
    cloneedNodes={}
    def cloneNode(node):
        if not node:
            return None
        if node in cloneedNodes:
            return cloneedNodes[node]
        else:
            clonedNode=ComplexListNode(node.value,None,cloneNode(node.sibling))
            cloneedNodes[node]=clonedNode
            return clonedNode

    pClonedHead =pClonedNode= cloneNode(pHead)
    while pHead:
        pClonedNode.next=cloneNode(pHead.next)
        pHead=pHead.next
        pClonedNode=pClonedNode.next
    return pClonedHead


#====================测试代码====================



#          -----------------
#         \|/              |
# 1-------2-------3-------4-------5
#  |       |      /|\             /|\
#  --------+--------               |
#          -------------------------


def BuildNodes(pNode1, pNode2, pNode3):
    pNode1.next=pNode2
    pNode1.sibling=pNode3

def test2_26():

    pNode1 = ComplexListNode(1)
    pNode2 = ComplexListNode(2)
    pNode3 = ComplexListNode(3)
    pNode4 = ComplexListNode(4)
    pNode5 = ComplexListNode(5)

    BuildNodes(pNode1, pNode2, pNode3)
    BuildNodes(pNode2, pNode3, pNode5)
    BuildNodes(pNode3, pNode4, None)
    BuildNodes(pNode4, pNode5, pNode2)

    node=clone2(pNode1)
    while node.next:
        print (node.value,end='')
        node=node.next
    print (node.value,end='')



########################################################################
##                第二章  例题27  二叉树搜索和双向链表                  ##
########################################################################
#见ms100 题1

########################################################################
##                   第二章  例题28 字符串排列                         ##
########################################################################
# 分成子问题
# a,b 对a位置来说有2种可能，把a和后面的元素交换b,a;,a,b; 对a,b,c来说重复上面的操作

def permutation(alist,start):
    if start==len(alist):
        print (alist,end=',')
    else:
        i=start
        while i<len(alist):
            alist[i],alist[start]=alist[start],alist[i]
            permutation(alist,start+1)
            alist[start],alist[i]=alist[i],alist[start]
            i+=1

def test2_28():
    import itertools
    print (len(list(itertools.permutations(['a','b','c','d'],4))),list(itertools.permutations(['a','b','c','d'],4)))
    print  (permutation(['a','b','c','d'],0))


########################################################################
##                第二章  例题33 把数组排成最小的数                   ##
########################################################################
# 对于一个输入数组如{3,32,321},最小的数是321323
# 此算法的核心是定义两个一个比较的算法a,b两个数拼成的数ab,ba如果ab>ba,那么
# a>:b(>:是新定义的符号),这样，根据这个算法可以对数组进行排序了，这样拼成的
# 数字最小（可以证明）
# 一个小技巧是，可以直接用拼接成的字符串进行比较





########################################################################
##                         第二章  例题34 丑数                        ##
########################################################################
# 把只包含因子2,3,5的数成为丑数：找到第1500个丑数
# 遍历判断是不是丑数的效率过低，考虑找到排序的丑数数组
# 丑数必然是2,3,5其中选1~n个数相乘而形成的的，而且如果现在又一个丑数数组n长了
# 那么下一个丑数一定是数组中的一个最小满足a*2>max,b*3>max,c*5>max的数a,b,c
# 形成的，而且nextMax=min(a*2,b*3,c*5)

def findKthUglyNumber(k):
    if k<=0:
        return 0
    uglyNumbers=[1]*(k+1)
    index_a=index_b=index_c=0
    for i in range(1,k+1):
        nextUgly=min(uglyNumbers[index_a]*2,uglyNumbers[index_b]*3,uglyNumbers[index_c]*5)
        uglyNumbers[i]=nextUgly
        while uglyNumbers[index_a]*2<=nextUgly:
            index_a+=1
        while uglyNumbers[index_b]*3<=nextUgly:
            index_b+=1
        while uglyNumbers[index_c]*5<=nextUgly:
            index_c+=1

    return uglyNumbers[k]

def test2_34():
    for i in range(10):
        print (findKthUglyNumber(i))
    print (findKthUglyNumber(15000))


########################################################################
##               第二章  例题39 判断一棵树是不是平衡二叉树             ##
########################################################################
#左右节点的深度<1;遍历的同时，计算深度
#同时返回是否平衡和深度
def isbalanced(treeRoot):
    if treeRoot==None:
        return True,0
    leftIsBalanced,leftDepth=isbalanced(treeRoot.left)
    rigthIsBalanced,rightDepth=isbalanced(treeRoot.right)
    if leftIsBalanced and rigthIsBalanced and abs(leftDepth-rightDepth)<=1:
        return True,max(leftDepth,rightDepth)+1
    else:
        return False,max(leftDepth,rightDepth)+1


#            10
#         /      \
#       5        12
#       /\
#      4  7
# 有两条路径上的结点和为22
def Test2_39():
    pNode10 = BSTreeNode(10);
    pNode5 = BSTreeNode(5)
    pNode12 = BSTreeNode(12)
    pNode4 = BSTreeNode(4)
    pNode7 = BSTreeNode(7)
    ConnectTreeNodes(pNode10, pNode5, pNode12)
    ConnectTreeNodes(pNode5, pNode4, pNode7)

    print (isbalanced( pNode10))



########################################################################
##             第二章  例题40 数组中只出现一次的两个数字             ##
########################################################################
# 其他数字都出现两次，求只出现一次的两个数字a,b
# 两次=》偶数=》异或！
# 异或结果就是a^b,但是这找不出a,b,最好能分成两组，两组分别有a,b,一个分组方法就是a^b的最低1位
# 注意异或的一些有用性质，异或0不变···
def findTwoOnceNumber(aList):
    DR=0
    for i in range(len(aList)):
        DR=DR^aList[i]
    indexOfOne=findnumber(DR)
    DR1=0
    DR2=0
    for i in range(len(aList)):
        if aList[i]>>indexOfOne&1:
            DR1=DR1^aList[i]
        else:
            DR2=DR2^aList[i]
    return DR1,DR2

def findnumber(i):
    k=0
    endNumer=i&1
    while endNumer!=1:
        k+=1
        endNumer=(i>>1&1)
    return 1<<k

def test2_40():
    print (findTwoOnceNumber([1,2,3,4,5,1,3,5]))



########################################################################
##                第二章  例题41  找到和为s的连续序列                  ##
########################################################################
# 先找到可能使用的数字数组，双指针法遍历

def findContinusSequence(numberSum):
    targetList=list(range(1,(numberSum+1)//2+1))
    start=0
    end=1
    tempSum=0
    while start<len(targetList) and end<len(targetList)+1:
        tempSum=sum(targetList[start:end+1])
        if tempSum<numberSum:
            end+=1
        elif tempSum>numberSum:
            start+=1
        else:
            print (targetList[start:end+1])
            if end-start==1:
                break
            end+=1
            start+=1

def test2_41():
    findContinusSequence(150000)


########################################################################
##                第二章  例题43  n个骰子的各种点数概率               ##
########################################################################
# 用动态规划的思路解决
#n为骰子数目，k为需要的点数
def Frequence(n):
    k=n*6
    tempResult=[[-1]*(k+1)]*(n+1)
    for i in range(1,7):
        tempResult[1][i]=1/6

    def helper(n,k):
        if tempResult[n][k]!=-1:
            return tempResult[n][k]
        if n>k or k>n*6:
            tempResult[n][k]=0
            return 0
        else:
            result=0
            for i in range(1,7):
                result+=helper(n-1,k-i)
            result/=6
            tempResult[n][k]=result
            return result

    for i in range(1,n+1):
        for j in range(6,k+1):
            helper(n,k)
    return tempResult

def test2_43():
    print (Frequence(6)[6][36])


########################################################################
##                   第二章  例题45  圆桌报数问题                     ##
########################################################################
# 算法1，效率不高
# 此算法错误-。-！待改
def popAnumber(aList,beginIndex):
    if len(aList)==0:
        return
    i=(beginIndex+8)%len(aList)
    aList.pop(i)
    print(aList)
    popAnumber(aList,i)


# 算法2，使用环形链表实现

# 算法3，最优！
# 方程f(n,m)表示n个连续数字每次删掉第m个剩下的那个，那么找到和f(n-1,m)的关系即可
# 1,2,3....n 第一个被删的为k=m%n,那么剩下的排列是k+1,k+2,....n,1,2,..k-1
# 把排列做变换，可以变成第一步一样的形式 f(n,m)=[f(n-1,m)+m]%n
#n=1,f(n,m)=0

def lastRemain(n,m):
    if n<1 or m<1:
        return -1
    last=0
    for i in range(2,n+1):
        last=(last+m)%n
    return last


def testpopAnumber():
    alist=list(range(1,40))
    popAnumber(alist,6)
    print (lastRemain(39,8))


########################################################################
##                      质因数分解 python 代码                        ##
########################################################################
def test():
    n = int(input('Enter a number:'))
    print (n,'=')
    while(n!=1):
        for i in range(2,n+1):
            if (n%i)==0:
                n//=i
                if(n == 1):
                    print ('%d'%(i),end='')
                else:
                    print ('%d *'%(i),end='')
                break





if __name__ == "__main__":
    testpopAnumber()
