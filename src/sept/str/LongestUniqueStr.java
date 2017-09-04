package sept.str;

/**
 * Created by xbog on 2017/9/4.
 * 最长不重复的字符串
 *
 * aabcb :为abc ：3
 * abcd ： 为abcd ：4
 *
 * 思路：
 * 使用后pre，temp进行临时保存
 * 同样的如使用last,pre,cur等等
 *
 */
public class LongestUniqueStr {

    public static int longestUnique(String str){
        //edge

        //容器
        StringBuffer pre = new StringBuffer();
        StringBuffer cur = new StringBuffer();

        //遍历
        for (int i = 0; i < str.length(); i++) {
            //看当前字符是否是已经在cur中了
            boolean isRpt =  isRepeat(str.charAt(i),cur);
            if (!isRpt){//如果没有重复的话就直接添加到末尾
                cur.append(str.charAt(i));
                pre  = cur;
            }else {//已经存在有重复的
                cur = new StringBuffer();
                cur.append(str.charAt(i));//添加当前节点
            }
        }

        return cur.length()> pre.length() ? cur.length(): pre.length();


    }

    public static boolean isRepeat(char bit ,StringBuffer sb){
        boolean isRepeat = false;
        for (int i = 0; i < sb.length(); i++) {
            if (bit == sb.charAt(i)){
                isRepeat = true;
            }
        }
        return isRepeat;
    }

    public static void main(String[] args) {
        String str = "aabcbcaddefgh";
        int res = longestUnique(str);
        System.out.println(res );

    }
}
