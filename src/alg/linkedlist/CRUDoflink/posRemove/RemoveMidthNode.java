package alg.linkedlist.CRUDoflink.posRemove;

import alg.linkedlist.Node;

/**
 * 移除中间节点
 * 思路：
 * 慢指针，走一步，快指针走两步
 *
 * 定位在中间节点的前一个节点
 */
public class RemoveMidthNode {

    public static Node removeMidNode(Node node){
        Node dummy = new Node(0);
        dummy.next = node;
        Node head = dummy;
        //如果为空或者只有一个节点，返回其头结点
        if (head.next == null || head.next.next == null){
            return head;
        }
        //一般情况下
        Node fast = head.next.next.next;
        Node slow = head.next;

        while (fast.next!= null && fast.next.next !=null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;//删除中间节点

        return dummy.next;

    }


    //方法二：1先算出链表的总的个数，取整，然后求得要删除的是第几个节点，，然后定位到此节点的前一个，做操作处理


    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.buildNode(node1,3);
        node1.buildNode(node1,4);
        node1.buildNode(node1,5);
        node1.buildNode(node1,100);

        removeMidNode(node1);

    }
}
