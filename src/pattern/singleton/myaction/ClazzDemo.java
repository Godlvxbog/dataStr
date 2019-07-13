package pattern.singleton.myaction;

/**
 * 测试class相关方法
 *
 * 加载类，方式二：Class.forName,通过序列化实现初始化bean，常见于spring容器中
 */
public class ClazzDemo {

    public static void main(String[] args) throws Exception {
        MyBeanFactory myBeanFactory = new MyBeanFactory();
        //加载类，方式一：myBeanFactory.getClass()
        System.out.println(myBeanFactory.getClass());//class pattern.singleton.myaction.MyBeanFactory
        //加载类，方式二：Class.forName,通过序列化实现初始化bean，常见于spring容器分钟
        Object object = Class.forName("pattern.singleton.myaction.MyBeanFactory");


        //class类的常用方法，创建一个实例：与实例化 new MyBeanFactory（）一个意思
        Object obj2 = Class.forName("pattern.singleton.myaction.MyBeanFactory").newInstance();
        Object name = Class.forName("pattern.singleton.myaction.MyBeanFactory").getName();

        Object classLoader = Class.forName("pattern.singleton.myaction.MyBeanFactory").getClassLoader();
        Object classLoader1 = Class.forName("pattern.singleton.myaction.MyBeanFactory").getClassLoader().getParent();
        Object classLoader2 = Class.forName("pattern.singleton.myaction.MyBeanFactory").getClassLoader().getParent().getParent();

        System.out.println(classLoader +"   " +classLoader1+"   " +classLoader2);

        Object superclass = Class.forName("pattern.singleton.myaction.MyBeanFactory").getSuperclass();
        System.out.println(superclass);


    }


}


