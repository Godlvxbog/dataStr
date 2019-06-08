package battle_2019.sort;


/**
 * 一句话：插入排序，
 *
 * 思路：稳定的排序，适合比较少量的数据。 O(n2),
 *  * 从循环的起点开始遍历一直遍历到最前面
 *  *
 *  * 从第2个数num【1】开始排序，找之前的数，如果比他temp = nums[i]还要大就往后移动一位
 *
 *  temp是比较的值，待排序的是 0-j
 *  */
public class InsertSort {

    public static int[] insertSort(int[] nums,int left,int right){
        for (int i = left+1; i <= right; i++){
            int temp = nums[i]; //目标值应该是有序的。
            //1、j为i的前面一位
            int j;
            for (j= i-1; j >= left ; j--) {//较大段则后移
                if (nums[j ] > nums[j+1]){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j+1] =temp;//temp放在j的后面的第一个，也就是说0-j的元素是有序的了。

        }
        return nums;
    }


    public static int[] insertSort2(int[] nums,int left,int right){
        for (int i = left+1; i <= right; i++){
            int j = i;
            while (j>0&& nums[j] < nums[j-1]){
                QuickSort.swap(nums,j,j-1);
                j--;
            }

        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {2,1,4,5,3};//新建数组
        int[] result =  insertSort2(nums,0,nums.length-1);
        System.out.println(result);

    }
}
