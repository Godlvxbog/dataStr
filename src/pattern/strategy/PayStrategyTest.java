package pattern.strategy;


import pattern.strategy.payport.PayType;

/**
 * Created by Tom on 2018/3/11.
 * 策略模式：用于决策使用哪种行为，区别于工厂模式，工厂模式在产出不同的对象
 *
 * 1、比如这里的BeanFactory中，有很多种，每个他们的实现方式的有区别的。根据用户的配置，来选择来使用beanFactory
 * 2、比如说Splict拆分器，计价器、filter过滤器、核销器。等。
 * 3、Mysql的db链接，等
 * 最终结果是固定的
 * 中间的过程是不一样的，适合选择哪种渠道，（外围指定）
 *
 * 模板方法：执行流程是固定的，但中间有些步骤是有差异的，用于实现批量生产
 *
 * 比较器、旅行路线、结算支付。
 * 用于包装，
 *
 *
 * 比较策略模式与模板模式：
 * 策略：在于父类的选择，大部分是抽象类的实现，小部分是孩子自己类进行了实现。
 * 模板：父类在于指定一个规范，子类去实现每个规范的具体步骤，重点在于子类实现
 *
 */
public class PayStrategyTest {

    public static void main(String[] args) {

        //省略把商品添加到购物车，再从购物车下单
        //直接从点单开始
        Order order = new Order("1","20180311001000009",324.45);

        //开始支付，选择微信支付、支付宝、银联卡、京东白条、财付通
        //每个渠道它支付的具体算法是不一样的
        //基本算法固定的

        //这个值是在支付的时候才决定用哪个值
        System.out.println(order.pay(PayType.WECHAT_PAY));

        //BeanFactory

        //根据url去自动选择
        //爬取百度的数据     BaiduParser
        //                 SinaParser
        //                 SougouParser
        //返回一个解析好的Json格式，统一好了，保存入库


    }

}
