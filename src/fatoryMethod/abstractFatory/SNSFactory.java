package fatoryMethod.abstractFatory;

import fatoryMethod.SNSSender;
import fatoryMethod.Sender;

/**
 * Created by Administrator on 2017/2/12.
 */
public class SNSFactory implements Provider {
    @Override
    public Sender produce() {
        return new SNSSender();
    }


}
