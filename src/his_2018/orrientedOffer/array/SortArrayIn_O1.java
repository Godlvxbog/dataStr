package his_2018.orrientedOffer.array;

/**
 * Created by Administrator on 2017/2/26.
 *
 * 对员工进行年龄的排序，要求 O(n);
 * 思路：
 *
 * 循环一次，建立Hash索引表 ： 辅助的空间是O(K),其中的索引是优先的K
 *          Times[age];
 *
 *
 * 再次循环Hash索引：age的范围
 *      循环每个索引的次数：每个age出现的次数；
 *              进行构建的数组
 *
 */
public class SortArrayIn_O1 {
    public static final int OLD_AGE =6;
    //1构建辅助的Hash表： Times[age]


    public static int[] sortArrayIn_O1(int[] arr){
        int length = arr.length;
        int[] times = new int[OLD_AGE];//辅助的Hash表
        int age = 0;
        //统计age各个年龄段的次数

        for (int j = 0; j< length;j++){
            age = arr[j];
            times[age] ++;
        }


        int index = 0;
        //对已经统计的times转换成有序的数组，利用age
        for (int i=0; i< OLD_AGE; i++){
            for (int j = 0; j< times[i]; j++){//对于每个年龄的人数进行办理
                arr[index++] =i;
            }
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] arr ={
                1,2,5,4,3,2,3,4,2,1,3,2,4,2,2,5,4,2,3,4
        };

        int[] res = sortArrayIn_O1(arr);
        System.out.println(arr);

    }
}
