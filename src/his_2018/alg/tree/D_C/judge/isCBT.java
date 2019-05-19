package his_2018.alg.tree.D_C.judge;

import his_2018.alg.tree.TNode;
import his_2018.alg.tree.serial.LayerSerial;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是完全二叉树：
 * 按照定义：
 *
 * 除去最后一层：设置leaf来标记（right == null）,其他的都为满二叉树
 * 层序遍历
 */
public class isCBT {
    public static boolean iscbt(TNode root){
        Queue<TNode> queue =new LinkedList<TNode>();
        TNode left =null;
        TNode right =null;
        boolean isleaf = false;

        queue.add(root);

        while (!queue.isEmpty()){
            TNode temp =queue.poll();
            left = temp.left;
            right = temp.right;
            //无左却有右孩子
            if (left == null && right != null){
                return false;
            }

            //最后一层的节点，一定没有孩子
            if (isleaf && (left != null || right != null)){
                return false;
            }

            //把孩子加入到就绪队列
            if (left !=null){
                queue.add(left);
            }

            if (right != null){
                queue.add(right);
            }else{//第一次出现右边孩子为空，则该成设置为叶子层，不允许有孩子的节点
                isleaf = true;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        String str = "3!1!6!#!#!#!#!";
        Queue<String> queue = LayerSerial.splitStr(str);
        TNode head = LayerSerial.revLayer(queue);

        System.out.println(iscbt(head));
    }


}
