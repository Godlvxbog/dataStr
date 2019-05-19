package his_2018.alg.str.rev;

/**
 * 1 2 3 4
 * 2 3 4 1
 * 判断是否是旋转词
 *
 * 使用
 * string.contains(string);是否包含；
 */
public class IsRotation {

    public static boolean isRotation(String str1, String str2){
        if( str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }

        String b = str1 + str2;
        boolean res = b.contains(str2);
        return res;

    }

    public static void main(String[] args) {
        String str1 = "1234";
        String str2 = "2341";
        String str3 = "3412";

        boolean res = isRotation(str1,str3);
        System.out.println(res);
    }
}
