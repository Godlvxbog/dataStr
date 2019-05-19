package his_2018.sept.dp;

/**
 * Created by xbog on 2017/9/11.
 *
 *
 * 典型的二维空间计数问题：
 * 机器人移动
 * 机器人只能往下，或者往右边移动
 * 问，机器人从（0,0）到（i,j）有多少条路径
 * 其实这里有点像 青蛙跳的 加强版，二位结果集
 *
 * path (i,j) = path(i-1,j) + path(i,j-1);
 *
 * */


public class RobotMove {

    public static int robotMvNums(int m,int n){
        //开辟空间进行保存
        int maxIndex = Math.max(m,n);
        int[][] path = new int[maxIndex + 1][maxIndex + 1];
        path[0][0] = 0;


        //开始遍历
        for (int i = 1; i <= m; i++){
            path[i][0] = 1;
            for (int j = 1;j <= n; j++){
                path[0][j] = 1;

                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }

        return path[m][n];

    }

    public static void main(String[] args) {
        System.out.println(robotMvNums(3,2));
    }
}
