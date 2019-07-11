package pattern.factory.demo.fun;

import pattern.factory.demo.milk.Milk;
import pattern.factory.demo.milk.Yili;

/**
 * Created by Tom on 2018/3/4.
 */
public class YiliFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
