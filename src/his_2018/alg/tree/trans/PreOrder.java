package his_2018.alg.tree.trans;

import his_2018.alg.tree.TNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 遍历：递归以及非递归
 *
 * 递归：分而治之
 *
 * 1、确定参数，需要改变的是 root --- root.left 当前层到下一层，确定如何分
 * 2、确定遍历边界，以及递归的条件
 * 3、压栈，分的每一层应该做什么
 * 4、治的每一层应该做什么
 *
 *
 * 非递归实现：
 *
 * 压入头 -- 取出头，并压入下一层 ：循环
 *
 * 1、申请一个栈，用来装各个节点的临时中转
 * 2、压入头
 */
public class PreOrder {

    public static void preOrder(TNode root){
        //边界
        if (root == null){
            return;
        }

        //分，压栈应该做的事情 root
        System.out.print(root.data+" ");

        preOrder(root.left);
        preOrder(root.right);

    }


    public static void preOrder2(TNode root){
        Stack<TNode> stack =new Stack<TNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            TNode cur =stack.pop();//取出元素保存起来，

            System.out.print(" " + cur.data);//打印

            if (cur.right!=null){  //把取出的当前元素的左右孩子都压入【关键点】
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }
    }

    //分治法
    public static  ArrayList<Integer> preOrder3(TNode root){
        ArrayList<Integer> result=new ArrayList<Integer>();

        if (root == null){
            return result;
        }

        //分:假定已经到达了最后的两个点
        ArrayList<Integer> left = preOrder3(root.left);
        ArrayList<Integer> right = preOrder3(root.right);

        //治理
        result.add(root.data);
        result.addAll(left);
        result.addAll(right);

        return result;
    }


    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        preOrder(root);

        System.out.println(" ============ ");
        preOrder2(root);

        System.out.println(" ============ ");

        preOrder3(root);
    }
}
