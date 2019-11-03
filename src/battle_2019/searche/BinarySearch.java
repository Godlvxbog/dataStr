package battle_2019.searche;


//在一个区间中找到target，这里的区间是一个动态的变量，每次都是折半查找
//循环不变量
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {2, 1, 4, 5, 3,9,10,16,41,93,8};//新建数组
        int target= 93;
        int index  = binSearch(nums,0,nums.length-1,target);
        System.out.println(index);

    }

    public static int binSearch(int[] nums,int left ,int right,int target){

        while (left <= right){
            int mid =(left + right)/2;
            if (mid >=nums.length){
                return -1;
            }
            if (target == nums[mid]){
                return mid;
            }else if (target >nums[mid]){
                left = mid+1;
            }else if (target < nums[mid]){
                right = mid-1;
            }
        }

        return -1;

    }

}
