package battle_2019.datastruct.str;

/**
 *  剑指Offer ：40
 *
 *
 * 数组中只出现一次的数字
 * 一个整型数组中，有两个数字只出现了一次，其他都是出现两次。请找出这2个只出现了一次的数字
 * 要求时间复杂度为 O(n),空间为O（1）
 *
 *  2 4 3 6 3 2 5 5
 *
 *
 *  初级：
 *  一个整型数组中，有1个数字只出现了一次，其他都是出现两次。请找出这1个只出现了一次的数字
 *
 *  2 4 3 6 3 2 5 5 6
 *
 *  ~ 求反  ~0 =1，~1001 0101 = 01101010
 *  << 左移
 *  >> 右移
 *  & 位与  0 & 0 = 0；     0 & 1 = 0；     1 & 0 = 0；       1 & 1= 1；
 *  | 位或
 *  ^ 位异或 ：运算规则就是相同为0，不同为1。进行异或运算时，当前位的两个二进制表示不同则为1相同则为0.该方法被广泛推广用来统计一个数的1的位数！
 *  按位异或的3个特点:
 * (1) 0^0=0,0^1=1  0异或任何数＝任何数
 * (2) 1^0=1,1^1=0  1异或任何数－任何数取反
 * (3) 任何数异或自己＝把自己置0
 *
 * 没懂，暂时放下
 *
 *
 */
public class OnceInteger {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,3,4,4,1,23};
        System.out.println(getNumAppearsOnce(nums));
    }

    /**
     * 从头到尾依次异或
     * @param nums
     * @return
     */
    public static int getNumAppearsOnce(int[] nums){

        if(nums == null || nums.length <= 2){
            throw new IllegalArgumentException("nums size must bigger than 2");
        }

        int result = 0;
        for(int i=0;i<nums.length;i++){
            result = result ^ nums[i];
        }

        return result;
    }


}
