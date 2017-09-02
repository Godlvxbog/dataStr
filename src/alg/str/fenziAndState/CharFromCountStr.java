package alg.str.fenziAndState;

/**
 * 本题和CountStr是逆序计算；
 *
 * 思路：
 */
public class CharFromCountStr {

    public static char charFromCountStr(String str,int index){
        if (str == null || str.length() == 0){
            return 0;//char用数字返回
        }

        char[] arr = str.toCharArray();
        boolean countinous = false;
        int sum = 0;
        int num = 0;
        char cur = 0;//临时字符

        for (int i = 0; i< arr.length; i++){
            //是分割号
            if (arr[i] == '_'){
                countinous = !countinous;//反转
            }else if (!countinous){//不连续时候需要累加总长度，重置新的临时字符，次数为0，
                sum += num;

                if (sum > index){
                    return cur;
                }

                num = 0;
                cur = arr[i];
            }else{//连续，需要统计次数
                num = num * 10 + arr[i] - '0';//转换成次数
            }
        }

        return (sum + num > index) ? cur : 0;

    }
    public static void main(String[] args) {
        String str = "a_34_b_20_c_4";
        char res = charFromCountStr(str,56);
        System.out.println(res);
    }
}
