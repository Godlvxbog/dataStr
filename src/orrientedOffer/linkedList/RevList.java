package orrientedOffer.linkedList;

import alg.linkedlist.Node;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/19.
 *
 * 反转链表：
 * 关键点：3个指针； prev保存前一个，cur，
 * 当前指针需要指向后面一个 next 即将需要修改的指针
 * 返回的时机是：最后一个元素（cur.next = null）
 */
public class RevList {

    public static Node revList(Node head){
        Node prev = null;
        Node cur = head;
        Node next = null;
        Node newHead = null;//到最后一个返回
        while (cur != null){
            if (cur.next == null){
                newHead = cur;
            }
            next = cur.next;
            cur.next = prev;//反转指向

            prev = cur;//往后进行偏移
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

        Node head = Node.buildListByArray(list);
        Node res = revList(head);
        System.out.println(res);

    }
}
