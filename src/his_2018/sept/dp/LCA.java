package his_2018.sept.dp;

/**
 * Created by xbog on 2017/9/11.
 *
 * 最长公共 子序列：
 * 这里并不要求是是连续的
 *
 * 这里的dp是：
 *  length（i, j） = length(i -1,j -1) + 1 {if(str1[i -1] == str2[j - 1])}
 *                 = Math.max( length(i-1,j), length(i,j-1) )
 */
public class LCA {

    public static int LCS(String str1, String str2){

        int[][] length = new int[str1.length() + 1][ str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j ==  0){
                    length[i][j] = 0;
                }else if (str1.charAt(i-1) == str2.charAt(j -1)){
                    length[i][j] = length[i - 1][j-1] + 1;
                }else {
                    length[i][j] = Math.max(length[i - 1][j], length[i][j- 1]);
                }
            }
        }
        return length[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int res = LCS(str1,str2);
        System.out.println(res);
    }
}
