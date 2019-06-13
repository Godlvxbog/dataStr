package battle_2019.datastruct.tree;

import battle_2019.datastruct.TreeNode;

/**
 * 镜像树：先序遍历，先序做交换，不需要返回。
 */
public class MirrorTree {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree();
        mirror(treeNode);
        System.out.printf("1");

    }

    public static void mirror(TreeNode treeNode){
        if (treeNode == null){
            return ;
        }

        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right =temp;

        if (treeNode.left != null){
            mirror(treeNode.left);
        }
        if (treeNode.right != null){
            mirror(treeNode.right);
        }
        return  ;

    }
}
