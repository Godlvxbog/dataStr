package battle_2019.datastruct.str;

/**
 *
 *  剑指Offer ：14
 *
 * 给出一个数列，要求奇数都在偶数的前面
 *
 * 1、两个数组，分别存
 * 2、使用两个指针方法，类似于快排的
 */

public class JishuFrontBehind {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 4, 6, 2, 2, 5, 19 };

        int[] res = change(arr);
        System.out.println(res);
    }

    public static int[]  swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp;
        return  arr;
    }

    public static  int[] change(int[] arr){
        int i = 0;int j= arr.length-1;

        while (i < j){
            while (arr[i] % 2 ==1 && i<j){
                i++;
            }
            while (arr[j] % 2 == 0 && i<j){
                j--;
            }
            swap(arr,i,j);

        }
        return arr;
    }

}
