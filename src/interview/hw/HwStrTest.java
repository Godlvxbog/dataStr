package interview.hw;

import java.util.*;

public class HwStrTest {

    public static void main(String[] args) {
        String str = "hello hw !";
        try {
            String res = reverse("");
            System.out.println(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //lastWordLength ;


        String str2 = "   ";
        int res = lastWordLength(str2);
        System.out.println(res);


        //charsOf
        int res3 = charsCount("fasfafsaw2327191dfafjlAADD", 'a');
        System.out.println(res3);


        //randomIntegers
        List<Integer> list = new ArrayList<>();
        list.add(991);
        list.add(11);
        list.add(13);
        list.add(12);
        list.add(11);
        List<Integer> res4 = randomIntegers(list);
        System.out.println(res4);


        //splitStrs
        List<String> singleStrs = splitSingleStr("fasfafsaw2327191dfafjlAADD112");
        System.out.println(singleStrs);

        //bitChangeFrom16
        System.out.println(bitChangeFrom16("0x11"));

        //drinkCount
        int res5 = drinkCount(81);
        System.out.println(res5);


        //aboutNum

        int res6= aboutNum("5.5");
        System.out.println(res6);

//        subNum

        int res7 = subNum(9876673);

        List<String> list2 = new ArrayList<>();
        list2.add("boaz");

        list2.add("boat");
        list2.add("baoa");
        list2.add("aoat");
        sortStr(list2);


        //delsmallestCountChar

        String res9 = delMinCountChar("abcddd");
        System.out.println(res9);

        //isHasSubString
        boolean res10 =  isHasSubString("abcdabrc");
        System.out.println(res10);

        //比较学生成绩
        List<Student> list11 = new ArrayList<>();
        Student student1 = new Student(90,1);
        Student student11 = new Student(90,2);
        Student student2 = new Student(80,10);
        Student student21 = new Student(82,9);
        Student student3 = new Student(70,8);
        Student student4 = new Student(60,4);
        list11.add(student1);
        list11.add(student11);
        list11.add(student2);
        list11.add(student21);
        list11.add(student3);
        list11.add(student4);

        Collections.sort(list11);
        System.out.println(list11);


        double res11 =  getCubeRoot(216);
        System.out.println(res11);

    }

    /**思路一：
     * 命f(x) = x^3 - a，求解f(x) = x^3 - a = 0。
     * 利用泰勒公式展开，即f(x)在xo处的函数值为：
     * f(x) = f(xo) +f'(xo)(x-xo) = xo^3-a+3xo^2(x-x0) = 0，
     * 解之得：x = xo - (xo^3 - a) / (3xo^2)。
     *
     *
     * 求平方根用一个套路@_@：
     * 命f(x) = x^2 - a，求解f(x) = x^2 - a = 0。
     * 利用泰勒公式展开，即f(x)在xo处的函数值为：
     * f(x) = f(xo) +f'(xo)(x-xo) = xo^2-a+2xo(x-x0) = 0，
     * 解之得：x = (x+a/xo) / 2。
     *
     *
     *
     * 思路二：
     * 在一定的进度范围内，查找某个元素， f(x)  == input
     * 这里需要考虑输入为负数。 （-1)^3 = -1
     *
     * @param input
     * @return
     */
    private static double getCubeRoot(double input){
        //变量初始化
        double min = 0;
        double max = Math.abs(input) ;
        double mid = min + (max - min )/2;

        //具体逻辑
        final double THRESHOULD = 0.00001;
        while (Math.abs( max - min )> THRESHOULD){
            mid = min + (max - min )/2;
            if (mid * mid * mid > input){
                max = mid;
            }else if (mid * mid * mid < input){
                min = mid;
            }else {
                return mid;
            }
        }
        return mid;

    }


    /**
     * 持有一个滑动串口：i,i+3,作为最小的子字符串
     * @param str
     * @return
     */
    private static boolean isHasSubString(String str){
        for (int i = 0; i < str.length()-2; i++) {
            String str1 = str.substring(i,i+3);
            String str2 = str.substring(i+3,str.length());

            if (str2.contains(str1)){
                return false;
            }
        }
        return true;
    }


    /**
     * 按照字典顺序排序：那么这里你可以使用treeset进行排序
     * @param str
     * @return
     */
    private static int sortStr(List<String> strs){
        //check

        //handle
        TreeSet<String> set = new TreeSet();
        for (int i = 0; i < strs.size(); i++) {
            set.add(strs.get(i));
        }
        System.out.println(set);
        return -1;
    }

    private static String delMinCountChar(String str){
        //check

        //记录次数的映射
        HashMap<Character,Integer> map = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            Integer count =  map.get(str.charAt(i));
            if (count ==null){
                count = 0;
            }
            map.put(str.charAt(i) ,count+1);
        }
        System.out.println(map);

        //计算最小次数的字符。
        List<Character> characters =  getMinCount(map);

        //打印结果
        String res ="";
        for (int i = 0; i < str.length(); i++) {
            if (!inMinCount(characters,str.charAt(i))){
                res +=str.charAt(i);
            }
        }
        return res;
    }

    private static boolean inMinCount(List<Character> list, Character c){
        boolean res = false;
        for (int i = 0; i < list.size(); i++) {
            if (c == list.get(i)){
                res = true;
                return res;
            }
        }
        return res;
    }

    private static List<Character> getMinCount(HashMap<Character,Integer> map ){
        int min = Integer.MAX_VALUE;
        for (Character character : map.keySet()) {
            if (map.get(character) < min){
                min = map.get(character) ;
            }
        }

        //获取为mincount的字符串。
        List<Character> res = new ArrayList<>();
        for (Character character : map.keySet()) {
            if (map.get(character) == min){
                res.add(character);
            }
        }
        return res;
    }


    private static int subNum(int num){
        //check

        String str = String.valueOf(num);
        HashMap map = new HashMap();

        String res = "";
        for (int i = str.length()-1; i >=0 ; i--) {
            //获取map中知乎
            Object exist = map.get(str.charAt(i));
            if(exist == null){
                map.put(str.charAt(i),true);
                res += str.charAt(i);
            }
        }

        System.out.println(res);

        return 1;

    }


    private static int aboutNum(String num) {
        //check
        String[] bits = num.split("\\.");
        //数组处理一定要检查越界判断

        if ( bits ==null  || bits[1] == null || bits[0] == null) {
            return -1;
        }

        int res = Integer.parseInt(bits[0]);
        if (bits[1].charAt(0) - '0' >= 5) {
            res += 1;
        }
        return res;

    }

    private static int drinkCount(int bottleNum) {
        if (bottleNum < 2) {
            return 0;
        }

        if (bottleNum == 2) {
            return 1;
        }

        int childRes = drinkCount(bottleNum - 2) + 1;

        return childRes;

    }

    private static int bitChangeFrom16(String num) {
        int res = 0;
        int bitCount = 0;
        for (int i = num.length() - 1; i >= 2; i--) {
            res += Math.pow(16, bitCount) * bitChangeFrom16Single(num.charAt(i));
            bitCount++;
        }
        return res;
    }

    private static int bitChangeFrom16Single(char c) {

        if (c >= '0' && c <= '9') {
            return c - '0';
        }

        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }
        return -1;
    }


    private static List<String> splitStrs(List<String> strs) {
        //check

        //handle
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < strs.size(); i++) {
            //处理每个字符串
            List<String> singleStr = splitSingleStr(strs.get(0));
            stringList.addAll(singleStr);

        }

        return stringList;
    }

    private static List<String> splitSingleStr(String str) {
        //check

        int size = str.length();
        List<String> list = new ArrayList<>();
        String subStr = null;
        for (int i = 0; i < size; i++) {

            subStr += (str.charAt(i));
            if (subStr.length() == 8) {
                list.add(subStr);
                subStr = new String();
            }

        }

        if (subStr.length() == 0) {
            return list;
        }

        //补充8-最后一个字符串的0
        String newStr = new String(subStr);
        for (int i = 0; i < 8 - subStr.length(); i++) {
            newStr += "0";
        }
        list.add(newStr);

        return list;
    }

    private static List<Integer> randomIntegers(List<Integer> nums) {
        //check

        //去重
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            set.add(nums.get(i));
        }

        List<Integer> list = new ArrayList<>();
        for (Integer integer : set) {
            list.add(integer);
        }


        Collections.sort(list);
        return list;
    }

    public static String reverse(String str) throws Exception {
        //check
        if (str == null) {
            throw new Exception("输入参数非法");
        }


        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static int lastWordLength(String str) {
        //check：
        if (str == null) {
            return 0;
        }

        String[] strs = str.split(" ");
        if (strs.length == 0) {
            return 0;
        }
        String lastWord = strs[strs.length - 1];
        return lastWord.length();
    }

    public static int charsCount(String s, char c) {

        //check
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (!Character.isAlphabetic(c)) {
            return -1;
        }

        //前置处理
        String upperStr = s.toUpperCase();
        if (c >= 'a' && c <= 'z') {
            c -= 'a' - 'A';
        }

        //处理
        int count = 0;
        for (int i = 0; i < upperStr.length(); i++) {
            if (upperStr.charAt(i) == c) {
                count++;
            }
        }


        return count;
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int res = lastWordLength(s);
            System.out.println(res);
        }
    }
}
