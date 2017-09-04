package sept;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xbog on 2017/9/3.
 *  aaabbaaccca --> a_3_b_2_a_2_c_3_a_1;
 *
 *  计算字符串的个数
 *  hash
 *  分支 -
 *     = 找到
 *     = 计算
 *     = 拼凑结果
 */
public class CountStr {

    public static String convntNum(String str){
        //edge
        //数据结构

        int[] map = new int[256];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i< str.length(); i++){
            map[str.charAt(i)] = 1;
            //找到想相同的字符串
            while (i + 1 <str.length() && str.charAt(i) == str.charAt(i+1)){
                map[str.charAt(i)] ++;

                i++;
            }
            stringBuffer.append(str.charAt(i));
            stringBuffer.append("_");
            stringBuffer.append(map[str.charAt(i)]);

            stringBuffer.append("_");
        }
        stringBuffer.delete(stringBuffer.capacity()-1,stringBuffer.capacity());
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String str = "ssbbssswww";
        String res = convntNum(str);
        System.out.println(res );
    }
}
