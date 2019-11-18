package leetcode.tree;

import battle_2019.datastruct.TreeNode;

/**
 * 翻转二叉树：https://leetcode-cn.com/problems/invert-binary-tree/
 * 226.
 */
public class InvertBinTree {

    public static void main(String[] args) {

    }


    /**
     * 定义此函数为对root的根节点的树，翻转其左右两边的孩子。
     *
     * 终止条件：如果root为null，那么没什么好翻转的直接返回null即可。
     * 递归逻辑:
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        swap (root);

        return root;
    }

    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


}
