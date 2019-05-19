package his_2018.alg.tree.trans;

import his_2018.alg.tree.TNode;

import java.util.Stack;

/**
 * 设置两个栈，
 */
public class PostOrder {

    public static void postOrder(TNode root){
        if (root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);

        System.out.print(" "+root.data);//从上面可以看出左右两边都为空才打印，这是最后一层
    }


    public static void postOrder2(TNode root){
        Stack<TNode> stack1 =new Stack<TNode>();
        Stack<TNode> stack2 =new Stack<TNode>();

        stack1.push(root);//

        while (!stack1.isEmpty()){
            TNode temp =stack1.pop();
            stack2.push(temp);

            if (temp.left!=null){

                stack1.push(temp.left);
            }
            if (temp.right != null){

                stack1.push(temp.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(" " + stack2.pop().data );
        }

    }

    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        postOrder(root);
        System.out.println("========");
        postOrder2(root);
    }
}
