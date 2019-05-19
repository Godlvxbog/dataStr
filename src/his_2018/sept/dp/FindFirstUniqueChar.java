package his_2018.sept.dp;

/**
 * Created by xbog on 2017/9/3.
 * 剑指offer 55题目和35题目 字符串
 * 找出第一个不重复的字符：
 *
 * 数据结构：map进行统计
 * 使用分支和状态控制
 */
public class FindFirstUniqueChar {

    public static char findFirstUniqChar(String str){
        //edge
        int[] map = new int[256];//保存次数

        //统计每个元素出现的 次数
        for (int i = 0; i< str.length(); i++){
            map[str.charAt(i)]++;
        }

        //[重要：遍历字符串而非hash表]
        for (int i = 0;i< str.length();i++){
            if (map[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        String str = "google";
        char res = findFirstUniqChar(str);
        System.out.println(res);

    }
}
