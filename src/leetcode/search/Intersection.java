package leetcode.search;


import java.util.*;

/**
 * 349::https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * 350::https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * 未完成：：： 如果这里的数字是有序的呢，？？请不用查找表来获取结果。
 *
 */
public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] res = intersection2(nums1,nums2);
        System.out.println(1);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        //将nums1转化为set集合元素
        Set<Integer> set1 = new HashSet();

        Set<Integer> record = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            boolean exist = set1.contains(nums2[i]);
            if (exist){
                record.add(nums2[i]);
            }
        }

        int[] res = new int[record.size()];
        int k=0;
        for (int m: record){
            res[k++] = m;
        }
        return res;

    }

    public static int[] intersection2(int[] nums1, int[] nums2){

        //初始化查找表
        Map<Integer,Integer> record = new HashMap();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            Integer count = record.get(nums1[i]);
            if (count == null){
                count =1;
                record.put(nums1[i],count);//初始化
            }else {
                count++;
                record.put(nums1[i],count);
            }
        }

        for (int j = 0; j< nums2.length;j++){
            Integer count =  record.get(nums2[j]);
            if (count != null && count != 0 ){
                list.add(nums2[j]);
                //维护record
                record.put(nums2[j],--count);
            }
        }

        //转换结果
        int[] res = new int[list.size()];
        int k=0;
        for (Integer num : list){
            res[k++] = num;
        }

        return res;
    }



}
