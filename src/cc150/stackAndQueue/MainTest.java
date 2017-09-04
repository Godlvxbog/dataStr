package stackAndQueue;

import stackAndQueue.minStack.MinStack;
import stackAndQueue.minStack.MinStack2;
import stackAndQueue.sortStack.SortStack;
import stackAndQueue.sortStack.SortStackII;

/**
 * Created by Administrator on 2016/11/13.
 */
public class MainTest {
    public static void main(String[] args) {

        ///==================测试Tower
//        testTower();
//        testMyqueue();

//        testsortStack();
        testsortStackII();
    }

    public static void testTower(){
        final int NUM=3;//3个Tower
        HanLuoTower[] towers=new HanLuoTower[NUM];
        for (int i=0;i<NUM;i++){
            towers[i]=new HanLuoTower(i);//初始化3个Tower
        }

        int n=3;
        //下面对ORi的Tower进行加入盘子
        for (int i=n;i>=1;i--){
            towers[0].add(i);
        }
        towers[0].moveDisks(n,towers[1],towers[2]);
    }

    public static void testMinStack(){
        MinStack minStack=new MinStack();
        minStack.push(5);
        minStack.push(6);
        minStack.push(3);
        minStack.push(7);
        minStack.pop();
        minStack.pop();
        //========测试：用一个栈来保存最小值

        MinStack2 minStack2=new MinStack2();
        minStack2.push(5);
        minStack2.push(6);
        minStack2.push(3);
        minStack2.push(7);
        minStack2.push(1);
        minStack2.pop();
        minStack2.pop();
        minStack2.pop();
    }

    public static void testMyqueue(){
        MyQueue2 myq=new MyQueue2();
        myq.add(1);
        myq.add(2);
        myq.add(3);
        myq.add(4);
        myq.add(5);

        System.out.println(myq.remove());
        System.out.println(myq.remove());
        System.out.println(myq.remove());
        System.out.println(myq.remove());

    }

    public static void testsortStack(){
        SortStack srtStack=new SortStack();
        srtStack.oriSt.push(7);
        srtStack.oriSt.push(10);
        srtStack.oriSt.push(5);
        srtStack.oriSt.push(2);
        srtStack.oriSt.push(8);

        int minval=srtStack.getMin();

        while (!srtStack.shiftStack(minval).isEmpty()){
            minval=srtStack.getMin();
        }
    }

    public static void testsortStackII(){


        SortStackII sortII=new SortStackII();
        sortII.oriSt.push(10);
        sortII.oriSt.push(3);
        sortII.oriSt.push(8);
        sortII.oriSt.push(2);
        sortII.sort();
    }

}
