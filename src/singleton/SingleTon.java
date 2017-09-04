package singleton;

/**
 * 一个J静态的字段instance；
 * 一个私有的构造方法
 * 一个到静态的单例生产类:
 *      判断如果为空就生产；
 *      否则就直接返回字段instance
 */
public class SingleTon {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static SingleTon instance =null;


    public static SingleTon getInstance1(){
        if (instance == null){
            instance = new SingleTon();
        }
        return instance;
    }

    //如果只是这样的话，放在多线程中肯定有问题；所以需要改进

    public static synchronized SingleTon getInstance2(){
        if (instance == null){
            instance = new SingleTon();
        }
        return instance;
    }


//    synchronized关键字锁住的是这个对象，这样的用法，在性能上会有所下降，
//    因为每次调用getInstance()，都要对对象上锁，
//    事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了，
//    所以，这个地方需要改进。我们改成下面这个：

    public static SingleTon getInstance3() {

        synchronized (instance) {
            if (instance == null) {
                instance = new SingleTon();
            }
        }

        return instance;
    }


    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance3();
        System.out.println(instance);

    }
}
