package pattern.factory.demo.abstr;


import pattern.factory.demo.fun.*;
import pattern.factory.demo.milk.*;

/**
 * 用户的主入口
 */
public class MilkFactory extends  AbstractFactory {

    @Override
    public Milk getMengniu() {
        //各自工厂自己创建类
        return new MengniuFactory().getMilk();
    }

    @Override
    public Milk getYili() {
        return new YiliFactory().getMilk();
    }

    @Override
    public Milk getTelunsu() {
        return new TelunsuFactory().getMilk();
    }

    @Override
    public Milk getSanlu() {
        return new SanluFactory().getMilk();
    }
}
