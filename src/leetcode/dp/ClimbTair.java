package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目 70：
 */
public class ClimbTair {




    //记忆数组：记忆了第n次的结果为res
    Map map = new HashMap();
    public static void main(String[] args) {

        int res = new ClimbTair().climbStairs(20);
        System.out.println(res);
    }

    public int  climbStairs(int n){
        //初始化数组
        return clacWays2(n);
    }

    public  int clacWays2(int n) {
        //第一次和第0次的结果都是1
        map.put(0,1);
        map.put(1,1);

        for (int i= 2; i <= n ; i++){
            int resi = (int)map.get(i-1) + (int)map.get(i-2);
            map.put(i,resi);
        }

        return (int)map.get(n);

    }





    /**
     * 其实非常类似斐波那契额数列。:递归方式
     * @param n
     * @return
     */
    public  int clacWays(int n) {
        //终止条件
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        //递归调用
        int res = 0 ;
        //减枝
        if (map.get(n) == null){
            res = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n,res);
        }
        //之前已经计算过了，就直接返回
        return (int)map.get(n);

    }
}
