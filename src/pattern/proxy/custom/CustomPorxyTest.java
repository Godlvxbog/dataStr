package pattern.proxy.custom;

import pattern.proxy.jdk.XieMu;
import pattern.proxy.staticed.Person;

/**
 * Created by Tom on 2018/3/10.
 */
public class CustomPorxyTest {

    public static void main(String[] args) {

        try {
            Person obj = (Person)new CustomMeipo().getInstance(new XieMu());
            System.out.println(obj.getClass());
            obj.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
