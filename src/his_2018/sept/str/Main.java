package his_2018.sept.str;

import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int time = findTime(line, map);
        System.out.println(time);

    }


    //===============
    public static void getMaxStance(){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            //标准输入
            int num = scanner.nextInt();//个数

            double maxDis = Double.MIN_VALUE;

            ArrayList<Double> smalls = new ArrayList<Double>();
            ArrayList<Double> bigs = new ArrayList<Double>();
            for (int i = 0; i < num; i++) {
                double dis = scanner.nextDouble();
                if (dis >= 0 && dis <180){
                    smalls.add(dis);
                }else if (dis >= 180 && dis <360){
                    bigs.add(dis);
                }
            }

            Arrays.sort(smalls.toArray());

            double smallRes = 0;
            if (smalls.size() > 0){
                smallRes = smalls.get(smalls.size() -1) - smalls.get(0);
            }

            double bigRes = 0;
            if (bigs.size() > 0){
                bigRes = bigs.get(bigs.size() -1) - bigs.get(0);
            }


            Arrays.sort(bigs.toArray());


            double midRes = Double.MIN_VALUE;
            for (int i= 0; i< smalls.size(); i++){
                for (int j =0;j<bigs.size(); j++){

                    double oldMax = 0;
                    double temp = 180+ smalls.get(i);

                    if (bigs.get(j) <= temp){
                        oldMax = bigs.get(j) - smalls.get(i);
                    }else {
                        oldMax = 360 + smalls.get(i) - bigs.get(j);
                    }

                    if (oldMax > midRes){
                        midRes = oldMax;
                    }
                }
            }
            double max1 = Math.max(smallRes,bigRes);
            double max2 = Math.max(max1,midRes);
            System.out.printf("%.8f",max2);
            //已经排好的序列

        }
    }



   public static int findTime(String line, HashMap<String, Integer> map) {
       if (line.isEmpty()) {
                return 1;
       }
       if (map.containsKey(line)) {
               return map.get(line);

       }
       int res = 0;
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) == ')') {
                String left = null;
                if (i == 1) {
                    left = line.substring(2);
                } else {
                    left = line.substring(1, i) + line.substring(i+1);
                }
                if (isLegal(left)) {
                    res += findTime(left, map);
                }
            }
        }
        map.put(line, res);
        return res;
   }
    public static boolean isLegal(String str) {
        int l = 0, r = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                    l++;
            } else {
                r++;
            }
            if (r > l) {
             return false;

            }

        }
         return true;
    }
}