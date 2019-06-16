package battle_2019.datastruct.tree;

import battle_2019.datastruct.TreeNode;

import static battle_2019.datastruct.TreeNode.insert;

/**
 * 【剑指Offer ：50】
 *
 *
 * 给你一棵树node，以及一棵树中的两个节点A,B，判断A,B两个节点的最近公共祖先的节点
 * <p>
 * 思路一：从上往下先序遍历，
 * 判断A在该接待的子树中吗？
 * 判断B在该接待的子树中吗？
 * 如果在两个都在子树种继续往下遍历，两个都不在则不遍历，两个分别在左右两个子树中则返回当前节点。
 *
 * https://www.jianshu.com/p/f3d2e995fd06 :画图
 * <p>
 * 思路二：
 * 记录A到根节点，B到节点，两个链表。求AB两条链表的公共节点。
 */
public class LatestAncester {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(100);
        insert(root, 50);
        insert(root, 200);
        insert(root, 60);
        insert(root, 30);
        insert(root, 40);
        insert(root, 300);
        insert(root, 150);
        System.out.println(root);

        TreeNode node = lastestAnster(root, 40, 60);
        System.out.println(node);


    }


    public static boolean isInnodes(TreeNode root, Integer data1,Integer data2){
        return isInNode(root,data1) || isInNode(root,data2);
    }

    /**
     * 判断当前节点是不是在一棵树上。
     */
    public static boolean isInNode(TreeNode root, Integer data1) {
        if (root == null) {
            return false;
        }
        if (root.data == data1 ) {
            return true;
        }
        boolean left = isInNode(root.left, data1);
        boolean right = isInNode(root.right, data1);
        return left || right;
    }


    public static TreeNode lastestAnster(TreeNode root, Integer data1, Integer data2) {
        //先序遍历中，如果当前节点等于其中给定节点，那么当前就是公共祖先
        //用于发现当前节点中是否含有两个data：这里表达的意思，如果没有找到返回的是null，因为到叶子一定是null
        if (root == null || root.data == data1 || root.data == data2) {
            return root;
        }

        TreeNode left = lastestAnster(root.left,data1,data2);
        TreeNode right = lastestAnster(root.right,data1,data2);

        if (left != null && right != null){
            return root;
        }
        return  left!= null?left:right;

    }
}
