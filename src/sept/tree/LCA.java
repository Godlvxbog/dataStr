package sept.tree;

import alg.tree.TNode;

/**
 * Created by Administrator on 2016/12/15.
    写一个cover：判断当前节点是在属于 该子树上面
 *
 *
 */
public class LCA {


    /**
     * 判断当前节点是不是属于这棵树
     * @param root
     * @param node
     * @return
     */
    public static boolean isExist(TNode root ,TNode node){
        if (root == null){
            return false;
        }
        if (node == null){
            return true;
        }

        //如果当前节点相等了:这是最底层的计算了。
        if (root == node){
            return true;
        }

        //回收任务结果，如果左右孩子有一个是存在的，那么就是存在的
        boolean left = isExist(root.left,node);
        boolean right = isExist(root.left,node);

        return left || right;
    }


    /**
     * 如果当前节点都在左子树，那么需要往下找，
     * 如果不是在一边的话，就是当前节点了
     * @param root
     * @param t1
     * @param t2
     * @return
     */
    public static TNode getAncenstor(TNode root,TNode t1,TNode t2){
        if (root == null){
            return null;
        }

        if (isExist(root.left,t1) && isExist(root.left,t2)){
            return getAncenstor(root.left,t1,t2);
        }

        if (isExist(root.right,t1) && isExist(root.right,t2)){
            return getAncenstor(root.right,t1,t2);
        }

        //如果都不是就是root
        return root;

    }

    public static void main(String[] args) {

    }
}
