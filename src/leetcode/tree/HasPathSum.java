package leetcode.tree;

import battle_2019.datastruct.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 给你一个树，路径总和sum是否存在
 *
 *
 */
public class HasPathSum {

    public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int sum) {
        //终止条件:不应该是root == null，而是叶子节点
//        if (root == null){
//            //走到最后的叶子节点为null，如果恰好sum == 0那么我们找到了。
//            if (sum == 0){
//                return true;
//            }
//        }
        if (root ==null){
            return false;
        }

        if (root.left == null && root.right ==null){
            //走到最后的叶子节点为null，如果恰好sum == 0那么我们找到了。
            if (sum == root.data){
                return true;
            }
        }

        //递归逻辑:找到左子树的sum-root.data能否找得到
        boolean leferes = hasPathSum(root.left,sum -root.data);
        if (leferes){
            return true;
        }

        boolean rightres = hasPathSum(root.right,sum -root.data);
        if (rightres){
            return true;
        }

        return false;
    }




}
