package his_2018.sortMethod;

/**
 * 主要思想是：归并思路；
 * 需要你区别于快排的分治算法：
 * 是从下往上的，先归并两个最小的数组，然后依次往上进行归并
 * merge要做的事情是：把两个数组合并成一个数组num[left,mid],nums[mid+1,right]
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums ={
                72,5,57,88,60,42,95,73,58,85
        };
        sort(nums,0,nums.length-1);
        System.out.println("shsdkjs");
    }

    /**
     * 使用归并法，从上往下递归 分，从下往上的治理：合并两个子数组     * @param nums
     * @param left
     * @param right
     */
    public static void sort(int[] nums,int left, int right){
        if (left < right){
            //分
            int mid = (left+right)/2;
            //往下先序地分
            sort(nums,left,mid);
            sort(nums,mid+1,right);
            //治理
            merge(nums,left,mid,right);
        }
    }

    /**
     * 合并两个数组num[left,mid],nums[mid+1,right]
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] nums,int left,int mid,int right){
        int[] temp = new int[nums.length];
        int k = 0;

        int i = left,j = mid+1;
        while (i<= mid && j<= right){
            if (nums[i] < nums[j]){
                temp[k++]  = nums[i++];

            }else{
                temp[k++]  = nums[j++];
            }
        }
        //有剩余的长度的数字,天假到有序数组中
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j<= right){
            temp[k++]  = nums[j++];
        }

        //重新进行赋值
        for (int c = 0;c<k;c++){
            nums[left +c]  = temp[c];
        }

    }


}
