package pattern.singleton.test;




import pattern.singleton.lazy.LazyOne;
import pattern.singleton.lazy.LazyThree;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Tom on 2018/3/8.
 *
 * layOne获取2000个实例，只要86ms，2而layTwo需要800ms
 */
public class HungryTest{
    static int count =2000;
    static final CountDownLatch latch = new CountDownLatch(count);

    public static void testHungryThread(){

        long start = System.currentTimeMillis();

        //内部类
        class demo implements Runnable{
            @Override
            public void run() {
                //创建完成之后countDown
                LazyThree.getInstance();
                try {
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }


        /**
         * 带有200个的倒计时器
         */
        //新建两百个线程任务
        ExecutorService executorService = Executors.newFixedThreadPool(count);

        int i=0;
        for (i = 0 ; i < count ; i++) {
            executorService.submit(new demo());
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fire");
        executorService.shutdown();//一定要关闭线程池

        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));

    }






    public static void main(String[] args) {
        testHungryThread();
//        testHungry();
    }

    public static void testHungry(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000;i ++) {

            Object obj =LazyOne.getInstance();
            System.out.println(obj);
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }
}
