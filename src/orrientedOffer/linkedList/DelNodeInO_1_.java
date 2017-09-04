package orrientedOffer.linkedList;

import alg.linkedlist.Node;

/**
 * Created by Administrator on 2017/2/19.
 * 待删除的节点指针是可以知道的：
 *
 * 所以直接复制后面节点覆盖到待删除的节点，并删除即可
 *
 * 尾部节点： node.next = null;
 *
 */
public class DelNodeInO_1_ {

    void delNodeIn1(Node head,Node target){
        Node dummy = new Node(0);
        dummy.next = head;

        //要删除的不是尾部节点
        if (target.next != null){
            Node nextOfT = target.next;
            target.next = nextOfT.next;
        }else{//是尾部节点
            Node node = head;
            while (node.next.next != null){//定位到尾部节点
                node = node.next;
            }
            node.next = null;
        }
    }


    public static void main(String[] args) {

    }

}
