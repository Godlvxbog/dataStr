package alg.str.fenziAndState;

/**
 * 移除连续K个0，
 *
 * 移除：  arr[i] =0;
 *
 * 状态量：
 *
 * count=0,start = -1;
 *
 * 分支：
 *
 * 1、如果是0，就累加，非0时候满足条件删除，并重新置状态量；
 * 2、是0，则累加count ++  并且，根据start是厚实是初始化判定这是否是第一个开始的0
 */
public class removeKzeros {

    public static String removeKzeros(String str, int k){
        if (str == null || k <= 0){
            return str;
        }

        char[] arr = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        int start = -1;
        int count = 0;

        for (int i =0; i< arr.length; i++){
            if (arr[i] == '0'){
                count ++;
                start = (start == -1) ? i : start;//不是连续0时置为i,连续态时不变
            }else{
                //删除
                if (count == k){
                    while (count-- >0){
                        arr[start ++] = 0;
                    }
                }

                //重置初始态
                count = 0;
                start = -1;
            }
        }

        //最后一个如果是0，且满足删除条件则需要删除
        if (arr[arr.length - 1] =='0'){
            if (count == k){
                while (count-- >0){
                    arr[start ++] = 0;
                }
            }
        }

        for (int i = 0; i<arr.length;i++){
            if (arr[i] != 0 ){
                sb.append(arr[i]);
            }
        }


        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        String str = "0000A000B000C";
        String res = removeKzeros(str,3);
        System.out.println(res);
    }
}
