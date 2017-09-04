package linkedlist;

/**
 * 题目大意：删除某节点，及其后面的节点，但是只能访问该节点，不知道head
 */
public class DeleteNodeNoHead2_3 {
    public static void main(String[] args) {

    }

    public static boolean deleteNode(Node node){
        //考虑边界：
        if (node==null || node.next==null){
            return false;
        }
        Node next=node.next;//，用next来管理next节点
        node.data=next.data;//复制节点。【知识点】
        node.next=next.next;//删除该节点 【知识点】
        return  true;
    }

}
