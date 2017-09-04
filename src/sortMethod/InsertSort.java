package sortMethod;

/**
 * 思路：分成两部分，有序a[0] a[1--n]是无序的
 *
 * 循环遍历:i = 1 --n；从没有排序的开始
 * 遍历；从 j=i-1,j == 0之间找如果如果有使得顺序  a[j] < temp的时候就，进行吧
 *
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] nums ={
                2,3,1,5,4
        };
        insertSort2(nums);
        System.out.println("   sdsd");
    }

    public static void swap(int[] nums ,int m, int n){
        int temp = nums[m];

        nums[m] = nums[n];
        nums[n] = temp;
    }

    /**
     * 最简洁的插入方法:注意边界条件j>=0;
     * @param nums
     */
    public static void insertSort(int[] nums){
        int n = nums.length;
        for(int i = 1; i< n; i++){
            for (int j=i-1;j>=0 && nums[j] > nums[j+1]; j--){//注意边界，这里是从j = i-1，开始，比较的是a[j]与a[j+1]进行
                swap(nums,j,j+1);
            }
        }
    }


    /**
     * 1,找到合适的位置
     * 2，往后移动
     * 3，把a[i]放在那个地方
     * @param nums
     */
    public static void insertSort2(int[] nums){
        //从没有排序的地方开始找
        for (int i=1;i<nums.length;i++){
            int temp = nums[i];
            int j=0,k=0;
            for (j=i-1;j>=0;j--){
                if (nums[j] < temp){
                    break;//找到了j，是第一个比temp小的数，那么这个数应该插入其后，
                    //移动的也是其后的数值，【i-1，到j+1】
                }
            }
            if (j!=i-1){
                //往后移动,这里不包括j
                for (k = i-1;k>j;k--){
                    nums[k+1] = nums[k];//移动
                }
                nums[k+1] = temp;
            }
        }
    }



}
