package his_2018.alg.str;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入：
 * 两个字符串，返回其最小字典序合并字符串
 *
 * 练习使用compareTo();
 * arrays.sort(array,new MyComparator());等
 */
public class LowestString {

    public static String lowStrings(String[] strs){

        Arrays.sort(strs,new MyComparator());

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < strs.length; i++){
            res.append(strs[i]);//合并字符串
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        String[] strs =new String[3];
        strs[0] = "ad";
        strs[1] = "bb";
        strs[2] = "azzz";

        String str = lowStrings(strs);
        System.out.println(str);
    }


//    Comparator<String>
    static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String str1, String str2) {
            return (str1 + str2).compareTo(str2 + str1);
        }


    }
}
