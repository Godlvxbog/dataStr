package battle_2019.sort;

/**
 * Created by Administrator on 2017/2/16.
 * 选择排序：
 *
 * 1, 循环N次
 * 2，A： 初始化minIndex = i;
 *   B:   遍历其后的的数组集合：【求其最小值】
 *             if   逆序就更新minIndex；否则就不变
 *
 *        遍历完成之后进行交换
 *
 *
 *  【注意】
 *
 *  i  指的是minIndex 从0 ~ n-1
 *  j  遍历对象的的起点： j= i+1 , ~ n
 */
public class SelectSort {

    public static int[] selectSort(int[] nums){
        //边界条件判断
        if (nums == null && nums.length ==1){
            return nums;
        }

        for (int i = 0; i < nums.length -1; i++ ){
            int minIndex = i;//遍历前的初始化
            for (int j = i + 1; j < nums.length; j++ ){
                //变量选择赋值采取一句话
                minIndex = ( nums[j] < nums[minIndex])? j : minIndex;
            }
            swap(nums,minIndex,i);
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
        int[] result =  selectSort(nums);
        System.out.println(result);

    }
}
