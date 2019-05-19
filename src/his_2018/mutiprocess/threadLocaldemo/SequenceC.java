package his_2018.mutiprocess.threadLocaldemo;

import his_2018.mutiprocess.threadLocaldemo.MyThreadLocal.MyThreadLocal;

/**
 * 测试包含两个类：
 *
 * 1：SequenceA:
 *          初始化 num = 0;
 *          getNum() + 1， 并返回；
 *
 * 2,：extends Thread override run():
 *          打印线程名字与  getNum调用 ：这里需要获取1中的类对象引用
 */
public class SequenceC implements Sequence{

    //字段：num
    /**
     * 使用匿名内部类初始化变量值
     */
    private static MyThreadLocal<Integer> numContainer = new MyThreadLocal<Integer>(){
        //覆盖
        @Override
        public Integer initial() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        Integer newValue =  numContainer.get() + 1;//可以就是currentThread
        numContainer.set(newValue);
        return newValue;
    }


    public static void main(String[] args) {

        SequenceC sequenceC = new SequenceC();
        MyThread thread1 = new MyThread(sequenceC);
        MyThread thread2 = new MyThread(sequenceC);
        MyThread thread3 = new MyThread(sequenceC);
        thread1.start();
        thread2.start();
        thread3.start();


    }


}
