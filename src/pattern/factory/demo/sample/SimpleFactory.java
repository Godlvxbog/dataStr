package pattern.factory.demo.sample;


import pattern.factory.demo.MilkTypeEnum;
import pattern.factory.demo.milk.*;

/**
 * switch case
 * 工厂就是一个创建对象用的
 */
public class SimpleFactory {

    public Milk genMilk(MilkTypeEnum milkTypeEnum){

        //创建对象
        Milk milk = null;
        switch (milkTypeEnum){
            case TLS:
                milk = new Telunsu();
                break;
            case MN:
                milk = new Mengniu();
                break;
            case SL:
                milk = new Sanlu();
                break;
            case YL:
                milk = new Yili();
                break;
            default:
                new Exception("不能识别的牛奶");
        }
        return milk;
    }

}
