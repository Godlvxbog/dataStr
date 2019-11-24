package leetcode.linkedlist;

/**
 * 题目：237
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        if (node == null){
            return;
        }
        if (node.next ==null){
            //说明是最后一个节点
            node =null;
            return;
        }

        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
    }
}
