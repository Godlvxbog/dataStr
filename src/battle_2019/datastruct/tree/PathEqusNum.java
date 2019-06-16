package battle_2019.datastruct.tree;

import battle_2019.datastruct.TreeNode;

import java.util.Stack;

/**
 * 面试题目 25
 * 和为指定的数的 路径。
 * 思路：遍历选择前序遍历，前序遍历可以首先访问根节点
 *
 * 是根节点时，curSum = 预期的值，则输出，返回到root时，弹出栈顶元素
 * 叶子节点： 从根节点到叶子节点为一条完整的路径图。
 * 用栈去保留 路径，
 * 往下遍历时压栈，返回时弹出栈顶元素
 *
 *
 *
 *
 */
public class PathEqusNum {
    public static void main(String[] args) {
        TreeNode node = TreeNode.buildTree();
        Stack<TreeNode> stack = new Stack<>();
        findPath(node,450,stack,0);
        System.out.println(1);
    }

    public static void findPath(TreeNode node, int exceptNum, Stack<TreeNode> stack,int curSum){
        //先序遍历先压栈
        curSum += node.data;
        stack.push(node);

        //判断是否是叶子节点
        boolean isLeaf = node.left == null && node.right == null;

        if (isLeaf && curSum == exceptNum){
            //打印该栈的元素
            for (int i= 0; i< stack.size();i++){
                System.out.println(stack.get(i).data);
            }
        }

        //遍历
        if(node.left != null){
            findPath(node.left,exceptNum,stack,curSum);
        }
        if (node.right != null){
            findPath(node.right,exceptNum,stack,curSum);
        }

        stack.pop();//非常关键，弹出底层一层的数据。
    }
}
