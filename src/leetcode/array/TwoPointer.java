package leetcode.array;

/***
 * 双指针法：
 * 滑动窗口：求最短子数组大于s：209
 *
 * 最长不重复子串：：3 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class TwoPointer {

    public static void main(String[] args) {
        int[] nums = {};
        int s = 100;
//        int res = minSubArrayLen2(s, nums);
//        System.out.println(res);

        String s2 = "abcabcbb";
        char[] chars = s2.toCharArray();
        int[] res = lengthOfLongestSubstring(s2);

        System.out.println(1);


    }


    public static int minSubArrayLen2(int s, int[] nums) {
        int l = 0;
        int r = -1;//定义窗口
        int sum = 0;//定义sum值
        int res = nums.length + 1;//定义长度 ： r-l +1

        //
        while (l < nums.length) {//窗口的起点
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }

            //取最短值,更新
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }
        return res;

    }


    public static int[] lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] subStrIndex = new int[2];

        int[] freq = new int[256]; //记录字符的频率

        int l = 0;
        int r = -1;//记录滑动窗口 s [l,r]
        int res = 0;//最长长度。

        while (l < chars.length) {
            //窗口维护
            if (r + 1 < chars.length && freq[chars[r + 1]] == 0) {//右边元素的下一个没有重复,就拓展右边界
                r++;
                freq[chars[r]]++;
            } else {
                freq[chars[l]]--; //判断当前元素个数频率减一
                l++;
            }

            //取子串的长度

            if (r - l + 1 > res) {
                res = Math.max(res, r - l + 1);
                subStrIndex[0] = l;
                subStrIndex[1] = r;
            }
        }

        return subStrIndex;
    }
}
