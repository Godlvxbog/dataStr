package alg.tree.D_C.toTree;

import alg.tree.TNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 问题描述：
 * 已知，先序和中序，生成一颗树
 *
 * 思路：
 *
 * 用先序生成树。类似serial中的先序生成树。
 *
 * 中序序列， pre[i]  ---  map(in[i],i) 得到先序数组中，该数的位置，，长度是  index - ni
 */
public class PreInToTree {

    public static TNode gen2Tree(ArrayList<Integer> pre,ArrayList<Integer> in){
        HashMap<Integer,Integer> inIndexFromPreNum= new HashMap<Integer, Integer>();

        for (int i = 0; i < in.size(); i++){
            inIndexFromPreNum.put(in.get(i),i);
        }
        TNode node = preIn2Tree(pre,0,pre.size() - 1,in, 0, in.size() - 1,inIndexFromPreNum);
        return node;
    }


    public static TNode preIn2Tree(ArrayList<Integer> pre, int preLeft, int preRight,
                                   ArrayList<Integer> in , int inLeft, int  inRight,
                                   HashMap<Integer, Integer> map){
        //使用先序生成树
        if (preLeft > preRight){
            return null;
        }
        int data =pre.get(preLeft);
        TNode head =new TNode(data);

        int index = map.get(data);//得到该点在中序列中的索引

        TNode left = preIn2Tree(pre, preLeft + 1, preLeft + index - inLeft,
                in, inLeft, index - 1, map);
        head.left = left;
        TNode right = preIn2Tree(pre, preLeft + index + 1 - inLeft, preRight,
                in, index + 1, inRight, map);
        head.right = right;

        return head;
    }



    public static void main(String[] args) {
        ArrayList<Integer> pre =new ArrayList<Integer>();
        ArrayList<Integer> in =new ArrayList<Integer>();
        pre.add(1);
        pre.add(2);
        pre.add(4);
        pre.add(5);
        pre.add(8);
        pre.add(9);
        pre.add(3);
        pre.add(6);
        pre.add(7);

        in.add(4);
        in.add(2);
        in.add(8);
        in.add(5);
        in.add(9);
        in.add(1);
        in.add(6);
        in.add(3);
        in.add(7);


        gen2Tree(pre,in);
    }
}
