package sortMethod;

/**
 * 选择排序：
 * 从无序中选出最小的排在有序的中，
 * 从无序中找出最小的，插入到有序去，使得成为一个更大的有序区
 */
public class selectSort {



    public static void main(String[] args) {
        int[] nums ={
                2,3,1,5,4
        };
        selectSort(nums);
        System.out.println("   sdsd");
    }

    public static void selectSort(int[] nums){
        for (int i = 0;i<nums.length;i++){
            int nMinIndex = i;//最小值
            for (int j= i+1;j<nums.length;j++){
                if (nums[j] < nums[nMinIndex]){
                    nMinIndex = j;//更新最小值
                }
            }
            swap(nums,i,nMinIndex);//交换获得最小的值

        }
    }

    public static void swap(int[] nums ,int m, int n){
        int temp = nums[m];

        nums[m] = nums[n];
        nums[n] = temp;
    }


}
