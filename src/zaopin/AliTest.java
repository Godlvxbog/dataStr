package zaopin;

/**
 * Created by Administrator on 2017/3/3.
 */
public class AliTest {


//

    public static boolean siFen(int[] A){
        if(A.length<7) {
            return false;
        }
        int i=0,j=A.length-1;
        int temp=0,sum1=0,sum2=0;
        sum1+=A[i];
        sum2+=A[j];
        while(i<j){
            if(sum1<sum2){
                i+=1;
                sum1+=A[i];
            }else if(sum1>sum2){
                j-=1;
                sum2+=A[j];
            }else{
                if(j-i>2){
                    temp=sum2;
                    sum1=sum2=0;
                }else if(j-i==2){
                    if(sum1==sum2){
                        return true;
                    }
                }
                i+=2;//跳过作为分割的数
                j-=2;
                sum1+=A[i];//重新开始
                sum2+=A[j];
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[] array = {
                2,5,1,1,1,1,4,3,7,5,7
        };


        boolean sifen =  siFen(array);
        System.out.println(sifen);



    }
}
