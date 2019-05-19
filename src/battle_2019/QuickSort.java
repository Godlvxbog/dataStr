package battle_2019;


/**
 * 快排的思路：
 * 1、找出分解单
 * 2、最左右两个分别使用分而治之的思路
 * temp =num[i] ,作为分界点，首先要找出这个分界点，吧temp挡在数组的合适的位置
 * temp一定满足，左边的数一定比temp小，右边的一定比temp大，
 * 因此需要做的事情是：
 *      j往左边移动，遇到第一个比temp小的数字，就填到原来j的坑位上
 *      i往右边移动，遇到第一个比temp大的数字，就填到原来j的坑位上
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] nums = {
                54,35,48,36,27,12,44,44,8,14,26,17,28
        };

        quickSort(nums,0,nums.length-1);
        System.out.println(1);

    }

    public static int part(int[] nums, int i ,int j){
        int temp = nums[i] ;
        while (i < j){
            //j往左边移动，遇到第一个比temp小的数字，就填到原来j的坑位上
            while (i < j && nums[j] >= temp ){
                j--;
            }
            nums[i] = nums[j];

            while (i < j && nums[i] < temp ){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = temp;
        return i;
    }

    public static void quickSort(int[] nums,int i, int j){
        if (i < j){ //时候还需要做找出探针 + 分左右排序了。
            int pivot = part(nums,i,j);
            quickSort(nums,i,pivot-1);
            quickSort(nums,pivot+1,j);

        }

    }
}
