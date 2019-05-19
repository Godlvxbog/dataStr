package his_2018.alg.tree.D_C;

import his_2018.alg.tree.TNode;

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
 * 1、left，right 如果都不为空，说明找到了两边，返回head;
 * 2、只有一边有： 就返回该边
 *
 *
 *
 */
public class LCA {

    public static TNode getAncenstor(TNode head,TNode t1,TNode t2){
        if (head == null){
            return null;
        }
        if (head == t1 || head == t2){
            return head;
        }

        //本级要做的事情是：无
        //本级要返回的事情是：
        TNode left =getAncenstor(head.left,t1,t2);
        TNode right =getAncenstor(head.right,t1,t2);

        if (left != null && right !=null){
            return head;
        }

        if (left !=null){
            return left;
        }

        return right;
    }

    public static void main(String[] args) {

    }
}
