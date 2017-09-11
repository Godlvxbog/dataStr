package sept.str;

/**
 * Created by xbog on 2017/9/6.
 */
public class LongestSubArrayMaxSum {

    public static int maxSubArraySum(int[] nums){

        //使用一个oldSum 作为前面所有的最大值
        int nCurSum = 0;//记录n时刻的最大累加和值，
        int nMaxSum = Integer.MIN_VALUE;//保存最大值
        for (int i= 0; i< nums.length; i++){
            if (nCurSum <= 0){
                nCurSum  = nums[i];
            }else {
                nCurSum += nums[i];
            }

            //，只有n更新最大值
            if (nCurSum > nMaxSum){
                nMaxSum = nCurSum;
            }
        }

        return nMaxSum;
    }

    public static void main(String[] args) {

        int[] nums = {
                1,-2,3,10,-4,7,2,-5,
        };

        int res = maxSubArraySum(nums);
        System.out.println(res);
    }
}
