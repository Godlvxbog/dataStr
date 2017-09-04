package sortMethod;

/**
 * 快排思路：
 * 两部分：先分后治理，+ part
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums ={
                72,5,57,88,60,42,95,73,58,85
        };
        quickSort(nums);
        System.out.println("adaskjlda");
    }

    public static void quickSort(int[] nums){
        sort(nums,0,nums.length-1);
    }

    //从上往下的治理
    public static void sort(int[] nums,int left,int right){
        if (left < right){
            int point = part(nums,left,right);

            sort(nums,left,point-1);
            sort(nums,point+1,right);
        }

    }

    public static int part(int[] nums,int left,int right){
        int i=left,j=right;
        int temp = nums[left];

        while (i<j){
            //一趟要做的事情
            while (i<j && nums[j] > temp){
                j--;
            }
            if (i<j){
                nums[i] = nums[j];///进行覆盖,坑分别是num[i || j]
                i++;
            }

            while (i<j && nums[i] < temp){//用哨兵，找到第一是逆序的数字
                i++;
            }
            if (i<j){
                nums[j] = nums[i];///进行覆盖
                j--;
            }

        }
        //当一个循环结束也就是nums[i==j]时候
        nums[i] = temp;
        return i;//作为分界点

    }

}
