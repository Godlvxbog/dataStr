package alg.str;

/**
 * 判断是否是变形词：
 * 字符种类一样，且次数一样
 *
 * 思路：
 * 1、用Hash表装每一个字符出现的次数，map是一个词频表
 * 2、先累加，再相减，
 * 3、验证map是否回归
 *
 * 注意：
 * 字符串的验证：
 * alg.str.tochararray()
 *
 * 1，alg.str== null ,alg.str.length() ==0[空串]，及时返回
 */
public class IsDeformation {

    public static boolean isDef(String str1, String str2){
        if (str1== null || str2 == null || str1.length() == 0 || str2.length() == 0){
            return false;
        }
        //转换成字符数组；
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[] map =new int[256];//每个字符作为索引
        for (int i = 0; i<arr1.length;i++){
            char bit = arr1[i];
            map[bit] ++;
        }

        for (int i = 0; i<arr2.length;i++){
            char bit =arr2[i];
            map[bit] --;
        }

        for (int i = 0 ;i <map.length;i++){
            if (map[i] != 0){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String str1 = "12311234";
        String str2 = "2313211";
        boolean res = isDef(str1,str2);
    }
}
