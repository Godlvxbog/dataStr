package leetcode.linkedlist;


/**
 * 题目：24
 *  https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (pre.next != null && pre.next.next != null ){
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            //操作指针
            node2.next = node1;
            node1.next = next;
            pre.next  = node2;

            pre  = node1;//更新循环变量
        }

        return dummyHead.next;

    }

}
