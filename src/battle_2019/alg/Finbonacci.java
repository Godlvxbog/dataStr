package battle_2019.alg;

/**
 *
 * 【剑指Offer ：9】
 *
 *变形题目，这里的初始化时num[] = {1,2}时固定的 ，
 * 计算老鼠，
 * 初始化有 num只老鼠，老鼠第一岁生2只，第二岁生3只，第三年死去。
 * 求year年后一共有多少只老鼠
 *
 *
 * 3、青蛙跳问题
 *  * 青蛙一次可以跳1级阶梯，也可以跳2级阶梯。问n级阶梯有多少种解法。
 *  * 归纳法，递归方法：
 *  * 跳n级时候 f(n) = 1* f(n-2) + 1* f(n-1) :最后两级阶梯，可以采用一步跳两级，也可以采用一步跳一级的方法。
 *  *
 *  * 改编方法：如果跳一级得方法的1分，跳2级得两分。f(n) = 2* f(n-2) + 1* f(n-1)
 */
public class Finbonacci {

    public static void main(String[] args) {
        System.out.println(finbonacci2(4));
        System.out.println(countCat(5,3));
    }

    public static int finbonacci(int num){
        if (num == 1 || num ==2){
            return  num;
        }
        int res = finbonacci(num -1) +finbonacci(num -2);
        return res;
    }

    /**
     * 采用非递归的方式：空间换时间
     */

    public static int finbonacci2(int num){
        int[] middleRes ={1,2};
        if (num ==1 || num  ==2 ){
            return middleRes[num];
        }
        int resTemp =0;
        for (int i =1 ; i<= num-2 ; i++){
            resTemp = middleRes[0] + middleRes[1];
            middleRes[0] = middleRes[1];
            middleRes[1] =  resTemp;
        }
        return middleRes[1];
    }


    public static int  countCat(int initRatnum,int year){
        int[] ratsOfYear = new int[3];
        ratsOfYear[0]= initRatnum;
        for (int i =1 ;i <= year ; i++){
            add(ratsOfYear);
        }
        return ratsOfYear[0] + ratsOfYear[1] + ratsOfYear[2];
    }

    public static int[] add (int[] ratsOfYear){
        ratsOfYear[2] = ratsOfYear[1];
        ratsOfYear[1] = ratsOfYear[0];
        ratsOfYear[0] = ratsOfYear[2] * 3 +ratsOfYear[1] * 2 ;
        return ratsOfYear;
    }


}
