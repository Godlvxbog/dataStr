package mutiprocess.threadLocaldemo;

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
public class SequenceA implements Sequence{

    //字段：num
    /**
     * 使用匿名内部类初始化变量值
     */
//    private ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
//        @Override
//        public Integer initialValue() {
//            return 0;
//        }
//    };

//这样会导致num被多个线程修改，num则不再安全
    private static int num = 0;

    @Override
    public int getNumber() {
        num++;
        return num;
    }

    public static void main(String[] args) {

        SequenceA sequenceA = new SequenceA();
        MyThread thread1 = new MyThread(sequenceA);//传入子类即可。实现了多态
        MyThread thread2 = new MyThread(sequenceA);
        MyThread thread3 = new MyThread(sequenceA);
        thread1.start();
        thread2.start();
        thread3.start();


    }

}
