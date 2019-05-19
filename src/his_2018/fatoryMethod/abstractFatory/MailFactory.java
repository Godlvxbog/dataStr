package his_2018.fatoryMethod.abstractFatory;

import his_2018.fatoryMethod.MailSender;
import his_2018.fatoryMethod.Sender;

/**
 * Created by Administrator on 2017/2/12.
 */
public class MailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
