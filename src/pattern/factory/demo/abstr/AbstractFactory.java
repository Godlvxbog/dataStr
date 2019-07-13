package pattern.factory.demo.abstr;


import pattern.factory.demo.milk.Milk;

/**
 *
 * 抽象工厂是用户的主入口
 * 在Spring中应用得最为广泛的一种设计模式
 *
 *抽象的符合流水线的。
 */
public abstract class AbstractFactory {

    //公共逻辑通用
//    差异化的定制 抽象方法来实现。

    /**
     * 获得一个蒙牛品牌的牛奶
     * @return
     */
    public  abstract Milk getMengniu();

    /**
     * 获得一个伊利品牌的牛奶
     * @return
     */
    public abstract  Milk getYili();

    /**
     * 获得一个特仑苏品牌的牛奶
     * @return
     */
    public  abstract  Milk getTelunsu();

    public abstract Milk getSanlu();

}
