package leetcode.tree;

import battle_2019.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何使用递归的返回值
 * 257：二叉树的 路径和。 https://leetcode-cn.com/problems/binary-tree-paths/submissions/
 * 类似的：113， 返回和为sum =k的路径。   https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 437 :https://leetcode-cn.com/problems/path-sum-iii/, 可以从任意节点开始而非一定要从根节点开始。
 */
public class BinTreePaths {
    public static void main(String[] args) {

    }

    /**
     * 函数的语义：传入一个root，将左孩子的的及诶单添加到集合中，将右孩子的的及诶单添加到集合中，
     * 终止条件：叶子节点。
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        //终止条件:如果到达了叶子节点.注意，只要范围叶子节点就要考虑根节点的空指针的问题。
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.data));
            return res;
        }

        //递归的过程:向结果集中推入了当前节点的左子树的结果
        List<String> leftRes = binaryTreePaths(root.left);
        res = format(leftRes, root, res);

        List<String> rightRes = binaryTreePaths(root.right);
        res = format(rightRes, root, res);

        return res;
    }

    public List<String> format(List<String> sonres, TreeNode root, List<String> res) {
        for (int i = 0; i < sonres.size(); i++) {
            res.add(String.valueOf(root.data) + "->" + sonres.get(i));
        }
        return res;
    }


    /**
     * 437
     * 以root为根节点，寻找和为sum的路径，返回路径的个数
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }

        //包含当前节点的路径
        int res = findPath(root, sum );

        //不包含当前节点的路径
        res += findPath(root.left,sum);
        res += findPath(root.right,sum);

        return res;
    }


    /**
     * 以node为根节点，寻找和为sum的路径，且包含node的，路径。返回路径的个数
     * @param node
     * @param num
     * @return
     */
    private int findPath(TreeNode node ,int num){
        if (node == null){
            return 0;
        }

        int res =0;
        if (node.data == num){
            res += 1;
        }

        res += findPath(node.left,num);
        res += findPath(node.right,num);

        return res;
    }








}
