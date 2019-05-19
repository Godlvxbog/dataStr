package his_2018.sept.dp;

/**
 * Created by xbog on 2017/9/11.
 *
 * 最大的连续子数组的和
 *
 * max = Math.max( sum[i - 1] + arr[i] ,arr[i] );
 * 一句话：加上过去的和是否满足递增，不是的话，就是当前值，是的话，就直接累加
 */
public class LongestSumContinsArr {

    public static int longSumContinusArr(int[] arr){

        int[] sum = new int[arr.length+1];
        sum[0] = arr[0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (sum[j -1] > 0){
                    sum[j] = sum[j-1]+ arr[j];
                }else {
                    sum[j] = arr[j];
                }

            }

        }


        //
        int maxRes = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > maxRes){
                maxRes = sum[i];
            }
        }

        return maxRes;

    }


    public static void main(String[] args) {
        int[] arr = {
                1,-2,3,10,-4,7,2,-5
        };

        int res = longSumContinusArr(arr);
        System.out.println(res);
    }
}
