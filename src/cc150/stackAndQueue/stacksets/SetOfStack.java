package stackAndQueue.stacksets;

import java.util.ArrayList;

/**
 * 多个栈：隐含条件，push等是操作最后一个栈;
 *
 * 需要重新做一遍：进阶
 */
public class SetOfStack {
    ArrayList<StackElement> stackElements=new ArrayList<StackElement>();

    public StackElement getLastStacks(){
        int i=0;
        StackElement last=null;
        for (StackElement stelem:stackElements){
            i++;
            if (stelem.isfullSt()==false){
                last=stelem;
                break;
            }
        }
        return last;
    }

    public void push(int v){
        StackElement last=getLastStacks();
        if (last !=null||!last.isfullSt()){
            last.mypush(v);
        }else{
            StackElement stack=new StackElement();
            stack.mypush(v);
            stackElements.add(stack);

        }
    }

    public void pop(){
        StackElement last=getLastStacks();
        int v=last.pop();
        if (last.count ==0){
            stackElements.remove(last);
        }
    }
}



