package his_2018.fatoryMethod;

/**
 * Created by Administrator on 2017/2/12.
 */
public class SenderFactory {

    /**
     * 普通工厂模式
     * @param type
     * @return
     */
    public Sender produce(String type){

        if ("mail".equals(type)){
            return new MailSender();
        }else if ("sns".equals(type)){
            return new SNSSender();
        }else{
            System.out.println("类型错误");
            return null;
        }
    }


    /**
     * 两种方法的避免type选择的静态方法
     * @return
     */
    public Sender produceMail(){
        return new MailSender();
    }

    /**
     * 静态工厂 方法设置为static即可
     */

    public static Sender produceSNS(){
        return new SNSSender();
    }




//    前面的三种方法有一个问题：违背了扩展的开闭原则，如果需要扩展就要修改工厂，
//    如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则

//    下面尝试：抽象工厂
//    就用到抽象工厂模式，创建多个工厂类，
//    这样一旦需要增加新的功能，直接增加新的工厂类就可以了，
//    不需要修改之前的代码。




    public static void test1(){
        SenderFactory factory = new SenderFactory();
        String type = "mail";
        Sender mail = factory.produce(type);
        mail.send();
    }

    public static void test2(){
        SenderFactory factory = new SenderFactory();
        Sender mail = factory.produceMail();
        mail.send();
    }

    public static void test3(){
        Sender sns =  SenderFactory.produceSNS();
        sns.send();
    }

    public static void main(String[] args) {
        test3();


    }

}
