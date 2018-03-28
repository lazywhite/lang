#include <stdio.h>

typedef struct Node{
    int value;
    struct Node* left;
    struct Node* right;
} Node;

void preOrder(Node* root){
    printf("%d ", root->value);
    if(root->left){
        preOrder(root->left);
    }
    if(root->right){
        preOrder(root->right);
    }
}
void inOrder(Node* root){
    if(root->left){
        inOrder(root->left);
    }
    printf("%d ", root->value);
    if(root->right){
        inOrder(root->right);
    }
}

void postOrder(Node* root){
    if(root->left){
        postOrder(root->left);
    }
    if(root->right){
        postOrder(root->right);
    }
    printf("%d ", root->value);
}

int main(){

    Node  node1, node2, node3, node4, node5;
    node1.value = 1;
    node2.value = 2;
    node3.value = 3;
    node4.value = 4;
    node5.value = 5;

    node1.left = &node2;
    node1.right = &node3;
    node2.left = &node4;
    /* left, right为空必须用NULL进行初始化 */
    node2.right = NULL;
    node3.left = NULL;
    node3.right = &node5;
    node4.left = NULL;
    node4.right = NULL;
    node5.left = NULL;
    node5.right = NULL;
    preOrder(&node1);
    printf("\n");
    inOrder(&node1);
    printf("\n");
    postOrder(&node1);
    printf("\n");
    return 0;
}
