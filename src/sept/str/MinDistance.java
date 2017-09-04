package sept.str;

/**
 * Created by xbog on 2017/9/4.
 * 找出两个字符串的最近的位置
 */
public class MinDistance {

    public static int minStance(String strs, String str1, String str2){
        //edge判断

        //使用两个指针去遍历
        int last1 =-1;//记录最近出现str1的指针，默认是没有找到
        int last2 =-1;
        //动态更新min值
        int min = Integer.MAX_VALUE;
        //遍历 使用分支
        for (int i = 0; i < strs.length(); i++) {
            //找到了第一个
            if (strs.charAt(i) == str1.charAt(0)){
                //需要更新min和last
                last1 = i;
                if (last2 != -1 && Math.abs(last2 -last1)  < min){
                    min = Math.abs(last2 -last1);
                }
            }

            //找到了第一个
            if (last1 != -1 && strs.charAt(i) == str2.charAt(0)){
                //需要更新min和last
                last2 = i;
                if (Math.abs(last2 -last1)  < min){
                    min = Math.abs(last2 -last1);
                }
            }
        }

        return min;

    }


    //===========================

    public class MyNode{
        int last1 = -1;//第一个最近出现的索引
        int last2 = -1;
        int min = Integer.MAX_VALUE;

        public int getMin(int last1,int last2){
            if (Math.abs(last2-last1)  <min){
                min = Math.abs(last2 -last1);
            }
            return min;
        }
    }

    public int minStance2(String strs, String str1, String str2){
        MyNode myNode = new MyNode();

        for (int i = 0; i < strs.length(); i++) {
            //找到了第一个
            if (strs.charAt(i) ==  str1.charAt(0)){
                //需要更新min和last
                myNode.last1 = i;
                if (myNode.last2 != -1){
                    myNode.getMin(myNode.last1,myNode.last2);
                }
            }

            if (strs.charAt(i) ==  str2.charAt(0)){
                //需要更新min和last
                myNode.last2 = i;
                //只有另外一个数不是在起始位置是否才开始做最小值的更新
                if (myNode.last1 != -1){
                    myNode.getMin(myNode.last1,myNode.last2);
                }
            }


        }
        return myNode.min;


    }

    public static void main(String[] args) {
        String strs = "0100023323312";
        String str1 = "1";
        String str2 = "2";
        int min = new MinDistance().minStance2(strs,str1,str2);
        System.out.println(min);
    }
}
