package battle_2019.datastruct.str;

/**
 * 剑指offer 41:在有序数组中找出两个数 =s的树
 */
public class SumEquNum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 14, 26,39 };
        findSumEqualsK(arr,40);
        System.out.println(1);
    }

    public static void findSumEqualsK (int[] arr, int num){
        int i= 0;
        int j= arr.length-1;

        while (i < j){
            int curSum =arr[i] + arr[j];
            if (num == curSum){
                System.out.println(arr[i]);
                System.out.println(arr[j]);
                break;
            }else if(curSum < num){
                i++;
            }else {
                j--;
            }
        }
    }
}
