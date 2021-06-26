##本部分来自july的微软面试的100题

########################################################################
##                    题1.二元查找树转化为双向链表                    ##
########################################################################
## 递归遍历左右子树，树的head就是
class BSTreeNode:
    def __init__(self,value=None,left=None,right=None):
        self.value=value
        self.left=left
        self.right=right

def ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3):
    pNodeA1.left=pNodeA2
    pNodeA1.right=pNodeA3
#
# @param root The root node of the tree
# @return The head node of the converted list.
#
def treeToLinkedList(root):
    def helper(root):
        lt,rh=BSTreeNode(),BSTreeNode()#lt是节点左子树的tail，rh是右子树的head
        #基准情况
        if root is None:
            return (None,None)
        # print (root.left.value,root.right.value)
        (head,lt)=helper(root.left)#节点的head就是左子树的head
        (rh,tail)=helper(root.right)#节点的tail就是右子树的tail
        if lt is not  None:
            lt.right=root
            root.left=lt
        else:
            head=root
        if rh is not None:
            root.right=rh
            rh.left=root
        else:
            tail=root

        return head,tail

    return helper( root);

#另一种写法，更简单
def treeToLinkedList2(root):
    #这一步是因为convertNode返回的是尾部节点
    pTailList=None
    pTailList=convertNode(root,pTailList)
    # print (pTailList.value)
    while pTailList and pTailList.left:
        # print (pTailList.value)
        pTailList=pTailList.left
    return pTailList

def convertNode(root,pTailList):
    #有点像中序遍历
    #对于左子树，lastnode就是左子树的lastnode
    #对于右子树，lastnode上就是根
    #循环不变式：转换到节点P的时候，其左边已经转换成了有序的列表，而且其最后面一个是最大的以后
    #            然后转换右边的节点
    if not root:
        return
    pCurrent=root
    if pCurrent.left:
        pTailList=convertNode(pCurrent.left,pTailList)
    pCurrent.left=pTailList
    if pTailList:
        pTailList.right=pCurrent
    pTailList=pCurrent

    if pCurrent.right:
        pTailList=convertNode(pCurrent.right,pTailList)
    return pTailList

def test1():
    node1=BSTreeNode(4)
    node2=BSTreeNode(8)
    node3=BSTreeNode(12)
    node4=BSTreeNode(16)
    node5=BSTreeNode(6,node1,node2)
    node6=BSTreeNode(14,node3,node4)
    node7=BSTreeNode(10,node5,node6)

    # head=treeToLinkedList(node7)[0]
    # while head.right:
    #     print (head.value,end=' ')
    #     head=head.right

    head1=treeToLinkedList2(node7)
    while head1.right:
        print (head1.value,end=' ')
        head1=head1.right

########################################################################
##           9.腾讯面试题：
#给你10分钟时间，根据上排给出十个数，在其下排填出对应的十个数
#要求下排每个数都是先前上排那十个数在下排出现的次数。
#上排的十个数如下：
#【0，1，2，3，4，5，6，7，8，9】
#举一个例子，
#数值: 0,1,2,3,4,5,6,7,8,9
#分配: 6,2,1,0,0,0,1,0,0,0
#0在下排出现了6次，1在下排出现了2次，
#2在下排出现了1次，3在下排出现了0次...                ##
########################################################################
# 这种思路是一种暴力方法，对第一位设置一个数，然后依次设置并且更新
# 如果发现后面的数字遍历所有可能结果都找不到合适的，那么就要更新前面的数字
# 为了减少遍历次数，稍加分析，maxCount
def findCountList(aList):
    maxCount=[9,2,2,2,2,2,2,0,0,0]#maxCount还可以再优化，不过已经算得很快了
    # maxCount=[9,9,9,9,9,1,1,0,0,0]#如果这个maxcout 没那么好，计算时间就会增加很多
    countList=[0]*len(aList)
    def checkResultIsOk(aList,countList):
        for i in range(len(countList)):
            if countList.count(aList[i])!=countList[i]:
                return False
        # print (i,countList.count(aList[i]),countList[i])
        return True

    def findCountListOfIndex(aList,index,countList):
        if checkResultIsOk(aList,countList):
            return True
        if index>=len(aList):
            return
        for i in range(maxCount[index]+1):
            # print (maxCount[index]+1)
            countList[index]=i
            # print (countList)
            if(findCountListOfIndex(aList,index+1,countList)):
                return True
        return False

    findCountListOfIndex(aList,0,countList)
    return countList


def test9():
    print (findCountList(list(range(10))))




########################################################################
#16.题目：输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
#例如输入
#      8
#   /  /
# 6    10
#  //     //
#5  7   9  11
#输出8   6   10   5   7   9   11。
########################################################################
#广度优先算法的二叉树实现，没什么说的，基础中的基础
def BFS(root):
    queue=[root]
    while queue:
        node=queue.pop(0)
        print (node.value,end=' ')
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)

def DFS(root):
    pass
#就是前序，中序，后序遍历
#二叉树的前序，中序，后序遍历都是深度优先遍历的一种

#            10
#         /      \
#       5        12
#       /\
#      4  7
def Test16():
    pNode10 = BSTreeNode(10);
    pNode5 = BSTreeNode(5)
    pNode12 = BSTreeNode(12)
    pNode4 = BSTreeNode(4)
    pNode7 = BSTreeNode(7)
    ConnectTreeNodes(pNode10, pNode5, pNode12)
    ConnectTreeNodes(pNode5, pNode4, pNode7)

    BFS( pNode10)

########################################################################
#第20 题：
#题目：输入一个表示整数的字符串，把该字符串转换成整数并输出。
#例如输入字符串"345"，则输出整数345。
########################################################################
# 不妨查看python的int函数
#int('-12')

########################################################################
#有4张红色的牌和4张蓝色的牌，主持人先拿任意两张，
#再分别在A、B、C三人额头上贴任意两张牌，
##看完后让他们猜自己额头上是什么颜色的牌，
#A说不知道，B说不知道，C说不知道，然后A说知道了。
#请教如何推理，A是怎么知道的。如果用程序，又怎么实现呢？
########################################################################
#A,说自己不知道，那么B,C可能为[(rr,bb),(bb,rr),(rr,rb),(rb,rb),(rb,rr),(rb,bb),(bb,rb)]
#同理B说不知道说明上面的对应关系不能确定B则B=[(rr),(rb),(bb)](所有可能的，没有改进),
# AC=[(rr,bb),(bb,rr),(rr,rb),(rb,rb),(rb,rr),(rb,bb),(bb,rb)]
# AB=[(rr,bb),(bb,rr),(rr,rb),(rb,rb),(rb,rr),(rb,bb),(bb,rb)]
# 这样就得到了所有的AC,AB,对应关系，那么从BC中根据BC的值取出A有且仅有一个值的就是解

import collections
import itertools
def findA():
    possibilities=set(itertools.permutations(['rr','rr','rb','rb','bb','bb'],2))-{('rr','rr'),('bb','bb')}
    #转换成字典更方便
    dictBA=dictCA=collections.defaultdict(set)
    for item in possibilities:
        dictCA[item[1]].add(item[0])
    A=None
    for C in {'rr','bb','rb'}:
        for B in {'rr','bb','rb'}:
            A=dictCA[C]&dictBA[B]
            if len(A)==1:
                print (A,B,C)



if __name__=='__main__':
    findA()