package his_2018.alg.str.rev;

/**
 * 总结：
 * 局部反转的多次运用
 *
 * 反转单词
 *
 * pig loves dogs
 *
 * --》
 * dogs loves pig
 *
 *
 * 补充问题：
 *
 * 12345  3
 * 45123  部分整体移动
 */
public class RevWords {

    public static String revWords(String str1){
        if (str1 == null || str1.length() == 0){
            return null;
        }
        str1 += " ";
        int left = 0,right = 0;
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) == ' ' ){
                str1 = revRange(str1,left,right - 1);
                left = right +1;
            }
            right ++;
        }
        return str1;
    }

    public static String revRange(String str1,int left, int right){
        char[] arr = str1.toCharArray();
        char temp ;
        while (left <right){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return String.valueOf(arr);//静态方法
    }



    public static String revPart(String str, int size){
        if (str == null || str.length() == 0){
            return null;
        }

        str = revRange(str,0,size - 1);
        str = revRange(str,size,str.length() -1);
        str = revRange(str,0,str.length() -1);

        return str;
    }

    public static void main(String[] args) {
        String str1 = "welcome to china , hello world";
        String str2 = revRange(str1,0,str1.length() - 1);
        System.out.println(str2);

        String res =  revWords(str2);
        System.out.println(res);

        System.out.println(revPart(str1,8));
    }
}
