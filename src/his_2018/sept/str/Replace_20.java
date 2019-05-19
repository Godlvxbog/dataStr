package his_2018.sept.str;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xbog on 2017/9/3.
 */
public class Replace_20 {

    public static Queue myReplace(String str){
        //edge
        //遍历
        Queue queue =new LinkedList();
        for (int i= 0;i<str.length();i++){
            while (i< str.length() && str.charAt(i) != ' ' ){
                queue.add(str.charAt(i));
                i++;
            }
            if (i< str.length()){
                queue.add("%20");

            }
        }
        return queue;
    }

    public static void main(String[] args) {
        String str = "I have a pen in my country";
        Queue queue = myReplace(str);
        System.out.println((String)queue.toString());
    }
}
