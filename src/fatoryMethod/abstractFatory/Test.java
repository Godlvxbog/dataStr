package fatoryMethod.abstractFatory;

import fatoryMethod.Sender;

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
