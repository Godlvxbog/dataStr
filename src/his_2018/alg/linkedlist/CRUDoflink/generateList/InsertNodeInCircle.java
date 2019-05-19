package his_2018.alg.linkedlist.CRUDoflink.generateList;

import his_2018.alg.linkedlist.Node;

/**
 * 在一个递增的环形链表中添加一个元素，使得其依然有序环形。
 * 思路：
 * 设置两个指针：同步移动，比较新的值与此两个值的大小，决定是否插入
 */
public class InsertNodeInCircle {

    public static Node insertNodeInCicle(Node head , int num){
        Node node = new Node(num);
        if (head == null){
            node.next = node;//指向了他自己
            return node;
        }

        Node pre = head;
        Node cur = head.next;

        while (cur != head){//循环结束
            if (pre.data <= num && cur.data >= num){
                break;//结束循环
            }
            pre = pre.next;
            cur = cur.next;
        }

        node.next= cur;
        pre.next = node;

        if (node.data <= head.data){
            return node;
        }
        return head;

    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node head = node1;
        node1.buildNode(node1,30);
        node1.buildNode(node1,40);
        node1.buildNode(node1,50);
        node1.buildNode(node1,100);

        while (node1.next != null){
            node1 = node1.next;
        }
        node1.next = head;

        Node result = insertNodeInCicle(head,200);
    }
}
