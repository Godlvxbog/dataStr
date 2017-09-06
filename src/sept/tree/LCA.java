package sept.tree;

import alg.tree.TNode;

/**
 * Created by Administrator on 2016/12/15.
 * 最近公共祖先
 *
 * 1，分配任务是：
 * 返回祖先节点，
 * 压任务的终点：
 * 1，如果为空，返回null;
 * 2,如果找到了O1，就返回O1,也就是他本身
 *
 * 本级要做的事情是：
 *
 * 不用做
 *
 * 收任务要做的事情是：
 *
 * 1、left，right 如果都不为空，说明找到了两边，返回head
 * 1机械键盘怎么样好不好用你觉得怎么红轴的一看就很垃圾
 *
 *
 *
 */
public class LCA {

    public static TNode getAncenstor(TNode root,TNode t1,TNode t2){
        if (root == null){
            return null;
        }

        //只要有一个是节点是根节点，返回当前
        if (root == t1 || root == t2){
            return root;
        }

        //本级要做的事情是：无
        //本级要返回的事情是：
        TNode left =getAncenstor(root.left,t1,t2);
        TNode right =getAncenstor(root.right,t1,t2);

        //左右孩子树的公共祖先节点：分为三种 1两个都是空，
        if (left != null && right !=null){
            return root;
        }

        if (left !=null){
            return left;
        }

        return right;
    }

    public static void main(String[] args) {

    }
}
