package his_2018.sept.sort;

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
            while (i<j && nums[j] >= temp ){//添加一个哨兵
                j--;
            }
            nums[i] = nums[j];

            //往后找
            while (i<j && nums[i] < temp){//添加哨兵
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
                54,35,48,36,27,12,44,44,8,14,26,17,28
        };

        quicksort(nums,0,13);

    }




}
