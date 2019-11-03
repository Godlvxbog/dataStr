package pattern.proxy.jdk;


import pattern.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Tom on 2018/3/10.
 * 关键点：
 * 1、持有target对象
 * 2、Proxy.newProxyInstance生成代理对象
 * 3、实现Invocation类，并复写invoke
 */
public class JDK58 implements InvocationHandler{
    //被代理的对象，把引用给保存下来
    private Person target;

    public Object getInstance(Person target) throws Exception{
        this.target = target;

       Class<?> clazz = target.getClass();

        //下半截，老师深入底层来给大家讲解字节码是如何重组的
        //用来生成一个新的对象（字节码重组来实现）
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before");

        method.invoke(this.target,args);

        System.out.println("After");

        return  null;
    }
}
