package leetcode.stack;

import battle_2019.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归遍历树：前序、中序、后续  144 、94、145.
 * 需要自己画出图形
 *
 * 每次递归时，会保存当前栈的结构体（这里并不是所有的行都执行完成了）：比如命令：打印，访问左孩子、访问右孩子
 *
 * 非递归：也就是自己去使用stack来模拟系统stack的
 *
 * 比如go -1 ，当前访问的是 1
 * 然后放入 三个操作。
 * 遍历的结束：stck为空
 *
 */
public class OrderTree {
    public static void main(String[] args) {
        TreeNode node = TreeNode.buildTree();
        List<Integer> res = new OrderTree().preorderTraversal(node);
        System.out.println(res);
    }


    class Command{
        String str; //作用在此节点上的指令的描述：访问 =go，打印=print
        TreeNode treeNode;


        public Command(String str, TreeNode treeNode) {
            this.str = str;
            this.treeNode = treeNode;
        }
    }


    public  List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        //初始化
        Stack<Command> stack = new Stack<>();
        //首先把根节点压入到stack中
        stack.push(new Command("go",root));

        //开始遍历stack了。
        while (!stack.isEmpty()){
            Command command = stack.pop();//取出栈顶的元素，下面开始分析栈顶元素

            //如果当前指令是打印就输出
            if (command.str =="print"){
                res.add(command.treeNode.data);
            }else {
                //做一个断言
                assert (command.str == "go");

                //右边孩子是否存在，如果存在就要访问
                if(command.treeNode.right != null){
                    stack.push(new Command("go",command.treeNode.right));
                }
                if (command.treeNode.left != null){
                    stack.push(new Command("go",command.treeNode.left));
                }

                //如果左右孩子都处理了，那么就要开始访问根节点了。
                stack.push(new Command("print",command.treeNode));
            }

        }
        return res;
    }


    public  List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        //初始化
        Stack<Command> stack = new Stack<>();
        //首先把根节点压入到stack中
        stack.push(new Command("go",root));

        //开始遍历stack了。
        while (!stack.isEmpty()){
            Command command = stack.pop();//取出栈顶的元素，下面开始分析栈顶元素

            //如果当前指令是打印就输出
            if (command.str =="print"){
                res.add(command.treeNode.data);
            }else {
                //做一个断言
                assert (command.str == "go");

                //右边孩子是否存在，如果存在就要访问
                if(command.treeNode.right != null){
                    stack.push(new Command("go",command.treeNode.right));
                }

                stack.push(new Command("print",command.treeNode));

                if (command.treeNode.left != null){
                    stack.push(new Command("go",command.treeNode.left));
                }
            }

        }
        return res;
    }


    public  List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        //初始化
        Stack<Command> stack = new Stack<>();
        //首先把根节点压入到stack中
        stack.push(new Command("go",root));

        //开始遍历stack了。
        while (!stack.isEmpty()){
            Command command = stack.pop();//取出栈顶的元素，下面开始分析栈顶元素

            //如果当前指令是打印就输出
            if (command.str =="print"){
                res.add(command.treeNode.data);
            }else {
                //做一个断言
                assert (command.str == "go");

                stack.push(new Command("print",command.treeNode));

                //右边孩子是否存在，如果存在就要访问
                if(command.treeNode.right != null){
                    stack.push(new Command("go",command.treeNode.right));
                }

                if (command.treeNode.left != null){
                    stack.push(new Command("go",command.treeNode.left));
                }
            }

        }
        return res;
    }





}
