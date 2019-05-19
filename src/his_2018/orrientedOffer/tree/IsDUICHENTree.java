package his_2018.orrientedOffer.tree;

import his_2018.alg.tree.TNode;

/**
 * Created by Administrator on 2017/3/1.
 *
 * 思路：
 *
 * 判断子树的根节点是否相同，t1.left == t2.right是否相等
 *
 * 分治法：先得到左，再得到有边
 */
public class IsDUICHENTree {

    public static boolean isDui(TNode root){
        if (root == null){
            return true;
        }

        TNode root1 = root.left;
        TNode root2 = root.right;
        return isCommon(root1,root2);
    }


    public static boolean isCommon(TNode root1,TNode root2){

        if (root1 == null){
            return root2 == null;
        }
        if (root2 == null){
            return root1 == null;
        }

        boolean resRoot = (root1.data == root2.data)?true:false;

        boolean resLeft = isCommon(root1.left,root2.right);
        boolean resRight = isCommon(root2.right,root1.left);

        boolean res = resRoot&& resLeft && resRight;

        return res;


    }

    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        ;
        System.out.println(isDui(root));
    }
}
