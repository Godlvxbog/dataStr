package alg.tree.D_C;

import alg.tree.TNode;

/**
 * 题目要求：求出一颗树的最大深度
 *
 * 思路：后序遍历
 *
 * 从叶子，开始，记录深度为零，
 *
 * 叶子节点深度为leafDep;  当前深度为curDep；
 * curDep = max(left,right) + 1
 *
 *
 * 分治法：
 *
 * 左边最大深度，右边最大深度，取max  + 1
 *
 *
 */
public class MaxDepth {

    static int leafDep = 0;
    public static int getMaxDepth(TNode root,int curDep){
        if (root == null){
            return leafDep;
        }

        int left =getMaxDepth(root.left,curDep);
        int right =getMaxDepth(root.right,curDep);

        curDep =Math.max(left,right) + 1;

        return curDep;

    }

    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        System.out.println(getMaxDepth(root,0));
    }
}
