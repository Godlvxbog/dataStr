package battle_2019.datastruct.tree;

import battle_2019.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 【剑指Offer ：63】
 */
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

        TreeNode node = kthNode3(root,6);
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


    /**
     * 借助中序遍历保存数组
     * @param root
     * @param k
     * @return
     */
    public static TreeNode kthNode3(TreeNode root,int k){
        //异常处理。
        inOrder(root);
        return nodes.get(k-1);
    }
    public static ArrayList<TreeNode> nodes = new ArrayList<>();
    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            inOrder(root.left);
        }
        nodes.add(root);

        if (root.right!= null){
            inOrder(root.right);
        }
    }

    /**
     * 非递归
     * @param root
     * @param k
     * @return
     */
    public static TreeNode kthNode2(TreeNode root,int k){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//根节点yaru
        Integer index=0;
        TreeNode res = null;
        while (!stack.isEmpty()){
            if (root != null){//左遍历到底
                stack.push(root);

                root = root.left;
            }else {
                root = stack.pop();
                index++;
                if (index == k){
                    res = root;
                    break;
                }
                root= root.right;
            }
        }
        return res;
    }
}
