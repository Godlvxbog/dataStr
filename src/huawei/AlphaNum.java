package huawei;

/**
 * Created by Administrator on 2017/3/22.
 */
public class AlphaNum {
    public static void main(String[] args) {
        test();
    }

    public static int getNumOfAlpha(String str, char c){
        if (str == null || str.length() ==0 ){
            return -1;
        }

        int num = 0;
        String str2 = str.toLowerCase();
        for (int i =0 ;i < str.length(); i++){
            if (c == str.charAt(i)){
                num++;
            }
        }
        return num;
    }
    public static void test(){
        String str = "AAADD adfd h123dd hdjd sjdks";
        int num =  getNumOfAlpha(str,'d');
        System.out.println(num);
    }
}
