package pattern.observer.subject;


import pattern.observer.core.Event;

/**
 * Created by Tom on 2018/3/17.
 */
public class ChargeObserver {

    public void advice(Event event){
        System.out.println("发送了消息过来：\n" + event );

        /*
        *  input
        *  input.addLisenter("click",function(){
        *
        *
        *  });
        *
        *
        * */
    }

}
