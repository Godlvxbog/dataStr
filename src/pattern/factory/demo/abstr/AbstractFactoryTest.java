package pattern.factory.demo.abstr;

/**
 * 对于用户而言，更加简单了，无需关心是什么工厂
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {

        MilkFactory factory = new MilkFactory();
        //用户只有选择的权利了，保证了程序的健壮性
        System.out.println(factory.getSanlu());

    }

}
