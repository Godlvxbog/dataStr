package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 343:https://leetcode-cn.com/problems/integer-break/
 */
public class IntegerBreak {

    public static void main(String[] args) {
        int rs = new IntegerBreak().integerBreak(20);
        System.out.println(rs);
    }
    //记忆数组：记忆了第n次的结果为res
    Map map = new HashMap();

    public int integerBreak(int n) {
        assert n >= 2;
        return breakInteger2(n);
    }

    /**
     * 动态规划方法
     *
     * @param n
     * @return
     */
    private int breakInteger2(int n) {
        int a=0;
        map.put(1, 1);
        for (int i = 2; i <= n; i++) {
            //尝试分割,求解map[i]
            for (int j = 1; j <= i - 1; j++) {
                //分割成： j + (i-j) 两个数

                if (map.get(i) != null){
                    a  =(int)map.get(i);
                }
                int res = max3(a, j * (i - j), j * (int) map.get(i - j));
                map.put(i, res);


            }
        }
        return (int)map.get(n);
    }


    /**
     * 将n进行分割，可以获得最大的乘机:递归方式。
     *
     * @param n
     * @return
     */
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }

        //记忆化搜索取值
        if (map.get(n) != null) {
            return (int) map.get(n);
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        map.put(n, res);
        return res;
    }

    private int max3(int a, int b, int c) {
        System.out.println(a+b+c);
        return Math.max(Math.max(a, b), c);
    }

}
