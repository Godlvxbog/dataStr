package linkedlist;

/**
 * 题意：以x为定值，将链表分割成两部分，所有小于x的节点放在左边，大于等于的放在右边
 * 思路：
 * 创建两个链表，一个小于x，一个大于x，
 * 迭代范文整个链表，将元素插入到before，或者after两个链表中
 */
public class Split2Linkedlist2_4 {
    public static void main(String[] args) {
        Node n =new Node(7);
        n.appendToTail(new Node(4));
        n.appendToTail(new Node(6));
        n.appendToTail(new Node(14));
        n.appendToTail(new Node(9));
        n.appendToTail(new Node(7));
        split2list2(n,8);

    }

    public static Node split2list(Node node,int x){
        //创建两个链表
        Node leftSt=null;
        Node leftEd=null;
        Node righrSt=null;
        Node righrEd=null;

//        开始遍历
        while(node!=null){
            if (node.data <x){
                //将节点插入left链表中
                //如果left没有元素，头结点
                if (leftSt==null){
                    leftSt=node;
                    leftEd=leftSt;
                }
                else{
                    leftEd.next=node;//后插入
                    leftEd=node;//循环变量移动

                }


            }else{
                if (righrSt==null){
                    righrSt=node;
                    righrEd=righrSt;
                }else{
                    righrEd.next=node;
                    righrEd=node;//以便于下一个节点的插入
                }
            }
            node=node.next;//循环指针，指向下一个，node，相当于 i=i+1; 区别于node.next=XXX
        }

        //下面开始合并
        leftEd.next=righrSt;
        return leftSt;

    }

    //以上追踪两个链表却要四个指针，end是为了不断的从尾部插入，start，是为了连接两个节点

    //下面只用两个指针，插入方式是从前面插入，和上面做比较

    public static Node split2list2(Node node ,int x){
        Node leftSt=null;
        Node rightSt=null;

        //分割链表
        while(node!=null){
            Node next=node.next;//保存node的下一个元素的指针，后面对node.next做修改会做修改
            if ( node.data < x){
                node.next=leftSt; //前插入
                leftSt=node;//左链表的循环指针变量，进行更新
            }else{
                node.next=rightSt;
                rightSt=node;
            }
            node=next;
        }


        //合并链表，定位到左边链表的最后一个元素  leftSt.next!=null
        while(leftSt.next!=null){
            leftSt=leftSt.next;//遍历到结尾时候跳出
        }

        //由于左边要连接，所以需要判断
        if (leftSt==null){
            return rightSt;
        }


        leftSt.next=rightSt;//连接
        return leftSt;



    }


}
