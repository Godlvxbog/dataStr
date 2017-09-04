package stackAndQueue.stacksets;

import java.util.Stack;

/**
 * Created by Administrator on 2016/11/13.
 */
public class StackElement extends Stack<Integer>{

    public int count;
    public StackElement(){
        this.count=0;
    }

    public boolean isfullSt(){
        if (this.count >10){
            return true;
        }else{
            return false;
        }
    }

    public int mypush(int value){
        super.push(value);
        this.count++;
        return this.count;
    }

    public int mypop(){
        super.pop();
        this.count--;
        return this.count;
    }
}
