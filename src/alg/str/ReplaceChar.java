package alg.str;

/**
 * 把字符串的“ ”转换成%20.
 *
 * 要求：时间为O（N） 空间为 O（1）
 *
 * 由于要求空间为O（1），所以不能直接开新的数组
 *
 * 思路：
 * 从后往前赋值
 *
 * 1，计算出长度j
 * 2，遍历，赋值
 */
public class ReplaceChar {

    public static String replacechar(char[] str){

        //计算长度， j = len + 2*num[空格]；
        int oldlen = str.length;
        int num =0;
        for (int i = 0 ;i < str.length ;i++){
            if (str[i] =='/'){
                num++;
            }
        }

        int len = str.length + 2 *num;
        char[] newStr = new char[len];

        int j = len -1;

        for (int i= oldlen-1; i>=0 ;i--){
            if (str[i] == '/' ){
                newStr[j--] = '0';
                newStr[j--] = '2';
                newStr[j--] = '%';
            }else{
                newStr[j--] = str[i];
            }
        }

        return String.valueOf(newStr );

    }

    public static void main(String[] args) {

        String str = "C:/math/java/1.txt";
        char[] arr=str.toCharArray();
        System.out.println(replacechar(arr));
    }
}
