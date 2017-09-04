package fatoryMethod.abstractFatory;

import fatoryMethod.MailSender;
import fatoryMethod.Sender;

/**
 * Created by Administrator on 2017/2/12.
 */
public class MailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
