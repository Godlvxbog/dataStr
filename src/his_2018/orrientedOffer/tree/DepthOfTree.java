package his_2018.orrientedOffer.tree;

import his_2018.alg.tree.TNode;

/**
 * Created by Administrator on 2017/2/27.
 *
 * 两种方法求最大的深度：
 *
 * 1先序遍历：
 *          depthRoot == depthChild
 *
 * 2,后序遍历：
 *          depthRoot = max(left, right) +1
 */
public class DepthOfTree {

    static int depthRes = 1;
    public static void getDepth1(TNode root, int depth){
        if (root == null){
            return;
        }

        depthRes = depth;
        if (root.left != null){
            getDepth1(root.left, depth + 1);

        }

        if (root.right != null){
            getDepth1(root.right, depth + 1);
        }
    }


    public static int getDepth2(TNode root){
        if (root == null){
            return 0;
        }

        int left = getDepth2(root.left);
        int right = getDepth2(root.right);

        int deRot = Math.max(left,right) + 1;

        return deRot;
    }



    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        int res =  getDepth2(root);
        System.out.println(res);
    }
}
