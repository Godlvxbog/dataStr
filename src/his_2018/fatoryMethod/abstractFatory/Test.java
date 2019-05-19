package his_2018.fatoryMethod.abstractFatory;

import his_2018.fatoryMethod.Sender;

/**
 * Created by Administrator on 2017/2/12.
 */
public class Test {
    public static void main(String[] args) {

        Provider factory = new MailFactory();
        Sender  mail = factory.produce();
        mail.send();
    }
}
