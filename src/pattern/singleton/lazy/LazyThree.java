package pattern.singleton.lazy;

/**
 * Created by Tom on 2018/3/7.
 *
 * 原理
 *
 * 1、创建一个单例持有者InstanceHolder创建了，但并不加载 static
 * 2、getInstance，获取持有者 static findal
 * 3、构造方法，第一次会创建InstanceHolder
 *
 *父类的静态代码块->子类的静态代码块->初始化父类的属性值/父类的普通代码块(自上而下的顺序排列)->父类的构造方法->初始化子类的属性值/子类的普通代码块(自上而下的顺序排列)->子类的构造方法。
 *
 * 带有static关键字的代码块应该是最先执行，其次是非static关键字的代码块以及类的属性(Fields),最后是构造方法。带上父子类的关系后，上面的运行结果为：
 *
 *
 *
 * 根据内部类不会在其外部类被加载的同时被加载的事实，我们可以引申出单例模式的一种实现方式： 静态内部类
 */

//懒汉式单例
    //特点：在外部类被调用的时候内部类才会被加载
    //内部类一定是要在方法调用之前初始化
    //巧妙地避免了线程安全问题

    //这种形式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题
    //完美地屏蔽了这两个缺点
    //史上最牛B的单例模式的实现方式
public class LazyThree {

    private boolean initialized = false;

    //默认使用LazyThree的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的

    private LazyThree(){

        synchronized (LazyThree.class){
            if(initialized == false){
                initialized = !initialized;
            }else{
                throw new RuntimeException("单例已被侵犯");
            }
        }

    }


    //每一个关键字都不是多余的
    //static 是为了使单例的空间共享
    //保证这个方法不会被重写，重载
    public static final LazyThree getInstance(){
        //在返回结果以前，一定会先加载内部类
        System.out.println(System.currentTimeMillis()+":" +LazyHolder.LAZY);
        return LazyHolder.LAZY;
    }


    //new出类放在内部类中，默认不加载：只有使用才会加载
    private static class LazyHolder{
        private static final LazyThree LAZY = new LazyThree();
    }


}
