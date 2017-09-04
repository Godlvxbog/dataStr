package sept.str;

import java.util.Stack;

/**
 * Created by xbog on 2017/9/3.
 * I have 20 pens;
 * I evah 02 snep;
 *
 * 把该题目分成两部分：
 *  1 判断何时应该翻转
 *  2 翻转：
 *      - 翻转的长度
 *
 *  思路：
 *      使用栈
 */
public class RevWord {

    public static void revWord(String str){
        //edge
        //遍历
        Stack stack = new Stack();
        for (int i = 0; i< str.length(); i++){
            if (str.charAt(i) != ' ' && i != str.length()-1){
                stack.add(str.charAt(i));
            }else {
                while (!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                if (i != str.length()-1){
                    System.out.print(" ");
                }

            }
        }

    }

    public static void revsencents(String str){
        //edge思路：何时分割 如何rev
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++){

            StringBuffer stringBuffer = new StringBuffer();
            //只要不越界 + 且不是分隔符就一直累加
            while (i < str.length() && str.charAt(i) != ' '){
                stringBuffer.append(str.charAt(i));
                i++;
            }
            //到达分隔符号就添加到栈中
            stack.add(stringBuffer);
        }
        while (!stack.isEmpty()){
            System.out.print( stack.pop() );

            if (stack.size() != 0){
                System.out.print(" ");
            }
        }

    }

    public static void main(String[] args) {
        String str = "I have 20 pens in my country";
//        revWord(str);
        revsencents(str);

    }
}
