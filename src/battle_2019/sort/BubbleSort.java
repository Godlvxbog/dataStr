package battle_2019.sort;

/**
 * 待排序的数字在i的后面，i--temp，上浮冒泡排序，从后面往前面排序
 * 关于稳定排序，一定要区分，哪些是已经排序的，哪些是即将要排序的
 */
public class BubbleSort {
    public static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;//交换
    }


    public static void main(String[] args) {

        int[] nums = {2, 1, 4, 5, 3};//新建数组
        selectSort(nums);
        System.out.println(1);

    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j + 1] < nums[j]) {//后面的比前面还要大，就交换
                    swap(nums, j , j+1);
                }
            }
        }
    }


    public static void selectSort(int[] nums){
        for (int i=0; i< nums.length ;i++){
            int minIndex =i;//设定初始化的最小值为 i的左边都是有序的，右边都是无序的。
            for (int j = i; j < nums.length; j++){
                if (nums[minIndex] > nums[j]){
                    minIndex = j;//更新最小值
                }
            }
            swap(nums,i,minIndex);
        }
    }
}
