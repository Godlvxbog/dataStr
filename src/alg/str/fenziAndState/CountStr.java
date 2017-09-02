package alg.str.fenziAndState;

/**
 * 字符串的统计字符串
 *
 * aaabbaaccca
 * a_3_b_2_a_2_c_3_a_1;
 *
 * 循环遍历，获取长度
 *
 * if (alg.str[i] == alg.str[i-1]): 记录其相等的连续数字num++
 * 如果出现不相等，就连接并num置为1；
 */
public class CountStr {

    public static String countStr(String str){
        //
        if (str == null || str.length() == 0){
            return str;
        }

        char[] arr = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append(arr[0]);

        int num = 1;//连续出现的字符次数
        for (int i = 1; i<arr.length; i++){
            if (arr[i] != arr[i-1]){
                //连接并置num为0；
                sb.append(myConcat(num,String.valueOf(arr[i])));
                num = 1;
            }else{
                num++;
            }
        }

        sb.append(myConcat(num,""));
        return String.valueOf(sb);
    }

    public static String myConcat(int num, String s3){
        String bit = (s3.equals("")) ? s3 : "_" +s3;
        return "_" + num + bit;
    }
    public static void main(String[] args) {
        String ste = "aaabbaassssccca";
        String res = countStr(ste);
        System.out.println(res);
    }
}
