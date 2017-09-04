package sept.str;

/**
 * Created by xbog on 2017/9/3.
 * 判断一个字符串所有字符串是否是都是唯一的：
 * 统计次数使用hash
 */
public class IsUniqueChar {

    /**
     * [模式识别：使用要统计次数就使用hash表]
     * @param str
     * @return
     */
    public static boolean isUniqueChar(String str){
        //使用hash进行次数的统计;
        //所有的ASCII 的映射范围在 0 --- 256；[思考：hash表的值域是什么范围]
        int[] times =  new int[256];

        //遍历，构造key （当前元素）- value（次数）
        char[] chars = str.toCharArray();//吧字符串转换成字符数组

        //下面直接是数组的计算方法即可

        for (int i = 0; i < chars.length; i++){
            //对于每个字符串的操作[思考：遍历对于每个字符你要做什么]
            //构造初始化hash表，以及根据细节实现判断
            if (times[chars[i]] == 1 ){
                return false;
            }
            times[chars[i]] = 1;
        }
        return true;
    }

public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "helo";
        System.out.println(isUniqueChar(str2));
    }

}
