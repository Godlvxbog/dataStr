package pattern.proxy.staticed;

/**
 * 代理：做事情实际上是由代理来做，比如这里的 father.findLove();
 * 这里演示了拦截模式：
 * 代理类需要拿到目标类的索引，
 */
public class StaticProxyTest {

    public static void main(String[] args) {

        //只能帮儿子找对象
        //不能帮表妹、不能帮陌生人
        Father father = new Father(new Son());

        father.findLove();

    }
}
