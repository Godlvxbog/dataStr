package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你数字，返回所有字符串的的组合。
 * 题目 17
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() ==0){
            return res;
        }

        findcombintion(digits,0,"");
        return res;
    }

    public List<String> res = new ArrayList<>();

    public static final String[] letterMap = {
            "",  // 0
            "",  // 1
            "abc",  // 2
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",  // 7
            "tuv",
            "wxyz",  // 9
    };

    /**
     *  handledStr = digits[0,index-1] ,
     *  当前的组合 为  handledStr + digits[index]
     * @param digits 要处理的字符串
     * @param index 要处理的索引的值 ：也就是 获取到 digits[index]的值就可以了。
     * @param handledStr  从[0,indexx-1]得到字符串
     */
    private void findcombintion(String digits,int index,String handledStr){
        if(index ==digits.length()){
            //这里就到了末尾了。并保存
            res.add(handledStr);
            return;
        }

        //数组前置处理
        char c = digits.charAt(index);
        assert (c >='0' && c <= '9' && c != '1' );

        String letters = letterMap[c - '0'];

        //开始遍历了。

        for (int i = 0; i < letters.length(); i++) {
            findcombintion(digits,index+ 1, handledStr + letters.charAt(i));
        }
        return;

    }
}
