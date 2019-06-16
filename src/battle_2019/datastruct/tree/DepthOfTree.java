package battle_2019.datastruct.tree;

import battle_2019.datastruct.TreeNode;

import static battle_2019.datastruct.TreeNode.buildTree;

/**
 *
 * 【剑指Offer ：39】
 * 1、求树的深度。
 * 2、是不是平衡的二叉树
 */
public class DepthOfTree {

    public static void main(String[] args) {
        TreeNode root = buildTree();
        boolean res = isBanlance(root);
        System.out.println(res);


    }
    int depth =1;

    public static int depth(TreeNode node){
        if (node == null){
            return 0;
        }
        int resLeft = depth(node.left);
        int resRigth = depth(node.right);

        //后续遍历：先遍历后计算，先拿到左右两边的数字，然后计算
        int res = resLeft >= resRigth ? resLeft + 1: resRigth +1;
        return res;
    }

    public static  boolean isBanlance(TreeNode node){
        //叶子节点的初始化，所有的树相关的都要画图。
        if (node == null){
            return true;
        }
        int leftdepth = depth(node.left);
        int rigthdepth = depth(node.right);

        int diff = Math.abs(leftdepth  - rigthdepth);
        if (diff > 1 ){
            return false;
        }

        boolean leftRes = isBanlance(node.left);
        boolean rightRes = isBanlance(node.right);
        return  leftRes&& rightRes;
    }
}
