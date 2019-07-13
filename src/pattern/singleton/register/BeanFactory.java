package pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Tom on 2018/3/7.
 * Spring中的做法，就是用这种注册式单例
 * 关键点：
 * 1、用ConcurrentHashMap构造一个线程安全的ioc容器，作为一个注册表，没有的话就创建变登记
 * 2、对1实现static创建时就要加载
 * 3、使用Class.forName(className).newInstance()获取java对象
 */

//Spring中的做法，就是用这种注册式单例
public class BeanFactory {

    private BeanFactory(){}

    //线程安全
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();

    public static Object getBean(String className){

        if(!ioc.containsKey(className)){
            Object obj = null;
            try {
                obj = Class.forName(className).newInstance();
                ioc.put(className,obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        }else{
            return ioc.get(className);
        }

    }


}
