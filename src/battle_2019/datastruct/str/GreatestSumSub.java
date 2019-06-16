package battle_2019.datastruct.str;

/** 剑指Offer ：31
 * 连续最大子数组的最大和。
 * 输入一个整型的数组，里面有正数也有负数，数组中一个或者多个数组 ,时间复杂度为 O（n）
 *
 * 动态规划
 *
 * 状态方程 ： max( dp[ i ] ) = getMax( max( dp[ i -1 ] ) + arr[ i ] ,arr[ i ] )
 *
 * 遍历到第i个元素时，最大的和可能为max( dp[ i -1 ] ) + arr[ i ] 或者是arr[i],如果max( dp[ i -1 ] ) 是一个负数。arr[i]是一个正数。
 *
 * int array[] = { 2, 3, -6, 4, 6, 2, -2, 5, -9 };
 */
public class GreatestSumSub {
    public static void main(String[] args) {
        int[] arr = { 2, 3, -6, 4, 6, 2, -2, 5, -9 };

        int res = greatestSubSum2(arr);
        System.out.println(res);


    }


    public static int greatestSubSum(int[] arr ){

        int sum = arr[0];
        int maxSum = arr[0];
        for(int i=1; i< arr.length; i++){
            sum = Math.max(sum + arr[i],arr[i]); //其实比较的是如果前面的所有的和Sum[i]>arr[i],说明前面的是一个正数，如果前面是一个负数就方阿奇。

            if (sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static int greatestSubSum2(int[] arr ){

        int oldsum = arr[0];
        int maxSum = arr[0];
        for(int i=1; i< arr.length; i++){
            //是否添加历史，还是重新开始累积
            if (oldsum <=0){
                oldsum = arr[i];
            }else{
                oldsum += arr[i];
            }

            //更新
            if (oldsum > maxSum){
                maxSum = oldsum;
            }

        }
        return maxSum;
    }

}
