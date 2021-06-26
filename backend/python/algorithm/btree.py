# -*- coding:utf-8 -*-
from __future__ import print_function
tree =  '''
        1
     /     \ 
    2       3
  /  \     /  \ 
 4    5   6    7
'''

print(tree)


class Node(object):
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


class Btree(object):
    def __init__(self, root=0):
        self.root = root

    def preorder(self, node):
        '''前序遍历'''
        if node: 
            print(node.data, end=',')
            self.preorder(node.left)
            self.preorder(node.right)

    def inorder(self, node):
        '''中序遍历'''
        if node: 
            self.inorder(node.left)
            print(node.data, end=',')
            self.inorder(node.right)
        
    def postorder(self, node):
        '''后序遍历'''
        if node: 
            self.postorder(node.left)
            self.postorder(node.right)
            print(node.data, end=',')


    def reverse(self, node):
        '''翻转二叉树'''
        if node:
            node.left, node.right = node.right, node.left
            self.reverse(node.left)
            self.reverse(node.right)

        
node7 =  Node(7)
node6 =  Node(6)
node5 =  Node(5)
node4 =  Node(4)
node2 =  Node(2, node4, node5)
node3 =  Node(3, node6, node7)
root = Node(1, node2, node3)

bt = Btree(root)


bt.preorder(bt.root)
print()
bt.inorder(bt.root)
print()
bt.postorder(bt.root)
print()

bt.reverse(bt.root)

bt.preorder(bt.root)


