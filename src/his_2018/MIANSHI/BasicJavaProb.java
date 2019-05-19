package his_2018.MIANSHI;

/**
 * Created by Administrator on 2017/3/15.
 */
public class BasicJavaProb {
    public static void main(String[] args) {
        int num =127;
        Integer num1 = new Integer(128);//两个不同的引用1
        System.out.println(num == num1);
        // java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer num2 = 127;//两个不同的引用1
//        自动拆箱为int了
        System.out.println(num == num1);
        System.out.println(num2 == num1);

        System.out.println("**********");
        Integer num4 = 127;//又新建了一个数字；如果数字在[-128,127]）之间就会有缓存Integer.cache，从而不会新建数字
        System.out.println(num2 == num4);

        String obj =new String();
        obj.equals("123");

    }

    /**
     * 分析String,系列的源码
     */
    public void testString(){
        String str = "wubo";


    }


}
