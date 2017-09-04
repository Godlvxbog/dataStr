package linkedlist;

import java.util.Stack;

/**
 * 判断一个链表是不是回文
 * ：思路1：用栈实现，快指针，定位到链表的中间，时候，并把慢指针给压栈，然后慢指针继续走，与栈的top元素时候相同来比较
 *
 *
 * 思路2：用递归；
 * 传入的参数改变：head.next,length;
 * 返回参数res：包裹两个数据 ishui(head.data与上一层返回的res.node.data是否相同)，node
 *
 */
public class IsHuiWenLinked {
    public static void main(String[] args) {
        Node n =new Node(0);
        n.appendToTail(new Node(1));
        n.appendToTail(new Node(2));
        n.appendToTail(new Node(3));
        n.appendToTail(new Node(2));
        n.appendToTail(new Node(1));
        n.appendToTail(new Node(0));

        System.out.println( isHui(n));
        System.out.println(ishui2(n));

    }

    //用栈实现
    public static boolean isHui(Node head){
        //1、设置快指针用来，定位，慢指针用来与前面压栈的数据进行比较
        Node fast=head;
        Node slow=head;
        Stack<Integer> stack=new Stack<Integer>();

        //2、定位开始，并压栈 fast可能到最后一个节点，也可能已经到头了
        while(fast !=null && fast.next !=null){
            stack.push(slow.data);

            slow=slow.next;
            fast=fast.next.next;
        }

        //3、如果是奇数，slow需要跳过中间的
        if (fast !=null){
            slow=slow.next;
        }

        //4、出栈与slow指针相比较时候相同
        while(slow!=null){
            int top=stack.pop().intValue();
            if (top !=slow.data){
                return false;
            }
            slow=slow.next;
        }
        return true;//所有节点都已经遍历并比较完成了；
    }

    //用递归实现===类比于stack
//     每一层的head，就是stack.top()
//    return res就是原慢指针的元素，此元素与stack.top()确定是否是回文

    public static Result digui2(Node head,int length){
        //错误检查
//        压栈
        if (head==null || length==0){
            return null;
        }else if (length==1){
            //到底之一
            return new Result(head.next,true);//跳到中间的值
        }else if (length==2){
            return new Result(head.next.next,true);//跳过中间的2个字
        }

        Result res= digui2(head.next,length-2);
//        出栈
        if (res.resNode==null || res.ishui==false){//后半段已经到底，或者中间不相等
            return res;
        }else{

            res.ishui=(res.resNode.data==head.data);//比较栈顶元素head与后半段是否相同

            res.resNode= res.resNode.next;//遍历后半段，
            return res;
        }

    }
    public static boolean ishui2(Node head){
        Result p=digui2(head,7);
        return  p.ishui;
    }


}


class Result{
    Node resNode;
    boolean ishui=true;
    public Result(Node node,boolean ishui){
        this.resNode=node;
        this.ishui=ishui;
    }

}
