package leetcode.array;


import java.util.Arrays;

/**
 * //75号：sort colors 计数排序
 * 215：序列中寻找第k大的元素。
 * 88：合并排序数据
 */
public class SortedArray {


    public static void main(String[] args) {
        int[] nums = {
                3,2,3,1,2,4,5,5,6
        };

        int[] nums1  = {1};
        int[]  nums2 = {};
        merge(nums1,1,nums2,0);



//        sortColrs3(nums);
//        int k =5;
//        int res = findKthLargest2(nums,0,nums.length-1,k-1);
        System.out.println(1);
    }


    /**
     * 空间复杂度为O(K)，但是对数组多次进行了扫描。
     * @param nums
     */
    public static void sortColrs(int[] nums){
        int[] count =new int[3];

        for (int i = 0; i < nums.length; i++) {
            //这里一定要考虑数据越界的问题；
            assert nums[i]>=0 && nums[i]<=2;
            count[nums[i]] ++;
        }

        int index =0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j< count[i]; j++){
                nums[index++] =i;
            }
        }
        System.out.println(nums);

    }

    public static void sortColrs2(int[] nums){
        Arrays.sort(nums );
        System.out.println(1);

    }

    /**
     *三路快排：
     */
    public static void sortColrs3(int[] nums){
        int p0 = 0,p2 = nums.length-1;

        for (int i = 0; i <= p2; ) {
            if (nums[i] == 0 ){
                RemoveElement.swap(nums,i,p0);
                p0++;
                i++;
            }else if (nums[i] ==2){
                //这里不用nums[i]还是没有处理的元素，所以不做i++。
                RemoveElement.swap(nums,i,p2);
                p2--;
            }else {
                i++;
            }
        }
        System.out.println(1);

    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        assert k >1 && k <nums.length;
        Arrays.sort(nums);
        System.out.println(nums[nums.length-k]);
        return nums[nums.length-k];
    }

    /**
     * 快排思想
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int left ,int right, int k) {
        assert k >1 && k <nums.length;

        int pivot = partAndSwap(nums,left,right);
        if (k < pivot){
            return findKthLargest2(nums,left,pivot-1,k);
        }else if (k > pivot){
            return findKthLargest2(nums,pivot + 1,right,k);
        }else {
            return nums[pivot];
        }
    }

    public static int partAndSwap(int[] nums,int left, int right){
        int i = left ;
        int j = right;
        int temp = nums[left];
        while (i < j){

            while (i < j  && nums[j] <= temp ){
                 j--;
            }
            RemoveElement.swap(nums,i,j);

            while (i < j  && nums[i] >= temp){
                 i++;
            }
            RemoveElement.swap(nums,i,j);
        }
        return i;
    }

    /**
     * 建立堆排序：尚未完成
     * @param nums
     * @param left
     * @param right
     * @param k
     * @return
     */
    public static int findKthLargest3(int[] nums, int left ,int right, int k) {
        return -1;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums = new int[m+n];
        int k=0;
        int i =0,j = 0;
        for (; i < m &&j < n;){

            if (nums1[i] <= nums2[j]){
                newNums[k++]  = nums1[i++];
            }else {
                newNums[k++] = nums2[j++];
            }
        }

        for (; i < m ; i++){
            newNums[k++]  = nums1[i];
        }
        for (; j < n ; j++){
            newNums[k++]  = nums2[j];
        }

        for (int c= 0;c< newNums.length;c++){
            nums1[c] = newNums[c];
        }
    }



}
