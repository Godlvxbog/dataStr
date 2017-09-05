package sept.tree;

import alg.tree.TNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by xbog on 2017/9/4.
 * 思路：
 * 使用栈解决至上而下的 结构问题
 * 每次压栈就是把问题分解成同种类型的 子问题，
 * 每次while（）stack.pop（）弹出栈就是，访问子问题，然后你就可以解决子问题了。
 *
 * 使用栈来对树进行中序遍历
 */
public class InOrderTree {

    public static void inOrderTree(TNode root){
        //edge

        //使用stack进行分解问题和对孩子问题的处理

        TNode cur = root;//指针
        Stack<TNode> stack = new Stack();

        while (!stack.isEmpty() || cur != null) {//遍历条件是：stack不为空，当前节点不为空

            //分支一：如果为不为空，始终往下解决左边的孩子问题
            if (cur != null) {//分解成孩子问题
                //先压入当前节点
                stack.push(cur);
                // 1 指针切换
                cur = cur.left;
            }else {//分支二、如果为空：开始解决孩子问题：始终就是出栈的获取顶元素
                // 1 访问栈顶元素
                TNode temp = stack.pop();
                System.out.println(temp.data);


                // 2 指针切换
                cur  = temp.right;//关键点，当前指针可以是：cur的孩子，也可以是stack的临时保留的指针

            }

        }
    }

    public static void inOrder2(TNode root){

        //
        Stack<TNode> stack = new Stack<TNode>();
        TNode cur = root;

        while (!stack.isEmpty() || cur != null){
            //1 遍历到所有的左边的：分解
            while (cur != null) {
                stack.push(cur);

                cur = cur.left;
            }

            //2 解决孩子问题:一定是需要弹出的

            if (!stack.isEmpty()){
                //1 栈顶元素：当问的对象
                TNode temp = stack.pop();
                System.out.println(temp.data);

                //2 循环变量的指针偏移
                if (temp.right != null){
                    cur = temp.right;//十分关键的点
                }
            }


        }

    }


    //使用递归
    //中序遍历：中间访问 当前节点，先访问左孩子问题，
//    需要考虑：
//    分：向下扩散 ，以及到叶子节点的处理

    public static void inOrder3(TNode root){

        if (root == null){
            return;
        }
        //向下扩散： 先访问左边孩子问题
        inOrder3(root.left);

        // 访问当前节点
        System.out.println(root.data);
//        向下扩散：右边
        inOrder3(root.right);

    }


    public static void main(String[] args) {
        TNode root = TNode.buildTree();
        inOrder3(root);

    }
}
