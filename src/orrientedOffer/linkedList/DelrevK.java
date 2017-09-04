package orrientedOffer.linkedList;

import alg.linkedlist.Node;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/19.
 * 这里需要注意的是代码的鲁棒性：
 *
 *
 * 如果删除的是第五个了（头结点了）
 * 1，如果链表为空
 * 2,K值过大，大于其长度
 */
public class DelrevK {

    public static Node delrevKth(Node head,int k){
        if (head == null || k ==0){
            return null;
        }

        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;
        while (k > 0){
            if (fast.next != null){//判断不要越界了
                fast = fast.next;
                k--;
            }else{
                return null;
            }

        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Node head = Node.buildListByArray(list);

        Node res = delrevKth(head,5);
        System.out.println(res);
    }
}
