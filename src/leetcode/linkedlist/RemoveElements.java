package leetcode.linkedlist;

/**
 * 203:题目  虚拟头结点
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {


    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null) {
            if (cur.next.val == val){
                //删除
                ListNode next = cur.next;
                cur.next = next.next;

            }else {
                cur = cur.next;//遍历更新指针。
            }
        }

        return dummyHead.next;
    }
}
