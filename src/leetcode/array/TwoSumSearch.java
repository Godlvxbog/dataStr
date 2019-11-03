package leetcode.array;

//: 167

import battle_2019.searche.BinarySearch;

/**
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumSearch {

    public static void main(String[] args) {
        int[] nums = {5,25,75};
        int[] nums2 = {0,0,3,4};
        int target = 8;
        try{
            int[] res = twoSum2(nums2,target);
            System.out.println(res);
        }catch (Exception e){
            System.out.println("捕获到异常");
        }




    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {

            int num1 = numbers[i];
            int num2 = target - num1;

            int index = BinarySearch.binSearch(numbers,i+1,numbers.length,num2);
            if (index != -1){
                res[0] = i+1;
                res[1] = index+1;
                break;
            }
        }
        return res;

    }

    /**
     * 使用两个指针对撞: O(N)时间复杂度：：对撞指针，实际上partion也是这个思路。
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) throws Exception {
        int[] res = new int[2];
        int l =0;
        int r = numbers.length-1;

        while (l < r){
            if (numbers[l] + numbers[r] == target){
                res[0] = l+1;
                res[1] =r+1;
                return res;
            }else if (numbers[l] + numbers[r] < target){
                l++;
            }else if (numbers[l] + numbers[r] > target){
                r--;
            }
        }
        throw new Exception("no result");
    }
}
