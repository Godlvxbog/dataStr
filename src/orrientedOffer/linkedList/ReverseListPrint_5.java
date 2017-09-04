package orrientedOffer.linkedList;

import alg.linkedlist.Node;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/2/19.
 * 给你一个链表，从尾部打印节点
 */
public class ReverseListPrint_5 {

    static void revPrint(Node node){
        if (node == null){
            return;
        }
        Node cur = node;
        Stack<Node> stack = new Stack<Node>();
        //存到栈中，倒出来之后就是倒序了
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop().data);
            System.out.print("->");
        }
        System.out.print("NULL");

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Node res = Node.buildListByArray(list);
//        revPrint(res);
        rePrintList(res);
    }

    /**
     * 递归的实现
     */

    public static void rePrintList(Node node){
        if (node != null){
            rePrintList(node.next);
            System.out.print(node.data+"->");
        }
    }
}
