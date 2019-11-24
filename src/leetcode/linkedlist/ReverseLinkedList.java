package leetcode.linkedlist;

import his_2018.alg.linkedlist.Node;


/**
 * 题目：206  https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node res = reverseList(Node.buildDefaultListByArray());
        Node.printLinkedList(res);
    }



    public static Node reverseList(Node head) {

        if (head == null){
            return null;
        }

        //保存前一个节点，这个节点之前是已经翻转了的节点
        Node pre = null;
        //初始化
        Node cur = head;


        //遍历处理
        while (cur != null){
            //保存next的节点
            Node next = cur.next;

            cur.next = pre; //翻转
            //移动更新当前的处理的节点
            pre = cur;
            cur = next;
        }

        //pre为新链表的头结点。
        return pre;
    }

}
