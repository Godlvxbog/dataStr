package his_2018.sept.tree;

import his_2018.alg.tree.TNode;

/**
 * Created by xbog on 2017/9/6.
 * 中序遍历不带父亲指针的BST，找出下一个节点
 *
 * 下一个节点：
 *  - 如果是含有右孩子树，next就是右孩子树的最左边的
 *  - 如果没有有右孩子树，
 *      - 如果是在该节点是其父亲节点的左孩子树，那么父亲节点就是中序遍历的下一个节点
 *      - 如果  是右孩子树，往上遍历，直到某个节点 是其父亲节点的左孩子，那么该节点就是next
 *
 *
 */
public class InOrderNextNodeWithNoParent {



    /**
     * 当前节点的最左边的节点
     * @param node
     * @return
     */
    public static TNode leftestNode(TNode node ){
        if (node == null){
            return null;
        }

        while (node.left != null){
            node = node.left;
        }

        return node;
    }


    public static TNode inOrderBstNoParent(TNode root ,TNode node){
        if (node == null){
            return null;
        }

        //1如果右边孩子树存在，就是右边的最左边的节点
        if (node.right != null){
            return leftestNode(node.right);
        }

        //一定是比当前节点 大的集合中最小的那个
        TNode success =  null;
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
        TNode root = TNode.buildTree();
    }
}
