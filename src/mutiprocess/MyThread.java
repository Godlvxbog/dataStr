package mutiprocess;

/**
 * Created by Administrator on 2017/2/13.
 */
public class MyThread extends Thread {
    @Override
    public void run() {

        for (int i=0; i<10;i++){

            System.out.println("我开的线程"+Thread.currentThread().getName()+ "======"+ i );

        }
    }
}
