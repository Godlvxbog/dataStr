package his_2018.sept.dp;

/**
 * Created by xbog on 2017/9/11.
 *
 * 股票的最大收益收益问题：
 * dp问题一定是从首末节点开始，到当前节点的 一段距离的 解
 * 是一个区间，而不是 个值
 *
 * 双向dp问题
 * 其实也就是 数组中两个 值得差最大，
 */
public class StockMaxProfit {

    public static int maxProfit(int[] price){

        int[] profit1 = new int[price.length];
        int[] profit2 = new int[price.length];

        //找到最大的利润 = price[i] - minPrice
//        找到数组中当前节点与最小值差别最大的 prodit1
        int minPrice = price[0];
        for (int i = 0; i < price.length; i++) {

            //更新最小价格
            if (price[i] < minPrice){
                minPrice = price[i];
            }

            profit1[i] = price[i] - minPrice;
        }


//        找到数组中当前节点与最大值差别最大的 prodit2
        int globalMax = 0;
        int maxPrice = price[price.length -1];
        for (int i = price.length -1; i >= 0; --i) {
            if (price[i] > maxPrice){
                maxPrice = price[i];
            }

            profit2[i] = maxPrice - price[i];
        }

        for (int i = 0; i < profit1.length; i++) {
            int temp = profit1[i] + profit2[i];
            if (temp > globalMax){
                globalMax = temp;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] price = {
                2,-3,4,9,-1,8,-20,-30
        };
        int res = maxProfit(price);
        System.out.println(res);
    }
}
