package alg.linkedlist.CRUDoflink.posRemove;

import alg.linkedlist.Node;

/**
 *只能访问某节点，需要把他删除；
 *
 * 常规的删除是需要得到该节点的前一个节点，
 *
 * 思路是，把，下一个节点复制到当前节点，并删除下一个节点
 */
public class RemoveNodeButNotAcessHead {

    public static Node removeNode(Node head, Node node){
        Node next = node.next;//下一个元素
        if (next == null){
            throw new RuntimeException("不能删除最后一个节点");
        }
        node.data = next.data;
        node.next = next.next;//删除
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.buildNode(node1,3);
        node1.buildNode(node1,4);
        node1.buildNode(node1,5);
        node1.buildNode(node1,100);
    }
}
