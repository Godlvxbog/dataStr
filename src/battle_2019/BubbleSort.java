package battle_2019;

/**
 * 待排序的数字在i的后面，i--temp，上浮冒泡排序，从后面往前面排序
 */
public class BubbleSort {
    public static void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;//交换
    }


    public static void main(String[] args) {

        int[] nums = {2,1,4,5,3};//新建数组
        bubbleSort(nums);
        System.out.println(1);

    }

    public static void bubbleSort(int[] nums){
        for (int i= 0;i < nums.length;i++){
            for (int j= nums.length-1;j>i;j--){
                if (nums[j]< nums[j-1]){//后面的比前面还要大，就交换
                    swap(nums,i,j);
                }
            }
        }
    }
}
