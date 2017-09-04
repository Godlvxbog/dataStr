package orrientedOffer.linkedList;

import alg.linkedlist.Node;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/19.
 * 给你两个链表，
 */
public class MergeSortList {

    public static Node mergeSortList(Node head1, Node head2){
        Node resultNode  = new Node(0);
        Node cur = resultNode;
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }

        while (head1 != null && head2 != null){
            if (head1.data < head2.data){
                cur.next = head1;

                head1 = head1.next;
                cur = cur.next;
            }else{
                cur.next = head2;

                head2 = head2.next;
                cur = cur.next;
            }
        }

        while (head1 != null){
            cur.next = head1;
            head1 = head1.next;
        }

        while (head2 != null){
            cur.next = head2;
            head2 = head2.next;
        }

        return resultNode.next;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Node head1 = Node.buildListByArray(list);


        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(12);
        list2.add(24);
        list2.add(27);
        list2.add(39);
        list2.add(55);

        Node head2 = Node.buildListByArray(list2);


       Node res = mergeSortList(head1,head2);
        System.out.println(res);

    }
}
