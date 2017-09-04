package sept;

/**
 * Created by xbog on 2017/9/3.
 * 是否一个单词是是另一个单词的变形单词：
 * 出现的字符串相同且，每个对应的数字的次数也是一致的
 */
public class IsDefWord {

    public static boolean isdefWord(String str1, String str2){
        //edge case

        //构造 hash
        int[] times = new int[256];
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        for (int i = 0; i< chars1.length; i++){
            int bit = chars1[i];
            times[bit] ++;//统计次数
        }

        for (int i = 0; i< chars2.length; i++){
            int bit = chars2[i];
            times[bit]--;//次数回归 到 0
        }

        //judge
        for (int i = 0; i< times.length;i++){
            if (times[i] < 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String str1 = "11223234";
        String str2 = "123123";

        System.out.println( isdefWord(str1,str2));

    }
}
