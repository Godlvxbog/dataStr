package leetcode.tree;

import battle_2019.datastruct.TreeNode;

/**
 * 树的最大深度：104
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * 需要充分理解，递归的终止条件，与终止的过程。
 */
public class MaxDepth {

    public static void main(String[] args) {

    }

    /**
     * 定义：此函数是计算树的深度的，那么他可以计算左孩子，也可以计算右边孩子的深度。
     * leftdepth = maxDepth(root.left);   rightdepth = maxDepth(root.right);
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //终止条件
        if (root== null){
            return 0;
        }

        //递归逻辑

        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        int res = Math.max(leftdepth,rightdepth ) + 1;

        return res;
    }

    /**
     * 深度：从根节点到叶子节点，而非到null。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        //终止条件
        if (root== null){
            return 0;
        }

        int leftdepth = minDepth(root.left);
        int rightdepth = minDepth(root.right);

        //结果处理：如果右边孩子有,当前节点深度为右边的 深度+1
        if (root.left == null && root.right != null){
            return rightdepth + 1;
        }
        if (root.right == null && root.left != null){
            return leftdepth + 1;
        }

        //两个都不为空
        int res = Math.min(leftdepth,rightdepth ) + 1;

        return res;
    }
}
