package his_2018.orrientedOffer.linkedList;

import his_2018.alg.linkedlist.Node;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/2/19.
 *
 * 两个链表相交只能是Y型号的，因为一个节点只有一个next，所以不能为X型号的
 *
 * 1，两层循环 O（M*N）：凡是N方的需要思考用空间换时间：Hash，Stack等
 * 2,从后往前，用两个辅助的栈: 空间辅助（M+ N）时间也是
 * 3，快指针，慢指针，快指针先走K步，然后一起走，第一个相同的节点就是交点：无辅助空间
 *
 *
 */
public class CommonNode {

    /**
     * 用栈作为从后往前
     * @param head1
     * @param head2
     * @return
     */
    public static Node getComnNode(Node head1, Node head2){
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();

        while (head1 != null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null){
            stack2.push(head2);
            head2 = head2.next;
        }
        Node result = null;

        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if (stack1.peek() == stack2.peek()){
                result = stack1.pop();
                stack2.pop();
            }else{
                break;
            }

        }
        return result;


    }


    static class CommonNode1{

        public  int  getLength(Node head){
            int length = 0;
            while (head != null){
                length++;
                head = head.next;
            }
            return length;
        }

        public Node comNode(Node head1, Node head2){
            int length1 = getLength(head1);
            int length2 = getLength(head2);

            int k =length1 - length2;
            Node fast = null;
            Node slow = null;
            if (k >=0){
                fast = head1;
                slow = head2;
            }else{
                fast = head2;
                slow = head1;
                k = Math.abs(k);
            }

            while (k>0){
                fast = fast.next;
                k--;
            }

            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }

            return fast;

        }


    }



    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);

        Node head = Node.buildListByArray(list);


        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(15);
        list2.add(32);
        list2.add(33);
        Node head2 = Node.buildListByArray(list2);

        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(150);
        list3.add(320);
        list3.add(330);
        Node head3 = Node.buildListByArray(list3);

        Node cur1 = head;
        Node cur2 = head2;
        while (cur1.next != null){
            cur1 = cur1.next;
        }
        cur1.next = head3;

        while (cur2.next != null){
            cur2 = cur2.next;
        }
        cur2.next = head3;


//        Node res = getComnNode(head,head2);

        CommonNode1 commonNode1 = new CommonNode1();
        Node res =commonNode1.comNode(head,head2);

        System.out.println(res);


    }
}
