//
//  main.c
//  数据结构与算法
//
//  Created by 家乐淘 on 2017/9/1.
//  Copyright © 2017年 家乐淘. All rights reserved.
//

#include <stdio.h>
#include <mm_malloc.h>
#include <stdlib.h>
typedef struct Node
{
    int data;
    struct Node * pNext;
}NODE,*PNODE;

typedef struct Stack
{
    PNODE pTop;
    PNODE pBottom;
}STACK,*PSTACK;

//NODE等价于struct Node ,PNODE等价于struct Node*
//函数需要提前声明
PNODE create_list();
void traverse_list(PNODE pHead);
_Bool is_empty(PNODE pHead);
int length_list(PNODE pHead);
_Bool insert_list(PNODE pHead,int pos,int val);
void init(PSTACK ps);
void push(PSTACK,int);
_Bool pop(PSTACK , int *);
void Clear(PSTACK);
void traverse(PSTACK);
_Bool empty(PSTACK);

int main(int argc, const char * argv[]) {
    
    //    PNODE pHead = NULL;
    //    pHead = create_list();
    //    insert_list(pHead, 4, 3);
    //length_list(pHead);
    //    traverse_list(pHead);
    //    if (is_empty(pHead) == 1) {
    //        printf("链表不为空");
    //    }
    //    else
    //    {
    //        printf("链表为空");
    //    }
    STACK S;
    init(&S);
    push(&S,1);
    push(&S,2);
    push(&S,3);
    push(&S,4);
    push(&S,5);
    push(&S,6);
    traverse(&S);
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
    printf("%d",p->data);
    
    PNODE pNew = (PNODE)malloc(sizeof(NODE));
    if (pNew == NULL) {
        printf("动态内存分配失败");
        exit(-1);
    }
    
    pNew -> data = val;
    PNODE q = p -> pNext;
    p -> pNext = pNew;
    pNew -> pNext = q;
    
    return 1;
}
_Bool delete_list(PNODE pHead,int pos, int *pVal)
{
    int i = 0;
    PNODE p = pHead;
    
    while (p ->pNext != NULL && i < pos - 1) {
        p = p -> pNext;
        i++;
    }
    if (i > pos - 1 || p == NULL) {
        return 0;
    }
    PNODE q = p -> pNext;
    //????
    *pVal = q -> data;
    //删除p节点后面的节点
    p -> pNext = q -> pNext;
    free(q);
    return 1;
}
void init(PSTACK ps)
{
    ps ->pTop = (PNODE)malloc(sizeof(NODE));
    if (ps -> pTop == NULL) {
        printf("动态内存分配失败!");
        exit(-1);
    }
    else
    {
        ps -> pBottom = ps -> pTop;
        ps -> pTop -> pNext = NULL;
    }
}
void push(PSTACK ps,int val)
{
    PNODE pNew = (PNODE)malloc(sizeof(NODE));
    pNew -> data = val;
    pNew -> pNext = ps -> pTop;
    ps -> pTop = pNew;
}
//把ps所指向的栈出栈一次,并把出栈的元素存入pVal形参所指向的变量中,如果出栈
_Bool pop(PSTACK pS,int *pVal)
{
    if (empty(pS))
    {
        return 0;
    }
    else
    {
        PNODE r = pS -> pTop;
        pS -> pTop = r -> pNext;
        free(r);
        r = NULL;
        return 1;
    }
    
}

void Clear(PSTACK pS)
{
    if (empty(pS)) {
        return;
    }
    else
    {
        PNODE p = pS -> pTop;
        PNODE q ;
        
        while (p != pS -> pBottom)
        {
            q = p -> pNext;
            free(p);
            p = q;
        }
    }
    
}
void traverse(PSTACK pS)
{
    PNODE p = pS -> pTop;
    while (p != pS -> pBottom) {
        printf("%d  ",p -> data);
        p = p -> pNext;
    }
    printf("\n");
}
_Bool empty(PSTACK pS)
{
    if (pS ->pTop ->pNext == NULL) {
        return 1;
    }
    return 0;
}
