package his_2018.orrientedOffer.tree;

/**
 * Created by Administrator on 2017/2/27.:
 *
 * 判断是否是BST的后序遍历的序列
 *
 */
public class IsPostSerial {

    public static void main(String[] args) {
        int[] arr ={
                5,7,6,9,11,10,8
        };

        boolean isPost = isPostSerial(arr,0,arr.length -1);
        System.out.println(isPost);

    }

    public static boolean isPostSerial(int[] arr,int start, int end){

        if (arr == null || end - start <= 0){
            return false;
        }



        //先序：递归
        int nlast = arr[end - 1];//最后一个
        int index = 0;
        for (int i = 0; i < end -1; i++){
            if (arr[i] > nlast){
                index = i;

                break;
            }
        }

        //右边:如果出现小于的数也就不满足了

        for(int j = index; j< end -1; j++){
            if (arr[j] < nlast){
                return false;
            }
        }


        boolean left = true;
        if (index >0){//十分关键；有条件的遍历：递归
            left =  isPostSerial(arr,start,start+index);
        }

        boolean right = true;
        if (index < end - 1){
            right = isPostSerial(arr,start + index+1 ,end);

        }

        boolean res = left && right;
        return res;

    }




}
