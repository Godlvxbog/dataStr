package pattern.singleton.myaction;

import java.util.concurrent.ConcurrentHashMap;

public class MyBeanFactory {

    //多线程安全的
    private static final ConcurrentHashMap ioc =new ConcurrentHashMap();

    public MyBeanFactory() {
    }

    public static Object getBean(String className){
       if (!ioc.containsKey(className)){
           try {
               Object object = Class.forName(className).newInstance();
               ioc.put(className,object);
               return ioc.get(className);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       return ioc.get(className);
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 200000000;i ++) {
            Object object = MyBeanFactory.getBean("pattern.singleton.test.Pojo");
            System.out.println(object);
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }
}
