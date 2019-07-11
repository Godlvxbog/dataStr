package battle_2019.interview;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 累加计数器
 */
public class SimpleCounter {

    public long count= 0;//计数器

    /**
     * 累加器
     */
    public void add(){
        count++;
    }


    /**
     * 内部类
     */
    public static class Count extends Thread{
        private  SimpleCounter simpleCounter;

        public Count (SimpleCounter simpleCounter){
            this.simpleCounter = simpleCounter;
        }

        @Override
        public void run() {

            for (int i=0;i<1000;i++){
                simpleCounter.add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleCounter simpleCounter = new SimpleCounter();
        Count count1= new Count(simpleCounter);
        Count count2= new Count(simpleCounter);
        count1.start();
        count2.start();
        Thread.sleep(50);
        System.out.println(simpleCounter.count);
    }
}
