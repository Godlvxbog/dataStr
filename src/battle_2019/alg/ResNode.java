package battle_2019.alg;

import battle_2019.datastruct.MyNode;

import java.util.Stack;

/**
 * 1、从尾打印头链表，逆序打印链表
 * 2、翻转链表 stack
 * 3、使用指针
 *
 */
public class ResNode {
    public static void main(String[] args) {
        MyNode node = MyNode.initNode();
//        MyNode res = resNdoe2(node);
        MyNode res2 = resKNdoe(node,3);
        System.out.println(res2);

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

    /**
     * 采用非stack进行处理
     * @param node
     * @return
     */
    public static MyNode resNdoe2(MyNode node) {
        MyNode resNode = null;//已经逆序的链表
        MyNode cur = node;//当前节点
        while (cur != null){//遍历
            MyNode next = cur.next;//下一个节点

            cur.next =resNode;//当前节点链接上已经逆序的几点。
            resNode = cur ;//已经逆序的节点增加了一个节点
            cur = next;//j++
        }
        return resNode;
    }



    /**
     * 链表的倒数第k个节点:
     * 快慢指针
     * stack
     *
     * 注意点：node.size()如果小于k
     * @param node
     * @return
     */
    public static MyNode resKNdoe(MyNode node,int k) {
        if (k <=0 ){
            return null;
        }
        MyNode fast = node;
        MyNode slow = node;
        //node.size()如果小于k做异常处理
        while (k > 0){
            fast = fast.next;
            k--;
        }

        while (fast != null){
            fast =fast.next;
            slow = slow.next;
        }
        return slow;
    }
}