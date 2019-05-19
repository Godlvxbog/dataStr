package his_2018.mutiprocess;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/3/10.
 */
public class ConCurrentMap {
    private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
    public static void main(String[] args) {
        new Thread("Thread1"){
            @Override
            public void run() {
                map.put(3, 33);
            }
        }.start();

        new Thread("Thread2"){
            @Override
            public void run() {
                map.put(4, 44);
            }
        }.start();

        new Thread("Thread3"){
            @Override
            public void run() {
                map.put(7, 77);
            }
        }.start();
        System.out.println(map);
    }
}
