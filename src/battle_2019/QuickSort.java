package battle_2019;


import java.util.Random;

/**
 *
 * 参考：https://www.cnblogs.com/noKing/archive/2017/11/29/7922397.html
 * 优化点：
 * 1、问题：每趟排序后，左右两个子递归规模相差悬殊，大的那部分最后很可能会达到O(n^2)
 *    解决：  因此采用随机数为基准值
 * 2、问题：swap需要用一个空间
 *    解决：不用空间，直接赋值
 * 3、问题：快排是通过不断缩小规模解决问题，需要不断递归，当递归的规模比较小时，采用不稳定+递归，则效率比较低了。
 *    解决：近乎有序时，插入排序表现比较好，因此使用插入排序。
 *
 *
 * 2、快速排序的三个步骤：
 * 1、选取基准：
 *          基准，右边的只要比基准小，就交换
 *          基准，左边的只要比基准大，就交换
 *
 * 2、用基准分割成两个子序列
 * 3、如果i<j,递归。直到序列为空或者只有一个元素。
 *====================================================
 * 快排的思路：
 * 1、找出分解单
 * 2、最左右两个分别使用分而治之的思路
 * temp =num[i] ,作为分界点，首先要找出这个分界点，吧temp挡在数组的合适的位置
 * temp一定满足，左边的数一定比temp小，右边的一定比temp大，
 * 因此需要做的事情是：
 *      j往左边移动，遇到第一个比temp小的数字，就交换
 *      i往右边移动，遇到第一个比temp大的数字，就交换
 *
 *====================================================
 * 快排的时间复杂度：不稳定的 最差就是n2,最好nlgn
 * 空间复杂度O（n），
 *
 * ====================================================
 * 快排的优化：(1)
 * *缺点：在近乎有序的数组下，该快排比归并要慢很多
 * *因为每次排序后，左右两个子递归规模相差悬殊，构成的二叉树平衡因子没有归并好，完全有序情况下就是n2，
 *
 * 1、每次part时，先随机找出一个数，并与int[i]进行交换,那么基准值就是用这个随机的值了。
 *
 * ====================================================
 * 快排的优化：(2)
 * 优化掉swap：空间

 *
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] nums = {
                54,35,48,36,27,12,44,44,8,14,26,17,28
        };

        quickSort2(nums,0,nums.length-1,3);
        System.out.println(nums.toString());

    }

    public static int part(int[] nums, int i ,int j){
        //1、取基准值为数列的第一个。
        int privotValue = nums[i];
        while (i < j){
            //j往左边移动，遇到第一个比temp小的数字，就填到原来j的坑位上
            while (i < j && nums[j] >= privotValue ){
                j--;
            }
            swap(nums,i,j);

            while (i < j && nums[i] < privotValue ){
                i++;
            }
            swap(nums,i,j);
        }
        return i;
    }

    /**
     * 随机取一个数
     * @param nums
     * @param i
     * @param j
     * @return
     */
    public static int part2(int[] nums, int i ,int j){
        //1、随机取基准值
        int randIndex = new Random().nextInt(j-i+1) + i;//获取随机的位置
        swap(nums,i,randIndex);//开始位置与随机位置交换，那么后面的 基准值就是取得随机的值了。
        int privotValue = nums[i] ; //基准值。

        while (i < j){
            //j往左边移动，遇到第一个比temp小的数字，就填到原来j的坑位上
            while (i < j && nums[j] >= privotValue ){
                j--;
            }
            swap(nums,i,j);

            while (i < j && nums[i] < privotValue ){
                i++;
            }
            swap(nums,i,j);
        }
        return i;
    }


    /**
     * 优化temp空间
     * @param nums
     * @param i
     * @param j
     * @return
     */
    public static int part3(int[] nums, int i ,int j){
        //1、随机取基准值
        int randIndex = new Random().nextInt(j-i+1) + i;//获取随机的位置
        swap(nums,i,randIndex);//开始位置与随机位置交换，那么后面的 基准值就是取得随机的值了。
        int privotValue = nums[i] ; //基准值。

        while (i < j){
            //j往左边移动，遇到第一个比temp小的数字，就填到原来j的坑位上
            while (i < j && nums[j] >= privotValue ){
                j--;
            }
            nums[i] = nums[j];

            while (i < j && nums[i] < privotValue ){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = privotValue;
        return i;
    }

    public static void swap(int[] nums ,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void quickSort(int[] nums,int i, int j){
        if (i < j){ //时候还需要做找出探针 + 分左右排序了。递归的进入的条件
            int pivot = part3(nums,i,j);
            quickSort(nums,i,pivot-1);
            quickSort(nums,pivot+1,j);

        }

    }


    /**
     * 当规模比较小时使用插入排序
     * @param nums
     * @param i
     * @param j
     */
    public static void quickSort2(int[] nums,int i, int j,int k){

        if (j-i <=k){
            InsertSort.insertSort(nums,i,j);
            return;
        }


        //快排
        if (i < j){ //时候还需要做找出探针 + 分左右排序了。递归的进入的条件
            int pivot = part3(nums,i,j);
            quickSort2(nums,i,pivot-1,k);
            quickSort2(nums,pivot+1,j,k);

        }

    }


    //

}
