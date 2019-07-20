package pattern.observer.core;

import pattern.observer.subject.ChargeObserver;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件的注册和监听
 * Created by Tom on 2018/3/17.
 */
public class EventLisenter {

    //Map相当于是一个注册器
    protected Map<Enum, Event> events = new HashMap<Enum, Event>();

    public void addLisenter(Enum eventType, Object target, Method callback) {
        //注册事件
        //用反射调用这个方法
        events.put(eventType, new Event(target, callback));
    }

    /**
     * 获取方法，并调用通知。
     * @param event
     */
    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            Method advice =  event.getCallback();
            //观察者中有method方法：发送消息体
            Object chargeObserver = (Object)event.getTarget();
            //chargeObserver.advice(event);
            advice.invoke(chargeObserver, event);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    protected void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        //相当于new了一个事件：决策时哪一类型的事件
        Event event = this.events.get(call);
        event.setTrigger(call.toString());//设置动作
        trigger(event);
    }


}
