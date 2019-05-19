package linkedlist;

/**
 * 链表在java中的基本操作：
 * 用一个以类表示：
 * 属性是下一个指针（类型是本类Node）
 */
public class StartOflinkedlist {
    public static void main(String[] args) {
        Node n =new Node(1);
        for (int i=0;i<10;i++){

            createNode(n,i*2+3);
        }
        deleteNode(n,3);
        deleteNode(n,13);

    }
    public static Node createNode(Node node ,int d){
        node.appendToTail(new Node(d));
        return node;
    }

    public static Node deleteNode(Node node,int d){
        node.deleteNode(d);
        return node;
    }








}


