package his_2018.sept.dp;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by xbog on 2017/9/11.
 *
 * 最长的递增子序列的长度
 *
 */
public class LongestSubSeq {

    public static int longestIncrSubSeq(int[] arrr){
        int[] res = new int[arrr.length+ 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }

        //核心代码
        for (int i = 0; i < arrr.length; i++) {
            for (int j = 0; j < i; j++) {

                if (arrr[i] > arrr[j] && res[j] + 1 >res[i]){
                    res[i] = res[j] + 1;
                }
            }
        }

        int maxRes = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > maxRes){
                maxRes = res[i];
            }
        }

        return maxRes;
    }

    /**
     * 求  最长的连续递增序列
     * @param arrr
     * @return
     */
    public static int longestConsecutiveIncrSubSeq(int[] arrr){
        int[] res = new int[arrr.length+ 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }

        //核心代码
        for (int i = 1; i < arrr.length; i++) {
            for (int j = 1 ; j <= i; j++) {
                if (arrr[j] > arrr[j-1]){
                    res[i] ++;
                }else {
                    res[i] = 1;
                }

            }
        }

        int maxRes = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > maxRes){
                maxRes = res[i];
            }
        }

        return maxRes;
    }



    public static void main(String[] args) {
        int[] arr = {
                1,3,2,4,6,9,5

        };

        int maxRes = longestConsecutiveIncrSubSeq(arr);
        System.out.println(maxRes);

    }
}
