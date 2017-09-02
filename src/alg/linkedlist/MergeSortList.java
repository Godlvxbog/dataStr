package alg.linkedlist;

import java.util.ArrayList;

/**
 * 合并的两个有序的链表
 *
 * 合并的注意：
 *
 * 循环条件是
 * while(cur1 != null && cur2 != null): 所以退出条件是任意一个到达尾部
 *
 *
 */
public class MergeSortList {

    public static Node merge(Node node1, Node node2){
        Node dummy = new Node(0);
        Node cur = dummy;//作为新的链表的循环变量

        while (node1 != null && node2 != null){
            if (node1.data <=  node2.data){
                cur.next = node1;
                cur = node1;//始终为新链表的最后的节点

                node1 = node1.next;
            }else{
                cur.next = node2;
                cur = node2;
                node2 = node2.next;
            }
        }

        while (node1 != null ){
            cur.next = node1;
            cur = node1;
            node1 = node1.next;
        }
        if (node2 != null ){
            cur.next = node2;
            cur = node2;
            node2 = node2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(40);
        list.add(60);
        Node res1 = Node.buildListByArray(list);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(13);
        list2.add(30);
        list2.add(42);
        Node res2 = Node.buildListByArray(list2);

        Node node = merge(res1,res2);



    }
}
