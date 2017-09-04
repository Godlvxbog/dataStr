package singleton.perfectSingleton;

/**
 * Created by Administrator on 2017/2/12.
 */
public class PerfectSingleton {

    /* 私有构造方法，防止被实例化 */
    private PerfectSingleton() {
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static PerfectSingleton instance = new PerfectSingleton();
    }

    /* 获取实例 */
    public static PerfectSingleton getInstance() {
        return SingletonFactory.instance;
    }



}
