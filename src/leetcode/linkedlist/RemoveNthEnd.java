package leetcode.linkedlist;


/**
 * 题目：19
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 双指针 ： p指向待删除的节点的前一个节点。
 * 同时移动两个双指针，只遍历一次。
 */
public class RemoveNthEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        assert  n>=0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        while (n >= 0){
            assert  p != null;
            p = p.next;
            n--;
        }

        while (p != null){
            p =p.next;
            q =q.next;
        }

        q.next = q.next.next;

        return dummyHead.next;
    }
}
