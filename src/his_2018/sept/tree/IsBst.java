package his_2018.sept.tree;

import his_2018.alg.tree.TNode;

/**
 * Created by xbog on 2017/9/4.
 * 平衡树的定义是：左右孩子都是平衡树，并且左右孩子树的深度相差小于等于一
 */
public class IsBst {

    class BstResult{
        boolean isB = true;
        int depth = 0;
    }

    public BstResult isBst(TNode root){

        //空节点是平衡的
        if (root == null){
            return new BstResult();
        }

        BstResult left = isBst(root.left);
        BstResult right = isBst(root.right);

        BstResult cur = new BstResult();
        if (left.isB && right.isB && Math.abs(left.depth - right.depth) <=1){

            cur.depth = Math.max(left.depth,right.depth) + 1;
            cur.isB = true;
        }else {
            cur.depth = Math.max(left.depth,right.depth) + 1;
            cur.isB = false;
        }
        return cur;

    }

    public boolean isBst2(TNode root){

        //空节点是平衡的
        if (root == null){
            return true;
        }

        boolean left = isBst2(root.left);
        boolean right = isBst2(root.right);

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (left && right && Math.abs(leftDepth - rightDepth) <= 1){
            return true;
        }

        return false;

    }

    public int getDepth(TNode root){
        if (root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        int curDepth = Math.max(left,right)+1;
        return curDepth;
    }




    //其实不是很建议以上，学会吧一坨代码塞到一个方法中去getdepth
    public static void main(String[] args) {
        TNode node =  TNode.buildTree();
        IsBst isb = new IsBst();

//        System.out.println( isb.getDepth(node));
        boolean res = isb.isBst2(node);
        System.out.println(res);
    }
}
