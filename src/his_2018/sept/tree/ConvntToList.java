package his_2018.sept.tree;

import his_2018.alg.tree.TNode;

import javax.swing.border.TitledBorder;
import java.util.List;

/**
 * Created by xbog on 2017/9/5.
 * 将一个二叉树转换成一个链表，不需要额外的空间
 *
 * 思路：
 * 遍历
 */
public class ConvntToList {

    public static TNode tree2List(TNode root){
        if (root == null ){
            return null;
        }

        TNode leftNode = tree2List(root.left);
        TNode rightNode = tree2List(root.right);

        if (leftNode != null){
            leftNode.right = root.right;
        }
        if (root.left != null){
            root.right = root.left;
        }
        root.left = null;


        if (rightNode != null){
            return rightNode;
        }else if (leftNode != null){
            return leftNode;
        }else {
            return root;
        }

    }

    public static void main(String[] args) {
        TNode root = TNode.buildTree();

        TNode res = tree2List(root);

        System.out.println("234");


    }
}
