package alg.linkedlist.CRUDoflink.valsRemove;

import alg.linkedlist.Node;

import java.util.HashSet;

/**
 * 移除无序单链表中重复的值：
 *
 * 思路，如果是有序的话，那么重复的数字一定是挨在一起的，所以可以用两个指针进行删除
 * 无序就不这样了，用HashSet表来保存，链表中节点是否存在了，如果已经存在了，就删除
 *
 * 是否包含用HashSet.contains()函数
 * 如果不在，就加入到HashSet表中间
 * 常见的HashSet方法有  .add(); .contains(); .isempty(); .remove(); .size();等
 */
public class RemoveDups {

    public static Node removeDups(Node head){
        HashSet<Integer > set = new HashSet<Integer>();
        Node pre  = head;
        Node cur = head.next;
        set.add(pre.data);
        while (cur != null){
            if (set.contains(cur.data)){
                pre.next = cur.next;//删除cur的节点
                cur= cur.next;
            }else{
                set.add(cur.data);//不包含就放进去
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.buildNode(node1,3);
        node1.buildNode(node1,3);
        node1.buildNode(node1,5);
        node1.buildNode(node1,5);
        node1.buildNode(node1,6);
        Node res = removeDups(node1);
    }
}
