package mutiprocess.threadLocaldemo.MyThreadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 包含的几个部分：
 *
 *      字段： 含有同步包装器的HashMap<CurrentTread， T ></>; 你可以尝试下HashTable
 *      方法: get（）。set(), initialValue()
 *
 */
public class MyThreadLocal<T> {

    Map<Thread,T> container = Collections.synchronizedMap(new HashMap<Thread, T>());

    public void set(T value){
        Thread thread = Thread.currentThread();
        container.put(thread,value);
    }

    public   T get(){
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if (value == null && !container.containsKey(thread)){//如果value不存在就初始化，并放入到container中去
            value = initial();
            container.put(thread,value);

        }
        return value;
    }

    public T initial(){
        return null;
    }




}
