package his_2018.sept.dp;

/**
 * Created by xbog on 2017/9/11.
 *
 * 零钱 凑的问题
 * 零钱的面币集合{1,2} 需要凑的钱是 N
 * 那么这个题目其实就退化成了青蛙跳问题了
 *
 * ways[i] = ways[i-s(j),j] //使用j来凑出来 i元 使用了j的上一个阶段
 *            + ways[i,j-1]//不用凑出来i元     不适用j的上一个阶段
 *
 * ways[i] += ways[i - fund[j]]
 *
 *
 * 问题2 ：求出需要最小的硬币的个数
 *
 * if(table[i] > table [i - fund[j]] 那么只需要增加一个即可 )
 *
 */
public class MoneyCountWays {



    public static int countMoneyWays2(int[] fund, int amount){
        int[] ways = new int[amount + 1];
        ways[0] = 1;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < fund.length; j++) {

                if (i -fund[j] >= 0){
                    ways[i] += ways[i - fund[j]];
                }
            }
        }
        return ways[amount];
    }


    public static int minCoinChange(int[] fund, int amount){
        int[] coins = new int[amount + 1];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.MAX_VALUE;
        }

        coins[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < fund.length; j++) {

               if ( i >= fund[j] && coins[i] > coins[i - fund[j]]){
                   coins[i] = coins[i - fund[j]] + 1;
                }
            }
        }
        return coins[amount];
    }



    public static void main(String[] args) {
        int[] fund = {
                1,2,5
        };

        int amount = 10;

        int res =  minCoinChange(fund,amount);
        System.out.println(res);


    }

}
