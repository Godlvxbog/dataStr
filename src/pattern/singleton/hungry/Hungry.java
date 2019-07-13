package pattern.singleton.hungry;


/**
 * Created by Tom on 2018/3/7.
 *
 * 饿汉式单例
 * // 它是在类加载的时候就立即初始化，并且创建单例对象
 *
 *     //优点：没有加任何的锁、执行效率比较高，
 *     //在用户体验上来说，比懒汉式更好
 *
 *     //缺点：类加载的时候就初始化，不管你用还是不用，我都占着空间
 *     //浪费了内存，有可能占着茅坑不拉屎
 *
 *     //绝对线程安全，在线程还没出现以前就是实例化了，不可能存在访问安全问题
 *
 *
 *
 *     关键点：
 *     1、static 初始化就加载，
 *     2、final  且不可继承,一般用于初始化的值，防止继承修改
 *     3、使用时直接返回。
 */
public class Hungry {
    /**
     * 类加载顺序：
     * 先静态、后动态
     * 先属性、后方法
     * 先上、后下
     *
     * 1、final：自己产生了不允许别人对其覆盖
     *
     */
    private static final Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        System.out.println(System.currentTimeMillis()+":" +hungry);
        return hungry;
    }
}
