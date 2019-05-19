package linkedlist;

/**
 * 给定一个有环链表，实现一个算法，返回环路的开头的节点
 *
 * 步骤：
 * 设置快指针和慢指针， 找到coll的点；
 * 慢指针到头部，快慢同速
 *
 * 运用：检测两个链表是否存在回路  演变而来的
 *
 *
 */
public class FindLoopSt2_6 {

    public static void main(String[] args) {

    }

    public static Node findLoopstart(Node head){
        //1、设置快指针，慢指针
        Node fast=head;
        Node slow=head;

        //2、找出col的点
        while(fast !=null && slow!=null){
            slow=slow.next;//指针遍历
            fast=fast.next.next;
            if (fast == slow){
                break;
            }
        }

        //* 错误检查，如果没有环路，也就没有了碰撞处
        if (fast==null || slow==null){
            return null;
        }


        //3、同速度，slow-->head
        slow=head;
        while (slow !=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;//此时两者都指向环路的起点

    }

}
