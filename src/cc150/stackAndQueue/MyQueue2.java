package stackAndQueue;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列：
 * 思路：
 * 队列特点就是，先进的先出，，两个栈倒两次
 * 新的stack接受新的元素，oldStack弹出元素
 */
public class MyQueue2 {
    Stack<Integer> oldStack,newStack;
    public MyQueue2(){
        oldStack=new Stack<Integer>();
        newStack=new Stack<Integer>();
    }

    //
    public void shiftStacks(){
        //只有为空时候才能加入全部元素，只需要把弹出的元素放在新的栈中
        if(oldStack.isEmpty()){
            while(!newStack.isEmpty()){
                oldStack.push(newStack.pop());
            }
        }
    }

    //add
    public void add(int value){
        newStack.push(value);
    }
    //peek
    public Integer peek(){
        shiftStacks();//只有old为空才会压栈入
        return oldStack.peek();

    }
    //remove
    public Integer remove(){
        shiftStacks();
        return oldStack.pop();
    }

}
