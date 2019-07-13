package pattern.singleton.lazy;

/**
 * Created by Tom on 2018/3/7.
 * 使用时采取新建对象，这里有点像缓存的更新一样，懒加载策略，
 * 只有使用的才去新建
 *
 * 1、使用时才创建，判断，如果没有就创建
 * 2、如果有就直接返回
 */

public class LazyOne {
    private LazyOne(){}


    private static LazyOne lazyOne= null;

    public synchronized static LazyOne getInstance(){
        if (lazyOne == null){
            lazyOne = new LazyOne();
        }
        System.out.println(System.currentTimeMillis()+":" +lazyOne);
        return lazyOne;
    }


//    //静态块，公共内存区域
//    private static LazyOne lazy = null;
//
//    public static LazyOne getInstance(){
//
//        //调用方法之前，先判断
//        //如果没有初始化，将其进行初始化,并且赋值
//        //将该实例缓存好
//        if(lazy == null){
//            //两个线程都会进入这个if里面
//            lazy = new LazyOne();
//        }
//        //如果已经初始化，直接返回之前已经保存好的结果
//
//        return lazy;
//
//    }

}
