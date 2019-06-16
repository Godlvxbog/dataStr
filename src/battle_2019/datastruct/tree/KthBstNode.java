package battle_2019.datastruct.tree;

import battle_2019.datastruct.TreeNode;

public class KthBstNode {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode.insert(root,3);
        TreeNode.insert(root,7);
        TreeNode.insert(root,2);
        TreeNode.insert(root,4);
//        insert(root,40);
        TreeNode.insert(root,6);
        TreeNode.insert(root,8);

        TreeNode node = kthNode(root,6);
        System.out.println(node);
    }


    public static Integer index =0;

    /**
     * 递归的写法：还是没搞懂，中序遍历，只要有一个叶子节点是null就加一，否则返回当前root
     * @param root
     * @param k
     * @return
     */
    public static TreeNode kthNode(TreeNode root,int k){
        if (root ==null){
            return null;
        }
        //中序遍历
        TreeNode target = null;
        target = kthNode(root.left,k);

        if (target != null){
            return target;
        }else {
            index++;
        }
        //找到了第k大的节点
        if (index == k){
            return root;
        }

        target = kthNode(root.right,k);
        if (target != null){
            return target;
        }else {
            return null;
        }
    }
}
