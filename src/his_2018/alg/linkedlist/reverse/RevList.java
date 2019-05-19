package his_2018.alg.linkedlist.reverse;

import his_2018.alg.linkedlist.Node;

import java.util.ArrayList;

/**
 * 反转一个链表
 */
public class RevList {

    public static Node revList(Node head){
        Node newHead = null;//新的节点

        Node cur = head;
        while (cur != null){
            Node next = cur.next;

            cur.next = newHead;
            newHead = cur;

            cur = next;
        }
        return newHead;
    }

    public static Node revList2(Node head){
        Node cur = head.next;

        Node newHead = head;//新的节点
        newHead.next = null;
        Node temp =null;

        while (cur != null){
            Node next = cur.next;

            temp = cur;//复制作为新产生节点的指针
            temp.next = newHead;//连接新节点的头指针
            newHead = temp;//头指针更新

            cur = next;
        }
        return newHead;
    }


    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Node res = Node.buildListByArray(list);

        Node newHead = revList2(res);
    }

}
