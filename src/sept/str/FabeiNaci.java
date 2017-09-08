package sept.str;

/**
 * Created by xbog on 2017/9/8.
 */
public class FabeiNaci {
    public static int feibonacci(int m){
        int[] nums = new int[2];
        nums[0] = 1;
        nums[1] = 2;
        if (m == 1){
            return nums[0];
        }

        if (m == 2){
            return nums[1];
        }

        int[] res = new int[2];
        for (int i = 0; i < m-2; i++) {
            res = add(nums);
        }
        return res[1];
    }

    /**
     * 交换相关的
     * @param nums
     * @return
     */
    public static int[] add(int[] nums){
        int temp = nums[0];
        nums[0] = nums[1];

        nums[1] = nums[0] +temp;
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(feibonacci(4));
    }
}
