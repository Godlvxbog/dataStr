package his_2018.fatoryMethod.abstractFatory;

import his_2018.fatoryMethod.SNSSender;
import his_2018.fatoryMethod.Sender;

/**
 * Created by Administrator on 2017/2/12.
 */
public class SNSFactory implements Provider {
    @Override
    public Sender produce() {
        return new SNSSender();
    }


}
