package sept.str;

/**
 * Created by xbog on 2017/9/6.
 *
 * 给你一个字符串，得到该字符串的全排列
 *
 * 思路：
 * 吧当前的字符串与后面的每一个进行交换
 */
public class QuanPaiLie {


    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        permutation(chars,0);
    }

    public static void permutation(char[] chars, int from){

        if(from == chars.length){
            System.out.println(chars);
            return;
        }
        else{
            for(int i = from; i< chars.length;i++) {
                swap(chars,from,i);
                permutation(chars, from+1);
                swap(chars,from,i);
            }
        }
    }

    public static void swap(char[] chars, int begin, int cur ){

        char temp = chars[begin];
        chars[begin] = chars[cur];
        chars[cur] = temp;

    }
}



