package his_2018.sept.tree;

import his_2018.alg.tree.TNode;

import java.util.Stack;

/**
 * Created by xbog on 2017/9/4.
 *
 * 前序遍历使用stack
 */
public class PreOrder {

    public static void preOrder(TNode root){
        TNode cur =  root;
        Stack<TNode> stack = new Stack<TNode>();
        stack.push(cur);
        while (!stack.isEmpty()){
            TNode temp = stack.pop();//当前节点的访问
            System.out.println(temp.data);

            //压栈
            if (temp.right != null){
                stack.push(temp.right);
            }

            //压栈
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public static void main(String[] args) {
        TNode root = TNode.buildTree();
        preOrder(root);
    }
}
