package stackAndQueue.sortStack;

import java.util.Stack;

/**
 * 这里要求，只能最多用两个栈，那么换种栈就不能用了
 * 思路：
 * 设置temp=s.pop()(临时缓冲数据 和哨兵)：如果r的元素较大，就重新移动到s中去，然后把temp插入到r中
 */
public class SortStackII {
    public Stack<Integer> oriSt,sortedSt;
    public SortStackII(){
        oriSt=new Stack<Integer>();
        sortedSt=new Stack<Integer>();
    }

    public Stack<Integer> sort(){
        while (!oriSt.isEmpty()){
            int temp=oriSt.pop();
            while (!sortedSt.isEmpty() && sortedSt.peek() >temp){
                oriSt.push(sortedSt.pop());
            }
            sortedSt.push(temp);
        }
        return sortedSt;
    }
}
