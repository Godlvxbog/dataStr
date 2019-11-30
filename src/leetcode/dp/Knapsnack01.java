package leetcode.dp;

/**
 * 0-1背包问题
 */
public class Knapsnack01 {
    int[][] memo;
    public static void main(String[] args) {

    }


    private int knapsnack01(int[] w, int[] v, int C){
        int n = v.length;
        /**
         * 考虑每个元素，放在背包中的结果的存放
         */
        memo = new int[n][C+1];
        return bestValue2(w,v,n,C);
    }

    /**
     *
     * @param w
     * @param v
     * @param index 考虑[0,index]填充容量为c的背包的最大价值
     * @param c
     * @return
     */
    private int bestValue(int[] w, int[] v, int index, int c){
        if (index < 0 || c <= 0){
            return 0;
        }

        //尝试放入新的物品
        int res = bestValue(w,v,index-1,c);
        if (c >= w[index]){
            res = Math.max(res, v[index] + bestValue(w,v,index-1,c-w[index])) ;
        }
        return res;
    }

    /**
     * 动态规划问题
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    private int bestValue2(int[] w, int[] v, int index, int c){
        if (index < 0 || c <= 0){
            return 0;
        }

        if (memo[index][c] != 0){
            return memo[index][c];
        }

        //尝试放入新的物品
        int res = bestValue(w,v,index-1,c);
        if (c >= w[index]){
            res = Math.max(res, v[index] + bestValue(w,v,index-1,c-w[index])) ;
        }
        memo[index][c] =res;
        return res;
    }
}
