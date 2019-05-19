package his_2018.alg.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 判断一个链表是否是回文结构
 *
 * 逆序，的reverse完全相同
 * 思路：
 * 全部压栈；
 *
 * 然后弹出（得到逆序）
 */
public class IsHUINode {

    public static boolean ishui(Node node){
        Stack<Node> stack = new Stack<Node>();
        Node head = node;
        while (node !=null){
            stack.push(node);
            node = node.next;
        }

        while (head !=null ){
            int data = stack.pop().data;
            if (head.data != data){
                return false;
            }

            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(30);

        list.add(20);
        list.add(10);

        Node res = Node.buildListByArray(list);

        boolean hui = ishui(res);
        System.out.println(hui);

    }
}
