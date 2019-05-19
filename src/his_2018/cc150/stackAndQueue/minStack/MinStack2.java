package stackAndQueue.minStack;

import java.util.Stack;

/**
 * 思路：
 * 如果要压入元素比 s2的top值小，那么s2也压栈，更新最小值;
 * 如果弹出元素是最小值，那么s2也要弹出：
 *
 * 好处：节省空间，只有更小的值才会在s2中保存
 */
public class MinStack2 extends Stack<Integer>{
    //增加一个存放最小值得栈
    public  Stack<Integer> s2;
    public MinStack2(){
        s2=new Stack<Integer>();//当栈初始化是就有这么一个栈
    }

    public void push(int value){
        if (value <= s2min()){
            s2.push(value);//如果是个比当前值小，才压栈
        }
        super.push(value); //自身压栈
    }

    public Integer pop(){
        int value=super.pop();//弹出元素
        if (value==s2min()){ //如果是最小值，s2也要弹出
            s2.pop();
        }
        return value;
    }

    public  int s2min(){
        if (s2.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return s2.peek();
        }
    }
}
