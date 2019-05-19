package his_2018.sortMethod;

/**
 * 交换相邻两个数：
 * 每次比较，可以把最大的数沉到最后面；
 * 注意点：需要注意边界条件；j =1 --n
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums ={
                2,3,1,5,4
        };
        bubbleSort(nums);
        System.out.println("   sdsd");
    }

    public static void bubbleSort(int[] nums){
        int n = nums.length;

        for (int i = 0 ; i< n;i++){
            for(int j = 0;j<n-1;j++){//因为这里是j-1，所以j应该从j=1--n，进行比较
                if (nums[j] > nums[j+1]){

                    swap(nums,j+1,j);
                }
            }
        }

    }

    public static void swap(int[] nums ,int m, int n){
        int temp = nums[m];

        nums[m] = nums[n];
        nums[n] = temp;
    }

}
