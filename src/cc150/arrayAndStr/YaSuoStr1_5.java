package arrayAndStr;

/**
 * 利用字符重复出现次数，实现字符串的压缩功能，若没有变短没救返回原先的字符串:
 *
 * 尝试用用类指针法：
 *
 * 指针p1指的到开始的第一个字母索引
 * 并用count来记录个数
 * 另外一个是遍历字符串
 *
 * 时间复杂度 O(n);
 */
public class YaSuoStr1_5 {
    public static void main(String[] args) {
        String str1="aaaabcccccaacc";
        String str2="abcddc";

        System.out.println(yasuo(str1));
    }

    public static String yasuo(String str){
        StringBuffer sb=new StringBuffer();
        int p1=0,count=1;
        char start=str.charAt(p1);
        for (int i=1;i<str.length();i++){
            if (start==str.charAt(i)){
                count++;
            }else{
                //
                sb.append(start);
                sb.append(count);
                //更新 指向开通char的指针和个数
                start=str.charAt(i);
                count=1;
            }
        }
        sb.append(start);
        sb.append(count);
        String mystr=sb.toString();
        //选择性输出
        if (mystr.length() <str.length()){
            return sb.toString();
        }else{
            return str;
        }
    }




}
