package linkedlist;

import java.util.Hashtable;

/**
 * 题目要求：删除未排序的链表中的重复节点：
 * 思路：重复节点，设置一个hashtable，如果包含此节点的key就删除
 *
 * 知识点：学会遍历节点，找到节点，删除节点（设置previous指针），
 *
 * 这里的node是循环指针变量，pre则是循环变量的另外一个指针，在node之前
 *
 * 分析：
 * 时间复杂度为O(N)
 *
 */
public class RemoveDupNode2_1 {
    public static void main(String[] args) {
        Node n =new Node(1);
        StartOflinkedlist stnode=new StartOflinkedlist();
        for (int i=0;i<10;i++){
            stnode.createNode(n,i*2+3);
        }
        stnode.createNode(n,3);
        stnode.createNode(n,5);

//        removeDups(n);
        deleteDups2(n);
    }

    public static Node removeDups(Node node){
        Node previous=null;//始终比循环指针变量要慢一个节点位置
        Node head=node;

        Hashtable table=new Hashtable();
        while(node!=null){
            if (!table.containsKey(node.data)){
                table.put(node.data,true);
                previous=node;//移动previous，指向当前节点，准备下一场遍历 ，所以pre在判断下一个节点是否是重复时候，始终是落后一个的
            }else{
                previous.next=previous.next.next;
            }


            node=node.next;
        }
        return head;
    }
    //=============================================
//    进阶：
//         1 不得使用缓冲区：典型空间换时间，定一个指针，移动另外一个指针来遍历，如果找到了就操作。
//         2，空间换时间，也就是你设置一个hashmap，来记录，使得一一映射，减少了定一个指针来遍历权利的N

//    思路：设置两个指针 ，对于每个current,都遍历【current,末尾】，这个其实类似于  i，j的双重遍历
//    注意：这里的runner（凡是要删除，就要走到指针变量的的前一个）
//    时间O(n*n),空间为O(1)

    public static Node deleteDups2(Node node){
        Node head=node;
        Node current=node,runner;
        //下面开始遍历
        while(current!=null){
            runner=current.next;//内侧的指针类似于j
            Node pre=null;
            while(runner!=null){
                if (current.data ==runner.data){
                    pre.next=runner.next;
                }
                pre=runner;
                runner=runner.next;
            }


            current=current.next;
        }

        return head;
    }


}



