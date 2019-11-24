package his_2018.alg.linkedlist;

import java.util.ArrayList;

/**
 * 链表的节点
 */
public class Node {
    public  int data;
    public Node next;
    public Node(int data){
        this.data = data;
    }


    public Node buildNode(Node node,int data){
        if (node == null){
            node = new Node(data);
            return node;
        }

        Node head = node;
        while (node.next != null){
            node = node.next;
        }
        node.next = new Node(data);

        return head;
    }

    public static Node buildDefaultListByArray(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Node res = buildListByArray(list);
        printLinkedList(res);
        return res;
    }

    public static Node buildListByArray(ArrayList<Integer> list){
        Node dummy = new Node(0);
        Node cur = dummy;
        for (int i = 0; i< list.size() ; i++){
            Node temp = new Node(list.get(i));
            cur.next = temp;
            cur = temp;//更新当前cur为下一个。

        }
        return dummy.next;
    }

    public static void printLinkedList(Node node){
        Node cur = node;
        while (cur != null){
            System.out.print(cur.data + "->");
            cur = cur.next;//指向下一个元素。
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

    }

}
