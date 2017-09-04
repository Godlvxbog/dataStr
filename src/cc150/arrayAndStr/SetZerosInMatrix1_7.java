package arrayAndStr;

/**
 * 题目描述：若M*N矩阵中，有某个元素为0，则将其所在元素都清零。
 * 陷阱：不能在线字节把有0的元素，就把row and col进行setZero
 * .需要记录某一个行有该元素
 *
 * 思路：
 * 新建一个Hash矩阵，用来标记位置是否为您
 *
 * 数组  array.length  和str.length();以示区别
 *
 * 还有最优写法没有写：
 */
public class SetZerosInMatrix1_7 {
    public static void main(String[] args) {
        int[][] mattest={
                {0,1,2},
                {2,4,5},
                {5,4,8}
        };

        System.out.println(setZeros(mattest).toString());
    }

    public static int[][] setZeros(int[][] matrix){
        //新建一个hash的二维数组
        boolean[][] myMatrix=new boolean[matrix.length][matrix[0].length];

        //遍历matrix，记录matrix的个数
        for (int i=0; i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    myMatrix[i][j]=true;
                }
            }
        }

        //开始setzeros
        for (int i=0; i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (myMatrix[i][j]==true){
                    for (int k=0;k<matrix.length;k++){
                        matrix[i][k]=0;
                        matrix[k][j]=0;
                    }
                }
            }
        }
        return matrix;

    }
}
