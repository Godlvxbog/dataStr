package his_2018.alg.tree.D_C.judge;

import his_2018.alg.tree.TNode;

/**
 * 注意，每条分支一旦为null节点，都要new一个resultType
 *
 * result :保存当前层的深度和是否平衡
 *
 * 关键点
 * left：左边孩子的深度和平衡 :每个null节点时候需要新生成一个
 * right:同上
 *
 * 深度计算：出栈时候，后序取两者的最大值+1
 * 确定是否平衡： 左不平衡，右不平衡，左右深度差绝对值大于一
 */
public class IsBalanced {

    public static class Result{
        int depth = 0;
        boolean isbalanced = true;
    }

    //使用后序遍历：参数变化是root -- root.left等，res.depth + 1 。后序遍历
    public static Result getDepth(TNode root, Result result){
        if (root == null){
            Result res = new Result(); //关键点，防止污染
            return res;
        }

        Result left = getDepth(root.left,result);
        Result right = getDepth(root.right,result);

        if (!left.isbalanced || !right.isbalanced || Math.abs(left.depth - right.depth) > 1){
            result.isbalanced =false;
        }

        result.depth = Math.max(left.depth ,right.depth) + 1;
        return result;

    }

    public static boolean isBalanced(TNode root){
        Result res =new Result();
        Result result = getDepth(root,res);
        if (result.isbalanced){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        TNode root =TNode.buildTree();

        System.out.println( isBalanced(root));
    }


}
