package linkedlist;

/**
 * 要求：两个链表表示整数：各位排在首位，求两个链表表示的整数和
 * 思路：递归：
 *      递归的参数改变为  n1 --->n1.next  n2--->n2.next  ,carry=(1 或者 0)；
 *      进栈要做的事情：计算每一位 用result保存；
 *      返回：每层的计算结果resultBit
 *      终止条件：n1==null && n2==null && carry=0;
 *      出栈要做的事情： 把每层的resultBit插入到result的末尾；
 */
public class AddInLinked2_5 {
    public static void main(String[] args) {
        Node n1=new Node(7);
        n1.appendToTail(new Node(1)).appendToTail(new Node(6));
        Node n2=new Node(5);
        n2.appendToTail(new Node(9)).appendToTail(new Node(2));

        addlist(n1,n2,0);
    }

    public static Node addlist(Node n1,Node n2,int carry){

        Node result=new Node();//保存结果的链表
        int temp=carry;//位于位之间的加和临时值

        //==============递归的结束点,最后一个节点返回的是null
        if (n1 ==null && n2==null && carry==0){
            return null;
        }
        //====================用递归压栈的函数体：计算result===========
        if (n1 !=null){
            temp+=n1.data;
        }
        if (n2 !=null){
            temp +=n2.data;
        }
        result.data=temp%10;

        //========================参数的改变
        carry= temp >=10 ? 1:0;
        n1= n1 !=null ? n1.next :null;
        n2= n2 !=null ? n2.next :null;
        //======================循环函数，返回的是，每层的计算结果
        Node resultBit = addlist(n1, n2, carry);

        //===================出栈的函数体：把结果位添加到结果链表中

        result.appendToTail(resultBit);

        return  result;

    }
}
