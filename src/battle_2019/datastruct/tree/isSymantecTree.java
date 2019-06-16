package battle_2019.datastruct.tree;

import battle_2019.datastruct.TreeNode;

/**
 *
 * 【剑指Offer ：60】
 * 是否是对称树
 */
public class isSymantecTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);

//
//        TreeNode.insert(node,6);
//        TreeNode.insert(node,6);
//        TreeNode.insert(node,5);
//        TreeNode.insert(node,7);
//        TreeNode.insert(node,7);
//        TreeNode.insert(node,5);

        boolean res = pre(node);
        System.out.println(res);

    }

    public static boolean pre(TreeNode node){
        if (node == null){
            return true;
        }
        return  isSymantecal(node,node);

    }

    public static boolean isSymantecal(TreeNode node1 ,TreeNode node2){

        boolean resLeft= isEquals(node1.left ,node2.right);
        boolean resRigth= isEquals(node1.right ,node2.left);

        boolean res = resLeft && resRigth;
        return  res;
    }

    public  static boolean isEquals(TreeNode node1 ,TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 ==null ||node2== null ){
            return false;
        }


        if (node1.data != node2.data){
            return false;
        }else {
            return true;
        }
    }
}
