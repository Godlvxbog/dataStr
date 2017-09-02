package alg.tree.trans;

import alg.tree.TNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 关于栈的操作关键点：压栈 --- 何时取top -- ，压栈一般是压自己的孩子
 */
public class InOrder {
    public static ArrayList<Integer> inOrder(TNode root, ArrayList<Integer> result){
        if (root == null){
            return result;
        }

        inOrder(root.left,result);

        result.add(root.data);

        inOrder(root.right,result);

        return result;//传递给上一级
    }

    public static void inOrder2(TNode root){
        //栈：保存数，压栈，取top，然后出栈
        Stack<TNode> stack =new Stack<TNode>();
        TNode curr =root;

        stack.push(curr);

        while (!stack.isEmpty()){  //栈表示就绪栈，即将要打印的数据

            while(curr != null){  //压栈
                curr = curr.left;//切换到左边，

                if (curr!=null){
                    stack.push(curr);
                }

            }

            TNode temp =stack.pop();// 出栈    关键点：切换到栈中的要操作的数据，也就是压栈前的数据
            System.out.println(temp.data);

            curr = temp.right;//关键点2：操作的节点是栈定元素，当前层元素。 切换右子树，重复以前的过程

            if (curr !=null){
                stack.push(curr);
            }
        }

        /*
        只要当前左节点为空，就弹出栈顶的节点，并切换。右边的设置为当前节点，如果为空就弹出，否则就压入
         */




    }


    public static void inOrder3(TNode root) {
        //栈：保存数，压栈，取top，然后出栈
        Stack<TNode> stack = new Stack<TNode>();
        TNode curr = root;

        stack.push(curr);

        while (!stack.isEmpty()) {  //栈表示就绪栈，即将要打印的数据

            while (curr != null) {  //压栈
                curr = curr.left;//切换到左边，

                if (curr != null) {
                    stack.push(curr);
                }

            }

            TNode temp = stack.pop();

            curr = temp.right;//切换；

            if (curr !=null){
                stack.push(curr);//对比while  与  当前的结构几乎一样
            }

        }

    }





    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        ArrayList<Integer> res =  inOrder(root,new ArrayList<Integer>());

        inOrder2(root);

    }
}
