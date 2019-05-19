package arrayAndStr;

/**
 * //
 //    题目要求：
 //    确定一个str，判断所有字符是否都不相同。
 //
 //    思路：
 //    对字符串中每个字符进行hash化，构建一个hash[index]来记录每个字符出现的次数
 //    初始时候，hash[index]==false,遍历每个字符，出现就设置为true;

 //    注意点：遍历时候应该是先判断是否出现，如出现就return false 否则就设置为true

 //    知识点：最终返回的是true，中间设置多个中断点来return false 来破坏正常的条件

        分析：时间复杂度为O(n);空间复杂度为(1);
 */
public class IsUniqueChar1_1 {

    public static void main(String[] args) {
        String str1=new String("www.hhtp");
        String str2="nisuom";
        System.out.println(isUniqueChar(str1));
        System.out.println(isUniqueChar(str2));
    }

    public static boolean isUniqueChar(String str){
        if (str.length() > 256 ){
            return false;
        }
        boolean[] char_times=new boolean[256];//对每一个字符hash
        for (int i=0;i<str.length();i++){
            int index_Char=str.charAt(i);
            if (char_times[index_Char] ==true){
                return false;   //遍历中出现破坏点，所以反复退出
            }
            char_times[index_Char]=true;
        }
        return true;
    }
}


