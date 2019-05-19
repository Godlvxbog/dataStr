package his_2018.mutiprocess.threadLocaldemo;

/**
 * Created by Administrator on 2017/2/13.
 *
 */
public class MyThread extends Thread {

    /**
     * 线程直接拿到其父类即可，实现了多态
     *
     */

    Sequence sequence ;

    public  MyThread(Sequence sequence){
        this.sequence = sequence;
    }



    @Override
    public void run() {

        for (int i = 0;i<10;i++){

            System.out.println(Thread.currentThread().getName() +" ----->" + sequence.getNumber());
        }

    }
}
