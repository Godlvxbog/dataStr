package pattern.factory.demo.sample;


import pattern.factory.demo.MilkTypeEnum;
import pattern.factory.demo.milk.Milk;

/**
 * 小作坊式的工厂模型
 * Created by Tom on 2018/3/4.
 */
public class SimpleFactoryTest {
    /**
     * 一般是在spring环境中是注入实现
     */
    public static SimpleFactory factory = new SimpleFactory();

    public static void main(String[] args) {

        /**
         * 一般是在spring环境中是注入实现
         */
        //把用户的需求告诉工厂
        //创建产品的过程隐藏了，对于用户而且完全不清楚是怎么产生的
        Milk milk = factory.genMilk(MilkTypeEnum.SL);
        System.out.println(milk.getName());

        //知其然，知其所以然，知其所必然

    }
}
