package vm;

import java.util.Vector;

/**
 * Created by Administrator on 2017/2/28.
 */
public class JvmHello {

    private Object instance = null;
    private static final int _10M = 10 * 1 << 20;
    // 一个对象占10M，方便在GC日志中看出是否被回收
    private byte[] bigSize = new byte[_10M];

    public static void testjvm0() {

//        -XX:+PrintGCDetails
//                -XX:+TraceClassLoading
//                -XX:+PrintClassHistogram
//                -Xmx200m
//                -Xms50m
//

        JvmHello objA = new JvmHello();
        JvmHello objB = new JvmHello();

        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024 + "======M====");

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }



    public static void main(String[] args) {
        testjvm1();
    }


    public static void testjvm1() {
        Vector v =new Vector();
        byte[] b = null;
        for (int i = 0; i < 26; i++){
            b = new byte[1 * 1024 * 1024];
            v.add(b);
        }


    }
}
