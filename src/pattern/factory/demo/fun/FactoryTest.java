package pattern.factory.demo.fun;

import pattern.factory.demo.MilkTypeEnum;
import pattern.factory.demo.milk.Milk;

import java.util.HashMap;

/**
 * Created by Tom on 2018/3/4.
 * 专业化了
 * 增加了用户的创建工厂的操作
 * 用户无需关心那个工厂。
 *
 *
 * 优点：
 *  *  *
 *  *  * 1、公共逻辑卸载抽象类中
 *  *  * 2、差异化的放在抽放方法中，容易扩展与统一
 *  *  *
 *  *  * 比如说现在多了一个三鹿怎么办？
 *  *  *
 *  *  * 1、创建三鹿milk
 *  *  * 2、商检sanluFactory
 *       3、枚举新增加sanluType
 *       4、配置文件中list新增加即可。
 *
 */
public class FactoryTest {
    public static void main(String[] args) {

        /**
         * 一般这里在spring中配置
         */
        HashMap<MilkTypeEnum,Factory> factoryHashMap = new HashMap<>();
        factoryHashMap.put(MilkTypeEnum.SL,new SanluFactory());
        factoryHashMap.put(MilkTypeEnum.MN,new MengniuFactory());
        factoryHashMap.put(MilkTypeEnum.TLS,new TelunsuFactory());


        /**
         * 通过枚举获取工厂，
         * 每个工厂只是做自己的产品，其他的产品不做
         */
        Factory factory =  factoryHashMap.get(MilkTypeEnum.SL);
        Milk milk = factory.getMilk();

        System.out.println(milk.getName());

    }
}
