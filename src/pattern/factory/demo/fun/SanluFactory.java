package pattern.factory.demo.fun;


import pattern.factory.demo.milk.Milk;
import pattern.factory.demo.milk.Sanlu;

/**
 * Created by Tom on 2018/3/4.
 */
public class SanluFactory implements  Factory {
    @Override
    public Milk getMilk() {
        return new Sanlu();
    }
}
