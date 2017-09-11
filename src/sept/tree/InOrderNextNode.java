package sept.tree;

/**
 * Created by xbog on 2017/9/6.
 * 中序遍历不带父亲指针的BST，找出下一个节点
 *
 * 下一个节点：
 *  - 如果是含有右孩子树，next就是右孩子树的最左边的
 *  - 如果没有有右孩子树，
 *      - 如果是在该节点是其父亲节点的左孩子树，那么父亲节点就是中序遍历的下一个节点
 *      - 如果  是右孩子树，往上遍历，直到某个节点 是其父亲节点的左孩子，那么该节点就是next
 */
public class InOrderNextNode {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        TreeNode parent;
    }

    /**
     * 判断当前接单是否是其父亲节点的左孩子
     * @param node
     * @param parent
     * @return
     */
    public static boolean isLeft(TreeNode node ,TreeNode parent){
        if (node.parent == parent){
            return true;
        }
        return false;
    }

    /**
     * 当前节点的最左边的节点
     * @param node
     * @return
     */
    public static TreeNode leftestNode(TreeNode node ){
        if (node == null){
            return null;
        }

        while (node.left != null){
            node = node.left;
        }

        return node;
    }

    /**
     * 如果含有父亲节点
     * @param root
     * @param node
     * @return
     */
    public static TreeNode inOrderNext(TreeNode root ,TreeNode node){
        if (node == null){
            return null;
        }

        //1如果右边孩子树存在，就是右边的最左边的节点
        if (node.right != null){
            return leftestNode(node.right);
        }

        //2 右边不存在，
        TreeNode parent = node.parent;
        //找到第一个当前节点 是其父亲节点 的左孩子节点的
        while (parent != null && !isLeft(node,parent)){
            node = parent;//往上遍历
            parent = node.parent;

        }

        return parent;

    }

    public static TreeNode inOrderBstNoParent(TreeNode root ,TreeNode node){
        if (node == null){
            return null;
        }

        //1如果右边孩子树存在，就是右边的最左边的节点
        if (node.right != null){
            return leftestNode(node.right);
        }

        //在bst中找到当前节点的下一个节点,找到当前节点的父亲节点
        //并且由于，没有右边孩子，所以第一个节点必定是
        TreeNode success =  null;
        while (root != null){
            if (node.data < root.data){//node 较小 ：当前节点父亲节点一定是root的左边
                success= root;
                root = root.left;
            }else {
                root = root.right;//node 较大 ：当前节点父亲节点一定是root的右边
            }
        }
        return success;
    }


    public static void main(String[] args) {

    }
}
