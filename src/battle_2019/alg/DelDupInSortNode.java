package battle_2019.alg;

import battle_2019.datastruct.MyNode;

import java.util.ArrayList;

/**
 * 删除链表中的重复节点，该链表已经是有序的了。
 * 需要考虑第一个就是重复的节点:采用虚拟节点模拟
 * 最后的是重复节点等特殊场景：
 */
public class DelDupInSortNode {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(30);
        list.add(30);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(50);
        list.add(50);
        list.add(50);
        list.add(50);
        MyNode node = MyNode.buildNodesFromArray(list);
        MyNode res = delNode2(node);
        System.out.println(res);
    }

    public static MyNode delNode(MyNode node) {
        MyNode pre = node;
        MyNode cur = pre.next;
        MyNode next = cur.next;

        while (cur != null) {
            //设置一个标志为判断是否要删除。
            boolean isDel = false;
            if (next != null && cur.data == next.data){
                isDel =true;
            }

            if (!isDel){
                pre= pre.next;
                cur = cur.next;
                next = next.next;
            }else {
                //相等
                int data = cur.data;
                MyNode tobeDel = cur;
                while (tobeDel != null && data == tobeDel.data){
                    tobeDel = tobeDel.next;
                    cur = cur.next;
                    if (next != null){ //关注最后一个节点。
                        next = next.next;
                    }

                }
                pre.next = next;
            }
        }
        return node;
    }

    /**
     * 保留其中一个元素，则找到相同元素是否，pre先往前移动一个，保留该元素。
     * @param node
     * @return
     */
    public static MyNode delNode2(MyNode node) {
        MyNode pre = node;
        MyNode cur = pre.next;
        MyNode next = cur.next;

        while (cur != null) {
            //设置一个标志为判断是否要删除。
            boolean isDel = false;
            if (next != null && cur.data == next.data){
                isDel =true;
            }

            if (!isDel){
                pre= pre.next;
                cur = cur.next;
                if (next != null){
                    next = next.next;
                }
            }else {
                //相等
                int data = cur.data;
                pre = pre.next;
                while (cur != null && data == cur.data){
                    cur = cur.next;
                    if (next != null){ //关注最后一个节点。
                        next = next.next;
                    }

                }
                pre.next = cur;
            }
        }
        return node;
    }

}
