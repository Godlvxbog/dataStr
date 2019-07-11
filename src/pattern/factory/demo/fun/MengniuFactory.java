package pattern.factory.demo.fun;

import pattern.factory.demo.milk.Mengniu;
import pattern.factory.demo.milk.Milk;

/**
 * Created by Tom on 2018/3/4.
 */
public class MengniuFactory implements  Factory {


    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
