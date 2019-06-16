package battle_2019.alg;

import battle_2019.datastruct.MyNode;

import java.util.ArrayList;

/**
 * 【剑指Offer ：17】
 * 合并两个有序的链表
 */
public class MergeSortNode {
    public static void main(String[] args) {
        MyNode node1 = MyNode.initNode();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(11);
        list.add(18);
        list.add(39);
        list.add(59);
        MyNode node2 = MyNode.buildNodesFromArray(list);
        MyNode head = merge(node1,node2);
        System.out.println(head);
    }

    public static MyNode merge(MyNode node1, MyNode node2) {
        MyNode cur1 = node1;
        MyNode cur2 = node2;
        MyNode newHead = new MyNode(-1);
        MyNode cur3= newHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.data <= cur2.data) {
                cur3.next = cur1;
                cur3 = cur3.next;
                cur1 = cur1.next;
            } else {
                cur3.next = cur2;
                cur3 = cur3.next;

                cur2 = cur2.next;
            }
        }

        while (cur1 != null) {
            cur3.next =cur1;
            cur3 = cur3.next;

            cur1 = cur1.next;
        }
        while (cur2 != null) {
            cur3.next =cur2;
            cur3 = cur3.next;

            cur2 =  cur2.next;
        }
        return newHead;

    }


}
