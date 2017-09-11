package sept.sort;

/**
 * Created by xbog on 2017/9/11.
 * 快速选择算法：
 * 通过part（快排的思路） 获取第k大的元素
 *
 *
 */
public class QuickSelect {


    public static int quickSelct(int[] nums, int left, int right, int k){

        //越过了边界
        if (left >= right){
            return nums[left];
        }

        int index = QuickSort.partitation(nums,left,right);

//         int size = index - left + 1;//index 在该数组中的脚表
        if (index + 1 == k ){
            return nums[index];
        }else if (index + 1 > k){
            return quickSelct(nums,left,index - 1,k);
        }else {
            return quickSelct(nums,index + 1,right,k);
        }


    }


    public static void main(String[] args) {
        int[] nums = {
                20,50,10,90,70,80,60,30,0
        };

        int k = quickSelct(nums,0,nums.length - 1,3);
        System.out.println(k);
    }




}
