package his_2018.alg.sortMethod;

/**
 * Created by Administrator on 2017/2/25.
 */
public class QuickSort {

    //其中left，right指的是边界
    public static int partitation(int[] nums, int left, int right){
        int i = left,j = right;//初始化两个指针
        int temp = nums[i];//第一个坑
        while (i<j){//退出是i == j

            //分别找坑
            while (i<j && nums[j] >= temp ){//添加一个哨兵：右边第一个数比左边的小，则右边放在左边的
                j--;
            }
            nums[i] = nums[j];

            //往后找
            while (i<j && nums[i] < temp){//添加哨兵：左边第一个数比右边的大，则交换，则左边放在右边的
                i++;
            }
            nums[j] = nums[i];
        }

        nums[i] = temp;
        return i;
    }


    //主程序

    static void quicksort(int[] nums,int left, int right){
        if (left < right){
            int k = partitation(nums,left,right);
            quicksort(nums,left, k-1);
            quicksort(nums,k+1,right);
        }
    }


    public static void main(String[] args) {
        int[] nums = {
                6,3,2,7,5,4,9,1
        };

        quicksort(nums,0,nums.length-1);

        System.out.println(1);

    }




}
