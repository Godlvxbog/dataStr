package linkedlist;

/**
 * Created by Administrator on 2016/11/11.
 */
public class Node {
    public int data;
    public Node next=null;//链接下一个Node的地址
    public Node(){

    }


    public Node(Object d){
        this.data=(Integer) d;//构造类型
    }

    public Node(int d){
        this.data=d;//构造类型
    }

    //================================================
    //当前尾部添加
    public Node appendToTail(Node  end){

        Node node=this;//当前节点头节点的地址 用node指针指向
        while (node.next!=null){
            node=node.next;//不断遍历知道末尾
        }
        node.next=end;//此时node已经到末尾了；然后添加end
        return end;
    }

    //=================================================
    //删除Node
    Node deleteNode(int d){
        Node node=this;//node指针指向head
        if (d==node.data){//要删除的是头节点
            return node.next;
        }
        //如果不是头结点，你需要遍历到d==node.data

        while(node.next!=null){
            //如果下一个指针就是d，prev就是当前节点
            if (node.next.data==d){
                node.next=node.next.next;
                return this;//返回头指针
            }
            //循环移动指针
            node=node.next;
        }
//        如果没有的话,就直接返回head
        return this;
    }

}


//技巧：快行指针
