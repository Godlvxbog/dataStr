package orrientedOffer.tree;

import alg.tree.TNode;

import java.util.*;

/**
 * Created by Administrator on 2017/3/1.
 */
public class PrintZHINode {

    public static ArrayList< ArrayList<TNode> > printZHI(TNode root){
        ArrayList< ArrayList<TNode> > res = new ArrayList<ArrayList<TNode>>();

        if (root == null){
            return res;
        }

        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            ArrayList<TNode> row = new ArrayList<TNode>();
            int start = 0,length = queue.size();

            while (start++ < length){
                TNode cur = queue.poll();
                row.add(cur);

                if (cur.left != null){
                    queue.add(cur.left);
                }

                if (cur.right != null){
                    queue.add(cur.right);
                }

            }

            res.add(row);
        }

        for (int i = 0;i<res.size();i++){
            if (i%2 == 1){
                revList(res.get(i));
            }
        }


        return res;

    }

    public static ArrayList<TNode> revList(ArrayList<TNode> list){
        ArrayList<TNode> newlist =new ArrayList<TNode>();
        Stack<TNode> stack = new Stack<TNode>();
        int length = list.size();

        for (int i = 0; i< length;i++){
            stack.push(list.get(i));
        }
        list.clear();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }

        return newlist;

    }


    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        ArrayList< ArrayList<TNode> > res =  printZHI(root);
        System.out.println();
    }
}
