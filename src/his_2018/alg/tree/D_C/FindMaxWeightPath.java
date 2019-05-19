package his_2018.alg.tree.D_C;

import his_2018.alg.tree.TNode;

import java.util.ArrayList;

/**
 * 问题描述：找出树当中的最大的点权和的路径
 *
 * 思路：
 * 后序遍历 ：当前的最大值等于  加上左右两边的较大的值，，路径等于加上左右孩子较大的值
 *
 * 每次遇到null，需要生成result，孩子节点结果，
 *
 * finalResult保存当前的
 */
public class FindMaxWeightPath {

    static class Result {
        int wSum = 0;
        ArrayList<Integer> path =new ArrayList<Integer>();
    }

    public static Result findMaxPath(TNode root,Result curRes){
        if (root == null){
            Result childRes = new Result();
            return childRes;
        }

        Result left = findMaxPath(root.left,curRes);
        Result right = findMaxPath(root.right,curRes);

        //选择路径长的
        if (left.wSum > right.wSum){
            left.wSum += root.data;
            left.path.add(root.data);
            curRes =left;
        }

        if (left.wSum <= right.wSum){
            right.wSum +=root.data;
            right.path.add(root.data);
            curRes =right;
        }

        return curRes;

    }

    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        Result result = findMaxPath(root,new Result());
    }


}
