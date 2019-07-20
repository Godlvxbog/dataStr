package pattern.observer.subject;



import pattern.observer.core.Event;

import java.lang.reflect.Method;

/**
 * Created by Tom on 2018/3/17.
 */
public class ChargeObserverTest {

    public static void main(String[] args) {

        try{

            //观察者
            ChargeObserver chargeObserver = new ChargeObserver();
            Method advice = ChargeObserver.class.getMethod("advice", new Class<?>[]{Event.class});


            //这里写Lily
            TradeSubject tradeSubject = new TradeSubject();
            //在源事件中添加了，事件类型，观察者，观察的方法。
            tradeSubject.addLisenter(SubjectEventType.ON_ADD, chargeObserver,advice);
            tradeSubject.addLisenter(SubjectEventType.ON_EDIT, chargeObserver,advice);
            tradeSubject.addLisenter(SubjectEventType.ON_RMOVE, chargeObserver,advice);
            tradeSubject.addLisenter(SubjectEventType.ON_QUERY, chargeObserver,advice);


            //测试
            tradeSubject.add();
            tradeSubject.remove();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
