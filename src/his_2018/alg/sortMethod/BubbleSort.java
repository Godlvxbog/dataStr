package his_2018.alg.sortMethod;

/**
 * Created by Administrator on 2017/2/16.
 * 冒泡排序：
 *
 * 思路：
 *
 * 1，循环N次：i = 0 ~ n
 * 2, 每个循环需要遍历 j = 0 ~ n - i-1
 * 3, 交换：利用一个变量存储起来，赋值
 *
 * [注意点] j指的是冒泡对象，比较对象是 j， j+1
 */
public class BubbleSort {


    public static int[] bubbleSort2(int[] nums, int n){
        for (int i = 0; i< n ; i++){
            for (int j = n-1;j>i;j--){//从后往前进行排序，一直到已经排序的了
                int temp = nums[j];
                if(nums[j-1] > temp){//如果前面的值比当前的值还要大，那么就交换
                    swap(nums,j-1,j);
                }
            }

        }
        return nums;


    }

    public static void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;//交换
    }


    public static void main(String[] args) {

        int[] nums = {2,1,4,5,3};//新建数组
        int[] result =  bubbleSort2(nums,5);
        System.out.println(result);

    }
}
