package his_2018.alg.linkedlist.reverse;

import his_2018.alg.linkedlist.Node;

import java.util.ArrayList;

/**
 * 反转一个区间的链表
 * from 2 - to 4
 *
 * 可能会涉及到换头节点问题，所以需要用dummy Node
 *
 * 这里的   1 <= m <= n <= length
 *
 * //先画图就好了，然后保存好指针指向时候的现场
 */
public class RevPartedList {

    public static Node rev(Node head, int m, int n){
        Node dummy = new Node(0);
        dummy.next = head;
        head = dummy;

        int k = m;
        Node cur = dummy;
        while (k > 1){
            cur = cur.next;
            k--;
        }
        Node leftLast = cur;

        Node mStart = null;

        Node mCur = cur.next;//第一个元素
        Node mLast = mCur;
        Node temp = null;

        int t = n-m +1;
        while (t > 0){
            Node next = mCur.next;

            temp = mCur;
            temp.next = mStart;
            mStart = temp;

            mCur = next;

            t--;
        }

        //交换完成之后

        mLast.next = mCur;
        leftLast.next = mStart;

        return  dummy.next;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Node res = Node.buildListByArray(list);

        Node node = rev(res,2,4);
    }
}
