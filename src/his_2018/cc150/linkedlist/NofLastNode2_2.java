package linkedlist;

/**
 * 找出单项列表的倒数第K个节点：
 *
 * 思路：
 * 递归：
 * 链表从head开始，不断遍历（head.next）;外层函数一层一层进去直到 head=null,然后开始从内层遍历
 * 每层返回序号k
 */
public class NofLastNode2_2 {
    public static void main(String[] args) {
        Node n =new Node(1);
        StartOflinkedlist stnode=new StartOflinkedlist();
        for (int i=0;i<5;i++){
            stnode.createNode(n,i*2+3);
        }
        IntWrapper i=new IntWrapper();
//        nOfLastNode(n,3);
        noOflastNode4(n,2);
    }


    //这种方法没有返回该元素，只是打印出来了；
    //返回的是计数器，传递指针更新计数器
    //难点是：无法同时返回计数器和索引的值，
    public static int nOfLastNode(Node head,int k){
        if (head==null){
            return 0;
        }
        //把底层返回的i赋值给j，以上部分全是压栈，
        int j = nOfLastNode(head.next,k);
        //出栈：这里每层都有的参数有 head,k等,变量主要由压栈时候涉及到参数，可以在编译器中查看
        //下面是内层的循环体
        int i=j;//把返回值赋给i，i为计数器
        i++;
        if (i==k){
            System.out.println(head.data);
        }
        return i;//返回计数器

    }

    ///包装整数：此种解法有问题
//    public static Node nOfLastNode3(Node head,int k,IntWrapper i){
//        if (head==null){
//            return null;
//        }
//        //把底层返回的i赋值给j,更新遍历的节点
//        Node node = nOfLastNode3(head.next,k,i);
//
//        //更新计数器
//        i.value++;
//
//        if (i.value==k){
//            return head;//返回当前指针指向的节点
//        }
//        return node;//返回计数器
//
//    }


    //===========================================================
    //非递归方法：
//    思路:设置两个指针，快指针领先K步，当快到末尾时候，慢指针就是第k个元素


    public static Node noOflastNode4(Node head,int k){
        Node p1=head;
        Node p2=head;//两个指针分别指向两个链表的头
        //倒数最后一个为  ：倒数第一
        for (int i=1;i<k;i++){
            if (p2==null){
                return null;
            }

            p2=p2.next;//循环指针变量
        }
        if (p2==null){
            return null;
        }

        //现在已相同速度移动p1，p2
        //判断p2是不是最后一个节点
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;

    }








 static class IntWrapper{
    private int value=0;

}





}
