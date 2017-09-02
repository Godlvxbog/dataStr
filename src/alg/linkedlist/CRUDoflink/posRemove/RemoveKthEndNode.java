package alg.linkedlist.CRUDoflink.posRemove;

import alg.linkedlist.Node;

/**
 * 凡是可能删除head的话，就设置一个dummyNode
 * 凡是数字，你应该思考其边界值，
 * 凡是链表，数组等，就要思考为空，或者长度大于表的长度
 */
public class RemoveKthEndNode {

    public static Node removeKthEndNode(Node node ,int k){
        Node dummy = new Node(0);
        dummy.next = node;
        Node head = dummy;//设置头节点

        Node fast = head;//快指针用于辅助定位
        Node slow = head;//慢指针用于定位到要删除点的前一个点

        while (k > 0){
            fast = fast.next;
            k--;
        }
        while (fast.next !=null ){//退出循环就是要删除节点的前一个节点
            fast = fast.next;
            slow  =slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.buildNode(node1,3);
        node1.buildNode(node1,4);
        node1.buildNode(node1,5);
        node1.buildNode(node1,100);

        removeKthEndNode(node1,2);
    }
}
