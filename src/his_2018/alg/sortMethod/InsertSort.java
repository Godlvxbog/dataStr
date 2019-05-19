package his_2018.alg.sortMethod;

/**
 * Created by Administrator on 2017/2/16.
 *
 * 思路：
 * 从循环的起点开始遍历一直遍历到最前面
 *
 * 如果是逆序就交换:temp = nums[i] < nums[j] 则作为k的位置进行插入
 */
public class InsertSort {

    public static int[] insertSort(int[] nums, int n){
        for (int i = 1; i < n; i++){
            int temp = nums[i];
            int j = i;
            for (; j > 0 ; j--) {//较大段则后移
                if (nums[j -1] > temp){
                    nums[j] = nums[j - 1];
                }else{
                    break;
                }
            }
            nums[j] =temp;

        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {2,1,4,5,3};//新建数组
        int[] result =  insertSort(nums,5);
        System.out.println(result);

    }




}
