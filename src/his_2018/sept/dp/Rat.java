package his_2018.sept.dp;

/**
 * Created by xbog on 2017/9/8.
 *
 * 斐波那契非递归的变形
 */
public class Rat {

    public static void main(String[] args) {
        int res = calcRatNums(2,5);
        System.out.println(res);
    }


    public static int calcRatNums(int year,int initNum){
        int[] whiteRatNums = new int[3];
        int[] blackRatNums = new int[3];
        whiteRatNums[0] = initNum;
        blackRatNums[0] = initNum;
        int res = 0;
        for (int i = 0; i< year ;i++){
            int whiteNum =  whiteRat(whiteRatNums);
            int black =  blackRat(blackRatNums);
            res= Math.abs(whiteNum - black);
        }
        return res;
    }
    public static int whiteRat(int[] latestNum){

        latestNum[2] = latestNum[1];
        latestNum[1] = latestNum[0];
        latestNum[0] = latestNum[2] * 3 + latestNum[1] * 2;

        return latestNum[0] + latestNum[1] + latestNum[2];
    }

    public static int blackRat(int[] latestNum){

        latestNum[1] = latestNum[0];
        latestNum[0] = latestNum[1] * 3;

        return latestNum[0] + latestNum[1];
    }


}