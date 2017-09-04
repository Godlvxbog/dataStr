package fatoryMethod;

/**
 * Created by Administrator on 2017/2/12.
 */
public class SNSSender implements Sender {
    @Override
    public void send() {
        System.out.println("这是一个SNS Sender");
    }
}
