package leetcode.queue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347: https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 找出数组中出现频率最高的k个元素。
 */
public class TopKFreq {
    public static void main(String[] args) {

    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        assert k >0;

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length ;i ++){
            int times = map.get(nums[i]);
            map.put(nums[i] ,times++);
        }

        //使用优先队列维护topk：一旦出现了更高的频率，就替换最小的
        PriorityQueue<Pair> priorityQueue = new PriorityQueue();


        return null;

    }

    class Pair{
        int freq;
        int num;
    }

}
