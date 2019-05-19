package his_2018.alg.linkedlist.CRUDoflink.valsRemove;

import his_2018.alg.linkedlist.Node;

/**
 * 删除指定的值
 */
public class RemoveValueNode {

    public static Node removeValue(Node head , int data){
        Node dummy = new Node(0);
        dummy.next = head;
        head = dummy;

        Node pre = head;
        Node cur = head.next;

        while (cur != null){
            if (cur.data == data ){
                pre.next = cur.next;//删除
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.buildNode(node1,3);
        node1.buildNode(node1,4);
        node1.buildNode(node1,5);
        node1.buildNode(node1,100);

        Node result = removeValue(node1,1);
    }
}
