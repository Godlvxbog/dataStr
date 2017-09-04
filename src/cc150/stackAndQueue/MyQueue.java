package stackAndQueue;

import linkedlist.Node;

/**
 * 本质上将，栈和队列都是特殊的链表，入队是尾部添加元素，出队是头部删除元素
 * 栈是往前面生长元素
 */
public class MyQueue {
    Node first,last;

    public void enqueue(Object item){
        if (first ==null){
            last=new Node(item);
            first=last;
        }else{
            last.next=new Node(item);
            last=last.next;// 后移一位
        }
    }

    public Object dequeue(){
        if (first!=null){
            Object item=first.data;
            first=first.next; //后移一位
            return item;
        }else{
            return null;
        }
    }
}
