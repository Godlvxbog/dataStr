package stackAndQueue;

import linkedlist.Node;

/**
 * Created by Administrator on 2016/11/12.
 */
public class MyStack {
    Node top;

    public void push(Object item){
        Node t=new Node(item);
        t.next=top;//放在原来的top的前面，
        top=t;//更新新的头节点
    }

    public Object pop(){
        if (top !=null){
            Object item=top.data;
            top=top.next;// 指针后移一位
            return item;
        }else{
            return null;
        }
    }

    public Object peek(){
        return top.data;
    }



    public static void main(String[] args) {

        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(5);

        System.out.println( myStack.peek());
        myStack.pop();
        myStack.pop();
        System.out.println( myStack.peek());
    }


}
