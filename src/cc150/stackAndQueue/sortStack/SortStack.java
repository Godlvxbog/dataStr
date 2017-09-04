package stackAndQueue.sortStack;

import java.util.Stack;

/**
 * 最多用两个栈，来实现一个栈的升序排列；
 * 思路：
 * 1、设置一个缓冲栈，用来装最小值 这里面需要三个栈，原栈，最小值栈，sorted的栈
 */
public class SortStack {
    public Stack<Integer> oriSt,bufSt,sortedSt;
    public SortStack(){
        oriSt=new Stack<Integer>();
        bufSt=new Stack<Integer>();
        sortedSt=new Stack<Integer>();
    }

    //getmin
    public int getMin(){
        int minVal=oriSt.peek();
        while (!oriSt.isEmpty()){

            if (oriSt.peek() <minVal){
                minVal=oriSt.peek();
            }
            bufSt.push(oriSt.pop());
        }

        sortedSt.push(minVal);
        return minVal;
    }

    public Stack<Integer> shiftStack( int minVal){

        //复制回来到oriSt
        while ( !bufSt.isEmpty()){
            if (bufSt.peek() == minVal){
                bufSt.pop();
            }
            if (!bufSt.isEmpty()){
                oriSt.push(bufSt.pop());
            }
        }
        return oriSt;
    }

    //







}
