package sept.dp;

/**
 * Created by xbog on 2017/9/11.
 *
 * 爬楼梯，一次可以爬一级，二级
 * 问 n级楼梯 有有多少种方法可以爬楼梯
 *
 * f(n) = f(n-1) + f(n-2);
 *
 * 类似的如老鼠生小孩，
 * feibonacci的和
 *
 * 思路：确定 底部的端点 f (1) = 1; f(2) = 2
 *
 */
public class ClimbStairs {


    public static int climbStairsNum(int n){
        if (n==1){
            return 1;
        }
        if (n== 2){
            return 2;
        }

        int[] preRes = new int[2];
        preRes[0] = 1;
        preRes[1] = 2;
        int temp = preRes[1];
        for (int i = 3; i<= n ; i++){
            temp = preRes[1];
            preRes[1] = preRes[0] + preRes[1];

            preRes[0] = temp;

        }

        return preRes[1];

    }







    public static void main(String[] args) {
        System.out.println(climbStairsNum(6));
    }
}
