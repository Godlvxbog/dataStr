package mutiprocess;

/**
 * Created by Administrator on 2017/2/13.
 */
public class InClazzThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<100; i++){
                    System.out.println("我的内部类的线程"+ Thread.currentThread().getName());
                }
            }
        });

        for (int i =0;i<100;i++){
            System.out.println("Main 线程"+Thread.currentThread().getName());
            if (i == 3){
                Thread.sleep(2000);
                thread.start();
            }
        }







    }




}
