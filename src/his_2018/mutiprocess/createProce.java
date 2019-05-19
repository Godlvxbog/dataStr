package his_2018.mutiprocess;


/**
 * Created by Administrator on 2017/2/13.
 */
public class createProce {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0;i<10; i++){
            System.out.println("Main 的线程："+Thread.currentThread().getName() +"---------"+ i);
            MyThread thread1 =new MyThread();
            MyThread thread2 = new MyThread();
            if (i ==3 ){
                Thread.sleep(2000);
                //开启我的线程

                thread1.start();
                thread2.start();
            }
        }

    }


}
