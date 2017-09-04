package huawei;

import java.util.*;

/**
 * Created by Administrator on 2017/3/17.
 */
public class Main {
    public static void main(String[] args) {
        test1();

        

    }


    public static void test1(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int taxis = scanner.nextInt();
            int[] xs= new int[taxis];
            int[] ys = new int[taxis];
            for (int i = 0; i< taxis; i++){
                xs[i] = scanner.nextInt();
            }

            for (int i = 0; i< taxis; i++){
                ys[i] = scanner.nextInt();
            }

            int[] end = new int[2];
            end[0] = scanner.nextInt();
            end[1] = scanner.nextInt();

            int[] speed = new int[2];
            speed[0] =scanner.nextInt();
            speed[1] = scanner.nextInt();

            int[] minPoint = new int[2];
            int mindis = Integer.MAX_VALUE;
            for (int i = 0; i< taxis;i++){
                if (Math.abs(xs[i])  + Math.abs(ys[i]) < mindis){
                    mindis = Math.abs( xs[i]) + Math.abs( ys[i]);
                    minPoint[0] = xs[i];
                    minPoint[1] = ys[i];
                }
            }

            int t1 =mindis * speed[0] + Math.abs (end[0] - minPoint[0]) + Math.abs(end[1]-minPoint[1]) *speed[1];
            int t2 =Math.abs(  (end[0]+end[1]) *speed[0]);
            int res  = Math.min(t1,t2);
            System.out.println(res);
        }
    }



    public static void sazi(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();

            String str2  = scanner.nextLine();
            for (int i = 0;i<str2.length();i++){
                if (str2.charAt(i) == 'R'){
                    swapR(chars);
                }
                if (str2.charAt(i) == 'A'){
                    swapA(chars);
                }
            }

            System.out.println(chars.toString());




        }

    }

    public static String swapR(char[] chars){
        StringBuffer sb = new StringBuffer();
        sb.append(chars[chars[5]]);
        sb.append(chars[chars[4]]);
        sb.append(chars[chars[2]]);
        sb.append(chars[chars[3]]);
        sb.append(chars[chars[0]]);
        sb.append(chars[chars[1]]);
        return sb.toString();

    }


    public static String swapA(char[] chars) {
        StringBuffer sb = new StringBuffer();
        sb.append(chars[chars[3]]);
        sb.append(chars[chars[2]]);
        sb.append(chars[chars[0]]);
        sb.append(chars[chars[1]]);
        sb.append(chars[chars[0]]);
        sb.append(chars[chars[1]]);
        return sb.toString();
    }


    public static void revAdd() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String[] strs = str1.split(",");

            int num1 = Integer.parseInt(strs[0]);
            int num2 = Integer.parseInt(strs[1]);

            if ((num1 >70000 || num1 <1) ||(num2 >70000 || num2 <1) ){
                System.out.println(-1);
                return;
            }

            int newNum1 = revNUm(num1);
            int newNum2 = revNUm(num2);




            System.out.println(newNum1 + newNum2);


        }
    }

    public static int revNUm(int num){
        StringBuffer sb =new StringBuffer();

        while (num >0){
            int bit =  num%10;
//            if (bit != 0){
                sb.append(bit);

//            }
            num /= 10;

        }
//        System.out.println(Integer.parseInt(sb.toString()));
        return Integer.parseInt(sb.toString());

    }




    /**
     * 在数字前后添加*
     *
     * 思路一：
     * 用两个指针：确定是一个数字的串
     *
     * 思路二：
     * 用队列或者list保存一个，
     *
     */
    public static void addNUm(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();



            for (int i = 0; i< str.length();i++){

                if ((str.charAt(i) -'0')<=9 && (str.charAt(i) -'0') >= 0){//如果是数字
                    StringBuffer sb =new StringBuffer();
                    sb.append('*');
                    int j = i;
                    while (j<str.length() && str.charAt(j)-'0' <= 9 && str.charAt(j)-'0' >= 0){
                        sb.append(str.charAt(j));
                        j++;
                    }
                    sb.append('*');
                    System.out.print(sb.toString());
                    i = j-1;

                }else {
                    System.out.print(str.charAt(i));

                }
            }
            System.out.println();
        }
    }



    public static void delminTimes(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int[] times =new int[26];
            Arrays.fill(times,0,times.length-1,0);

            for (int i = 0; i< str.length();i++){
                times[str.charAt(i) - 'a'] ++;//记录次数

            }
            int min =times[str.charAt(0)-'a'];

            for (int i = 0; i< str.length();i++){
                if (times[str.charAt(i)-'a'] <= min){
                    min = times[str.charAt(i)-'a'];//更新min的最小的次数
                }
            }

            for (int i =0; i<str.length();i++){
                if (times[str.charAt(i)-'a'] > min){
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();

        }
    }

    /**
     * 使用数据结构HashSet
     */
    public static void countASCII(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            HashSet set = new HashSet();//去重
            for (int i = 0; i< str.length();i++){
                set.add(str.charAt(i));
            }

            System.out.println(set.size());

        }

    }

    public static void countAlpha(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int count = 0;
            for(int i = 0;i<str.length();i++){
                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    count++;
                }

            }

            System.out.println(count);

        }
    }


    public static void testrevstr(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            StringBuffer sb =new StringBuffer(str);
            sb.reverse();
            System.out.println(sb);

        }
    }

    public static void testzhen(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n= scanner.nextInt();
            int count = 0;

            for (int i=1; i<=n;i++){

                int sum = 0;//对于每个进行操作是：求真因子并求和，然后判断
                for (int j = 1; j< i;j++){//求真因子
                    if (i % j ==0){
                        sum += j;
                    }
                }

                if (i == sum){
                    count++;
                }

            }

            System.out.println(count);
        }

        scanner.close();

    }


    public static void testrevnum(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            StringBuffer sb = new StringBuffer(str);
            sb.reverse();
            System.out.println(sb);
        }

    }

    public static void testround(){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            double num = scanner.nextDouble();
            System.out.println(Math.round(num));

        }
    }





    public static void testrev(){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (scanner.hasNext()){
            input = scanner.nextLine();
            for (int i = input.length()-1;i>=0;i--){
                System.out.print(input.charAt(i));
            }
        }
    }

    public static void testSplit8Char(){
        String[] strs = new String[2];
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while (scanner.hasNext()){
            strs[index++] = scanner.nextLine();
            if (index == 2){
                break;
            }
        }

        for (int i = 0; i< strs.length; i++){
            int length = strs[i].length();//获取长度；
            int shang = length/8;
            int yushu = length % 8;
            int j ;
            //在字符串的尾部直接添0；
            if (yushu !=0){
                for (int m = 0;m< 8-yushu;m++){
                    strs[i] +=0;
                }
            }

            for (j = 0; j< strs[i].length() ;j++){

                System.out.print(strs[i].charAt(j));
                if (j!=0 && j % 8==0){
                    System.out.println();
                }


            }



        }


    }

    public static void testScanner2(){
        //一下其实是预备工作
        String all = "";
        String one = "";


        int num = 0;

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            all = scanner.nextLine();//把扫描器的数据的第一行存到all的字符串中
            one = scanner.nextLine();

            all = all.toLowerCase();
            one = one.toLowerCase();
            for (int i = 0; i< all.length() ; i++){
                if(one.charAt(0) == all.charAt(i)){
                    num++;
                }
            }
            System.out.println(num);

        }


    }






    public static void testScanner(){
        String all = "";
        String one = "";
        char[] ac;

        int num = 0;

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            all = scanner.nextLine();//把扫描器的数据的第一行存到all的字符串中
            one = scanner.nextLine();
            ac = all.toCharArray();//得到字符数组

            for (int i = 0; i< ac.length ; i++){
                if (one.equalsIgnoreCase(String.valueOf(ac[i]))){
                    num++;
                }
            }
            System.out.println(num);

        }


    }





    public static void testChar(){
        char c = 97;
        System.out.println(c);
    }

    public static void testString(){
        String str = "abcdefadsfhjkdfghjefijkl";
        for (int i = 0; i< str.length();i++){
            char a =  str.charAt(i);
            char next = str.charAt(i+1);
        }
    }



    public static void testArrays(){
        int[] array = {
                4,2,3,1,5
        };
        Arrays.fill(array,2,3,5);

        Arrays.sort(array,0,array.length-1);

        System.out.println(array);
    }




    public static void testAdjust(){


        int[] nums ={
                1,2,35,6,8,10,44,5,2,7
        };
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        for (int i = 0 ; i< nums.length; i++){
            if (nums[i] % 2 == 1){
                left.add(nums[i]);
            }else{
                right.add(nums[i]);
            }
        }
        left.addAll(right);

    }



    public static void testMap(){
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        int n = 10;
        while (n-- >0){
            map.put(String.valueOf(n),n*10);
        }

        for (String key : map.keySet()){
            System.out.println(map.get(key));
        }
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            String key = entry.getKey();
            System.out.println(map.get(key));
        }


    }


    public static void testArrayList(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n = 10;
        while (n-- >0){
            arrayList.add(n);
        }

        arrayList.add(null);
        System.out.println(arrayList.get(5));
        System.out.println(arrayList.indexOf(3));
        arrayList.clear();
        System.out.println(arrayList.size());

    }


    public static void testarray(){
        int[] array = {
                1,4,6,7,9,20,3,
        };


        System.out.println(array.length);

        for (int i = 0; i< array.length;i++){
            System.out.println(array[i]);
        }
    }


}
