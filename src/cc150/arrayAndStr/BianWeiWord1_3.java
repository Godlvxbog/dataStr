package arrayAndStr;

import java.util.Arrays;

/**
 * 题目要求：给定两个字符串，确定一个字符串重新排列后是否可以变成另外一个字符串
 * 思路：两个字符串分别变成字符数组，并排序（使得两个字符数组顺序一致），比较两字符数组时候相同
 *
 * 知识点：
 * 1、new String（char[] charsets）  字符数组构造成一个string
 * 2、String.toCharArray();//字符串编程字符数组
 * 3
 *
 */
public class BianWeiWord1_3 {
    public static void main(String[] args) {
        String s1="dog";
        String s2="god";
        String s3="godd";
//        System.out.println(strequal(s1,s2));
        System.out.println(bianweiWord(s1,s2));
    }

    public static String toArrayAndSort(String str){
        char[] content=str.toCharArray();//str--》array
        Arrays.sort(content); //array排序
        return new String(content);  //array--》str
    }

    //判断两个字符串是否相等
    public static boolean strequal(String s,String t){
        //两者长度不相等必定不相等
        if (s.length() != t.length()){
            return false;
        }
        return toArrayAndSort(s).equals(toArrayAndSort(t));
    }
    //======================================================
    //还有另外一中十分容易想得到的：用hash记录第一个字符串中每个字符的出现的次数，
    //然后遍历第二个字符串就减少次数，
    //然后判断hash值回归到初始化  则两者相同

    //运用：这种方法用于，比较两个集合中元素 与 个数 完全相同

    public static boolean bianweiWord(String s,String t){
        //长度不等，必定不等，提前返回
        if (s.length() != t.length()){
            return false;
        }
        //下面判断一般情况
        int[] time_char=new int[256];//对每个字符进行统计个数
        for (int i=0;i<s.length();i++){
            time_char[s.charAt(i)]++;
        }
        for (int i=0;i<t.length();i++){
            time_char[t.charAt(i)]--;
        }

        //下面判断是否相等：hash数组中各个字符串的个数时候回归到初始化
        for (int c:time_char){
            if (c != 0){
                return false;
            }
        }
        return true;
    }

}
