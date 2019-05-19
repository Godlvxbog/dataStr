package his_2018.orrientedOffer.tree;

import his_2018.alg.tree.TNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/2/27.
 */
public class LayerPrintTree {

    public static void printLayerTree(TNode root){
        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            TNode temp = queue.poll();
            System.out.println(temp.data);

            //
            if (temp.left != null){
                queue.add(temp.left);

            }
            if (temp.right != null){

                queue.add(temp.right);
            }
        }
    }


    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        printLayerTree(root);
    }
}
