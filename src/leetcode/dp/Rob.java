package leetcode.dp;

import java.util.List;

/**
 * ROb:
 * <p>
 * https://leetcode-cn.com/problems/house-robber/
 * 198
 * <p>
 * 暴力解法： 2^N个解，然后对每个解判断，会不会触发报警系统，并判断是不是最大的值。
 * 每个房子有两个选择，n个房子就有z^N个组合，同时还要计算价值，那么他的复杂度为 (2^N) * N
 * <p>
 * 组合问题的最优化，比较容易使用递归方式去解决问题。
 * 如果有重叠子问题，和最优子结构，那么可以使用记忆化搜索，动态规划来解决此问题
 */
public class Rob {
    static int[] nums ={4,2,1,3,6,5,7};
    public static void main(String[] args) {
        int res = new Rob().rob(nums);
        System.out.println(res);
    }


    public int rob(int[] nums) {
        int res = tryRob2(nums, 0);
        return res;
    }

    private int[] memo = new int[nums.length];

    /**
     * 考虑抢劫从 nums[index...nums.size())这个范围内的所有的房子
     * 这里存在重叠子问题的，所有应该使用记忆法搜索方法
     */
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        //记忆化搜索
        if (memo[index] != 0) {
            return memo[index];
        }

        //这个是有这些方案，需要再次选择最优的解决方案
        int max = -1;
        for (int i = index; i < nums.length; i++) {
            nums[i] += tryRob(nums, i + 2);
            max = Math.max(max, nums[i]);
        }
        memo[index] = max;
        return max;
    }


    private int tryRob2(int[] nums, int index) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //最小规模的解
        memo[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            //每一步都是切结memo[i]
            for (int j = i; j < n; j++) {
                //考虑偷取j的元素
                int tryRes;
                if (j + 2 < n) {//数组越界考虑
                    tryRes = nums[j] + memo[j + 2];

                } else {
                    tryRes = nums[j];
                }
                memo[i] = Math.max(tryRes, memo[i]);

            }
        }

        return memo[0];
    }
}
