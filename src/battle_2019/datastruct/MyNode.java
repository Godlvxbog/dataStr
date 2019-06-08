package battle_2019.datastruct;

import java.util.ArrayList;

/**
 * 链表：用头结点去表达，传入的是头结点
 * 判空：node ！= null，
 * 判尾：node.next != null
 * 指向某个节点： node.next = temp
 * j++指针的移动：node = node.next
 * 删除 ： node.next  = node.next.next
 */
public class MyNode {
    public int data;
    public MyNode next;

    public MyNode(int data) {
        this.data = data;
    }

    /**
     * 插入单个元素到链表的尾部
     * @param node
     * @param data
     * @return
     */
    public static MyNode addNodeToTail(MyNode node, int data ){
        if (node == null){
            return new MyNode(data);
        }
        MyNode head = node;
        while (node.next != null){
            node= node.next;
        }
        node.next = new MyNode(data);
        return head;
    }


    public static MyNode buildNodesFromArray(ArrayList<Integer> nums){
        MyNode dummy = new MyNode(0);
        MyNode cur = dummy;
        for (Integer num : nums){
            MyNode temp = new MyNode(num);
            cur.next = temp;//指针链接到下一个节点

            cur = cur.next;//j++
        }
        return dummy;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        MyNode myNode = buildNodesFromArray(list);
        MyNode res2 = addNodeToTail(myNode,100);
        MyNode res3  = delNode(res2,30);
        System.out.println(res3);
    }

    public static MyNode delNode(MyNode node, Integer num){
        if (node == null){
            return node;
        }
        MyNode head = node;
        while (node.next != null && node.next.data != num ){
            node = node.next;
        }
        node.next = node.next.next;
        return  head;

    }

    public static MyNode initNode(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        MyNode myNode = buildNodesFromArray(list);
        return addNodeToTail(myNode,100);
    }



}
