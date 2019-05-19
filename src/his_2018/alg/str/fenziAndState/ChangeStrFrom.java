package his_2018.alg.str.fenziAndState;

/**
 * 把字符串str中指定的字符子串from替换成to
 *
 * 思路：
 * 1、把str中含有from字符串中的全部置为XX，
 * 2、然后遍历组合
 *
 *
 */
public class ChangeStrFrom {

    public static String changeStrFrom(String str, String from, String to){
        if (str ==null || from ==null || str.length() == 0 || from.length() == 0){
            return str;
        }

        //
        char[] arr = str.toCharArray();
        char[] arrfrom =from.toCharArray();

        int count =0;//记录当前匹配的个数有几个？

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == arrfrom[count++]){//一次次的连续比较：与from值相同
                //如果长度为给定的值
                if (count == arrfrom.length){
                    arr = cleanRangeStr(arr,i,arrfrom.length);
                    count = 0;
                }
            }else{//与from值不同
                count = 0;
            }
        }

        //下面开始吧空字符替换to中的串
        //不为空，就累加cur，若第一次出现为0，则累加，并重置
        StringBuffer cur = new StringBuffer();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i< arr.length; i++){
            if (arr[i] != 0){
                cur.append(String.valueOf(arr[i]));
            }
            //第一次出现0
            if (arr[i] ==0 &&arr[i - 1] != 0){
                res.append(cur);
                res.append(to);
                cur =new StringBuffer();//重新置为空
            }
        }

        //因为是以第一次出现abc才累加的，如果这段不够组成一个from，那么需要把临时产生的也添加起来
        if (cur.length()!=0){
            res.append(cur);
        }
        return String.valueOf(res);
    }



    public static char[] cleanRangeStr(char[] str,int end,int len){
        while (len-- > 0){
            str[end--] = 0;
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "123abcabcabc12abc12abcab";
        String from = "abc";
        String to = "X";
        String res = changeStrFrom(str,from,to);
        System.out.println(res);
    }
}
