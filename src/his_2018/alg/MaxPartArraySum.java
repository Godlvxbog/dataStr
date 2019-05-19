package his_2018.alg;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MaxPartArraySum {

    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        //ntemp表示cur == n时候之前的统计之后：
//            如果之前为负，就舍弃，变为新的cur值
        int ntemp = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i<array.length  ; i++){
           if (ntemp <= 0){
               ntemp = array[i]; //舍弃
           }else{
               ntemp += array[i]; // 添加新的元素
           }


            if(max < ntemp){
                max =ntemp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array ={
            1,-2,3,10,-4,7,2,-5
        };

        int res = FindGreatestSumOfSubArray(array);
        System.out.println(res);

    }
}
