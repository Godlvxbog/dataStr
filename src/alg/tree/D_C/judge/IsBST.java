package alg.tree.D_C.judge;

import alg.tree.TNode;
import alg.tree.serial.LayerSerial;

import java.util.Queue;

/**
 * 判断是不是BST
 */
public class IsBST {

    static class Result {
        int data = 0;
        boolean isbst = true;
    }

    public static void main(String[] args) {

        String str = "3!1!6!#!#!5!8!#!#!#!#!";

        Queue<String> queue = LayerSerial.splitStr(str);

        TNode head = LayerSerial.revLayer(queue);



        System.out.println(isBST(head).isbst);
    }

    //用pre指向当前节点的上一个点
    public static Result isBST(TNode root){
        if (root == null){
            return null;
        }


        Result cur =new Result();
        cur.data = root.data;

        Result left = isBST(root.left);
        Result right = isBST(root.right);

        //到达末节点时候就新创建一个结果
        if(left == null){
            left = new Result();
            left.data =Integer.MIN_VALUE;

        }
        if (right == null){
            right =new Result();
            right.data = Integer.MAX_VALUE;

        }

        if (left.data > cur.data){
            cur.isbst = false;
            return cur;
        }

        if (right.data <=cur.data){
            cur.isbst = false;
            return cur;
        }

        if (!left.isbst || !right.isbst){
            cur.isbst =false;
            return cur;
        }

        return cur;

    }
}
