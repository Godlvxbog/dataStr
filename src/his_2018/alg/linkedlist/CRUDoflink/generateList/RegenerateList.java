package his_2018.alg.linkedlist.CRUDoflink.generateList;

import his_2018.alg.linkedlist.Node;

/**
 * 题目要求:
 * 需要把链表依照  value 来分成左中右三段，并合并成一个链表
 */
public class RegenerateList {

    public static Node RePartList(Node head, int value){
        //分成上个链表
        Node dummyLeft = new Node(0);
        Node dummyMid = new Node(0);
        Node dummyRight = new Node(0);

        //三个链表的为指针pLeft,
        Node pLeft = dummyLeft;
        Node pMid = dummyMid;
        Node pRight = dummyRight;

        Node cur = head;//循环变量
        while (cur != null ){
            if (cur.data < value){
                pLeft.next = cur;
                pLeft = cur;
            }else if (cur.data == value){
                pMid.next = cur;
                pMid = cur;
            }else {
                pRight.next = cur;
                pRight = cur;
            }
            cur = cur.next;
        }

        //合并三个子链表

        pLeft.next = dummyMid.next;
        pMid.next = dummyRight.next;
        pRight.next = null;

        return dummyLeft.next;

    }

    public static void main(String[] args) {

        Node node1 = new Node(100);
        Node head = node1;
        node1.buildNode(node1,90);
        node1.buildNode(node1,80);
        node1.buildNode(node1,40);
        node1.buildNode(node1,50);

        node1.buildNode(node1,30);
        node1.buildNode(node1,20);
        node1.buildNode(node1,40);



        Node res = RePartList(head,40);
    }
}
