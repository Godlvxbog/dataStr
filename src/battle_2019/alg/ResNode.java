package battle_2019.alg;

import battle_2019.datastruct.MyNode;

import java.util.Stack;

/**
 * 从尾打印头链表，逆序打印链表
 */
public class ResNode {
    public static void main(String[] args) {
        MyNode node = MyNode.initNode();
        resNdoe(node);

    }


    /**
     * 正向打印链表:
     * 递归地打印
     */
    public static void printNormal(MyNode node) {
        if (node == null) {
            return;
        }

        if (node != null) {
            System.out.println(node.data);
            printNormal(node.next);

        }
    }

    /**
     * 递归地逆向打印
     *
     * @param node
     */
    public static void printNormalRes(MyNode node) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            printNormalRes(node.next);
            System.out.println(node.data);
        }
    }

    /**
     * 非递归地打印
     */
    public static void printRes2(MyNode node) {
        if (node == null) {
            return;
        }
        Stack<MyNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (!stack.isEmpty()) {
            MyNode myNode = stack.pop();
            System.out.println(myNode.data);
        }
    }


    /***
     * ============================== 翻转链表，需要改变原链表的结构====================
     *
     */
    public static MyNode resNdoe(MyNode node) {
        if (node == null) {
            return node;
        }
        Stack<MyNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        MyNode head = stack.pop();
        MyNode cur = head;
        while (!stack.isEmpty()) {
            MyNode temp = stack.pop();
            cur.next = temp;
            cur  = cur.next;
        }
        cur.next = null;     //最后的要为null作为最后一个元素。
        return head;
    }
}