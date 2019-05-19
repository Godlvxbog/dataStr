package stackAndQueue.minStack;

import java.util.Stack;

/**
 * 设计一个可以获取最小值得栈，时间复杂度为O(1),其实很明显提示需要额外的空间
 *
 * 思路1:
 * 由于只能访问栈顶元素，构造包裹类：min，data
 * 每次压栈，比较min，与当前值，并把更新后的min赋值给当前包裹类的min
 * 分析：缺点，这种做法，如果栈很大时候，每个元素都要记录min，造成很大的空间浪费
 */
public class MinStack extends Stack<NodeWithMin>{

    public  void push(int value){
        int newMin=Math.min(value,peekMin());//比较当前值与min，求其小者
        super.push(new NodeWithMin(value,newMin));//调用父类的push
    }

    public  int peekMin(){
        if (this.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return peek().min;
        }
    }


}



