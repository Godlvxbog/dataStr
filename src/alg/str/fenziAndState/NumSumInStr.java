package alg.str.fenziAndState;

/**
 *把字符串中的数字进行加和
 * A-1CB--12    -1 + 12 = 11;
 *
 * 本题侧重于分类的实现：
 *
 * 思路：
 * 遍历，分类，得到数字num，在某个分支进行sum
 *
 * 注意：
 * 标志位：
 * pos，
 * 1、在非‘-’ 时候初始化为true；
 * 2、在为‘-’ ，且前一个不为‘-’，时候初始化为false；，
 * 3、在为‘-’，且前一个为‘-’ ，时候改变pos的符号
 *
 * 分支：
 *
 * 1，如果是数字：计算num，
 * 2，不是数字，累加num，并置为0，并且初始化和改变pos
 *
 */
public class NumSumInStr {

    public static int numSumInStr(String str){
        if (str==null){
            return 0;
        }

        int bit = 0;
        int cur = 0;
        int num = 0;
        int sum = 0;
        boolean pos = true;

        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++){
            bit = arr[i] - '0';
            if (bit > 0 && bit < 9){

                //得到数字
                cur = pos ? bit : -bit;
                num = num * 10 +cur;
            }else{//非数字
                sum += num;//累加和
                num = 0;//置为0；

                if (arr[i] != '-' ){ //不是‘-’，那么只能是字母了
                    pos = true;
                }else{

                    if (i>0 && arr[i-1] =='-'){//如果是‘-’，并且其前一个也是‘-’，那么就反转
                        pos = !pos;//符号的翻转
                    }else{
                        pos =false;//初始化
                    }

                }


            }
        }

        //由于是在非数字时候累加的，最后一个如果是数字需要累加
        int last = arr[arr.length-1]-'0';
        if ( last>0 && last <9  ){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        String str = "A-1B--2C--D6E6";
        int res = numSumInStr(str);
        System.out.println(res);

    }
}
