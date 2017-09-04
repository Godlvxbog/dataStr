package orrientedOffer.tree;

import alg.tree.TNode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/1.
 */
public class KBigNumInOrderTree {

    static ArrayList<Integer> res =new ArrayList<Integer>();
    public static void KthNode(TNode root){
        if (root == null){
            return ;
        }

        if (root.left != null){
            KthNode(root.left);//k不变，需要访问的时候才变
        }

        res.add(root.data);


        if (root.right != null){
            KthNode(root.right);
        }

    }




    public static Integer getKth( ArrayList<Integer> list ,int k){
        if (k <= 0 || k > list.size()){
            return null;
        }
        return list.get(k-1);
    }

    public static void main(String[] args) {
        TNode root =TNode.buildTree();

    }
}
