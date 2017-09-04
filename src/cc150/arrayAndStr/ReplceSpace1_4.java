package arrayAndStr;

/**
 * 将子妇产中空格全部替换成%20:要求用数组：
 * 基本原理：
 *
 * 把一个字符串内容复制到另外一个  新建的字符串中去
 * 新建的字符串需要知道其长度，并从后往前操作
 *
 * 步骤：
 * 1求出字符串中空格的个数，
 * 2，从尾部遍历元字符串，如果是空格就复制0,2，%给新的字符串， 如果是字符就把原字符复制到新的字符串中
 */
public class ReplceSpace1_4 {
    public static void main(String[] args) {
        String str1="Program file of my computer!";
        System.out.println( replace(str1));
    }

    public static String replace(String s){
        //按照题目要求转换成数组；
        char[] content = s.toCharArray();
        int length =s.length();

        int spaceCount=0,newLength;
        for (int i=0;i<length;i++){
            if (content[i] ==' ' ){
                spaceCount++;
            }
        }
        newLength=length+spaceCount*2;//一个空格换成了 % 2 0 净增加了2个字符

        char[] newContent=new char[newLength+10];
        newContent[newLength]='\0';

        //从后往前操作
        for (int i=length-1;i>=0;i--){
//            遍历原字符串中字符，如果是空格就复制0,2，% ； 如果是字符，就复制原字符
            if (content[i] == ' '){
                newContent[newLength-1]='0';
                newContent[newLength-2]='2';
                newContent[newLength-3]='%';
                newLength-=3;//循环变量需要更新
            }else{
                newContent[newLength-1]=content[i];
                newLength-=1;
            }
        }

        return new String(newContent);
    }

    public static String replace2(String str2){
        //str.replace(char,char)不能更新一个字符串
        return null;
    }

}
