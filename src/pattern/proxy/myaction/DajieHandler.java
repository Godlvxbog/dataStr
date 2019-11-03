package pattern.proxy.myaction;

import pattern.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Aop的实现
 */
public class DajieHandler implements InvocationHandler {
    Person target;//目标对象

    public Person getProxyInstance(Person person){
        this.target = person;
        Class clazz = target.getClass();
        Person proxy = (Person) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
        return  proxy;


    }

    /**
     * 代理类要做的事情，invoke,需要获取到persion中的所有接口，类加载器，invocation的处理器。
     * Aop思想
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理类要做的事情，invoke
        System.out.println("======前置工作======");
        method.invoke(this.target,args);
        System.out.println("======后置工作======");

        return null;
    }
}
