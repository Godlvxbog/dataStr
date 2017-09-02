package alg.sortMethod;

/**
 * Created by Administrator on 2017/2/25.
 */
public class MergeSort {

    public static void mergeSort(int[] a,int first,int last,int[] temp){
        int mid = 0;
        if (first < last){
            mid = first + (last - first)/2 ;
            mergeSort(a,first,mid,temp);
            mergeSort(a,mid +1 ,last,temp);
            mergeArray(a,first,mid,last,temp);

        }


    }

    //合并两个已经有序的数组[fist,mid ]  [mid + 1, last]
    public static void mergeArray(int[] a,int first, int mid, int last, int[] temp){
        //1设置两个指针,得到两个数组
        int i = first,m = mid;
        int j = mid + 1, n = last;
        int k=0;

        //2合并到临时数组
        while (i <= m && j <= n){
            if (a[i] < a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }

        while (i<= m){
            temp[k++] = a[i++];
        }
        while (j<=n){
            temp[k++]= a[j++];
        }

        //3返回到a数组

        for (int c = 0; c < k; c++){
            a[first +c] = temp[c];
        }


    }



    public static void main(String[] args) {
        int[] nums = {
                54,35,48,36,27,12,44,44,8,14,26,17,28
        };
        int[] temp = new int[13];
        mergeSort(nums,0,12,temp);
        System.out.println("hello");


    }
}
