package orrientedOffer;

/**
 * Created by Administrator on 2017/2/18.
 * 关键点：把二维的数组转换成一维数组；进行索引  index = COLS * row + col;
 * 从左下点 或者 右上点开始进行遍历
 */
public class SeachNumInMatrix {

    public static boolean searchNumInMatrix(int[] reMatrix, int rows, int cols,int target){
        boolean found = false;//记录是否找得到该元素
        int col = cols -1;
        int row = 0;

        while (col >= 0 && row < rows){//循环的终止条件是出界：每次的循环变量是决定col左移动还是右移动
            if (target == reMatrix[row *cols + col]) {
                found = true;
                break;
            }else if (target < reMatrix[row *cols + col]){
                col --;
            }else{
                row++;
            }
        }

        return found;
    }

    public static int[] matrix2array(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] reMatrix = new int[col * row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                reMatrix[i * col + j] = matrix[i][j];
            }
        }
        return reMatrix;
    }



    public static void main(String[] args) {
        final int COLS =4;
        final int ROWS = 4;
        int[][] matrix = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15},
        };

        int[] reMatrix = matrix2array(matrix);

        boolean found = searchNumInMatrix(reMatrix,4,4,26);

        System.out.println(found);





    }


}
