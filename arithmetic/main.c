//
//  main.c
//  数据结构与算法
//
//  Created by 家乐淘 on 2017/9/1.
//  Copyright © 2017年 家乐淘. All rights reserved.
//

#include <stdio.h>
#include <mm_malloc.h>

typedef struct Node
{
    int data;
    struct Node * pNext;
}NODE,*PNODE;
//NODE等价于struct Node ,PNODE等价于struct Node*
//函数需要提前声明
PNODE create_list();
void traverse_list(PNODE pHead);
_Bool is_empty(PNODE pHead);
int length_list(PNODE pHead);
_Bool insert_list(PNODE pHead,int pos,int val);


int main(int argc, const char * argv[]) {
   
    PNODE pHead = NULL;
    pHead = create_list();
    length_list(pHead);
//    traverse_list(pHead);
//    if (is_empty(pHead) == 1) {
//        printf("链表不为空");
//    }
//    else
//    {
//        printf("链表为空");
//    }
    return 0;
}
//创建链表
PNODE create_list()
{
    int len;
    int val;
    PNODE pHead = (PNODE)malloc(sizeof(NODE));
    if (pHead == NULL) {
        printf("内存分配失败,程序终止");
        exit(-1);
    }
    PNODE pTail = pHead;
    pTail -> pNext = NULL;
    printf("请输入您需要生成的链表节点的个数:len = ");
    scanf("%d",&len);
    for (int i = 0; i<len; i++) {
        printf("请输入第%d个节点的值: ",i+1);
        scanf("%d",&val);
        PNODE pNew = (PNODE)malloc(sizeof(NODE));
        if (pNew == NULL) {
            printf("内存分配失败,程序终止\n");
            exit(-1);
        }
        pNew->data = val;
        pTail -> pNext = pNew;
        pNew -> pNext = NULL;
        pTail = pNew;
    }
    return pHead;
}
//遍历链表
void traverse_list(PNODE pHead)
{
    PNODE p = pHead->pNext;
    while (NULL != p) {
        printf("%d",p->data);
        p = p->pNext;
        printf("\n");
    }
    printf("\n");
}
_Bool is_empty(PNODE pHead)
{
    if (pHead ->pNext == NULL) {
        return 0;
    }
    else
    {
        return 1;
    }
    
}
int length_list(PNODE pHead)
{
    int i = 0;
    PNODE p = pHead -> pNext;
    
    while (p != NULL) {
        i++;
        p = p->pNext;
    }
    
    printf("链表的长度为%d\n",i);
    return i;
}
void sort_list(PNODE pHead)
{
    
}
_Bool insert_list(PNODE pHead,int pos,int val)
{
    PNODE p = pHead;
    int i = 0;
    while (p != NULL && i < pos - 1) {
        p = p -> pNext;
        ++i;
    }
    
    if (i > pos - 1 || p == NULL) {
        return 0;
    }
    PNODE pNew = (PNODE)malloc(sizeof(NODE));
    pNew -> data = val;
    p -> pNext = pNew;
    
    return 1;
}
