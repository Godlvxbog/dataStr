package alg.linkedlist;

/**
 * 打印两个有序链表的公共节点：有序这里很关键
 * 只有有序，那么，只要小的节点往后移动就可以减小两者的差距
 *
 * 循环条件：两个链表都不为空；
 *      1，每个链表各一个指针，小的往后移动；
 *      2，如果两者相同，就打印
 *      3，如果某一个到达了尾部，就跳出循环
 */
public class CommonNode {

    public static void printCommonNode(Node head1,Node head2){
        while (head1 !=null && head2 !=null){
            if (head1.data <head2.data){
                head1 = head1.next;
            }else if (head2.data < head1.data){
                head2 = head2.next;
            }else if (head1.data == head2.data){
                System.out.println(head1.data);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.buildNode(node1,3);
        node1.buildNode(node1,4);
        node1.buildNode(node1,5);
        node1.buildNode(node1,100);

        Node node2 = new Node(2);
        node2.buildNode(node2,3);
        node2.buildNode(node2,4);
        node2.buildNode(node2,5);
        node2.buildNode(node2,101);


        printCommonNode(node1,node2);
    }
}
