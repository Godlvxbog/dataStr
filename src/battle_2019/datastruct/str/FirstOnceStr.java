package battle_2019.datastruct.str;

import java.util.HashMap;

/**  剑指Offer ：35
 *
 *
 * 在字符串中，找出第一次只出现一次的字符,
 *
 * abaccdeff  b
 */
public class FirstOnceStr {
    public static void main(String[] args) {
        String str ="abaccdeff";

        char res = firstOnceStr(str);
        System.out.println(res);


    }

    public static char firstOnceStr(String str){
        Integer[] map= new Integer[256];
        for (int i=0;i<256;i++){
            map[i] = 0;
        }
        char[] strs = str.toCharArray();
        for (char c : strs){
            map[c]++;
        }
        char j=0;
        for (int i=0;i < map.length;i++){
            if (map[i] ==1){
                j = (char) i;
                break;
            }
        }
        return j;

    }




}
