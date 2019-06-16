package battle_2019.datastruct;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNode {
    public TreeNode left ;
    public TreeNode right;
    public int data;

    public TreeNode(int data) {
        this.data = data;
    }


    public static TreeNode insert(TreeNode root ,int data){
        TreeNode cur = root;
        if (root == null){
            return null;
        }

        if (data <=cur.data ){
            //如果cur当前节点不存在左节点就直接新建一个节点
            if (cur.left == null){
                TreeNode temp = new TreeNode(data);
                cur.left = temp;
            }else {
                insert(root.left,data);
            }
        }else {
            //如果cur当前节点不存在左节点就直接新建一个节点
            if (cur.right == null){
                TreeNode temp = new TreeNode(data);
                cur.right = temp;
            }else {
                insert(root.right,data);
            }
        }
        return root;
    }

    public static TreeNode buildTree(){
        TreeNode root = new TreeNode(100);
        insert(root,50);
        insert(root,200);
        insert(root,60);
        insert(root,30);
//        insert(root,40);
        insert(root,300);
        insert(root,150);
        System.out.println(root);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
//        inOrder2(root);
        inOrder3(root);
        System.out.println(root);
    }

    //遍历树
    public static void  preOrder(TreeNode root){
        if (root == null){
            return;
        }
        //打印
        System.out.println(root.data);
        //遍历左边
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 申请一个stack：
     * 每次stack.pop()为当前的打印节点
     * stack.push（）往下遍历
     * !stack.isEmpty() 遍历未完成
     * @param root
     */
    public static void  preOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            System.out.println(top.data);
            if (top.right != null){
                stack.push(top.right);
            }
            if (top.left != null){
                stack.push(top.left);
            }
        }
    }

    /**
     * 关心什么时候压栈，什么时候打印
     * 当前节点不为null压当前节点，并left++
     * 当前节点为null，打印，并right++；走右边
     * while的循环一次为处理当前zheng的一次
     * @param root
     */
    public static void  inOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){//未达到最后一个节点
            if(cur!= null){ //一直遍历左边的节点并yanzhan
                stack.push(cur);
                cur =cur.left;//left++
            }else{
                //压wan了左边的，到底了，打印当前节点了。
                cur = stack.pop();
                System.out.println(cur.data);

                cur =cur.right;//cur切换为stack右边
            }

        }
    }

    public static void  inOrder3(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty() ){//未达到最后一个节点
            if(cur!= null){ //一直遍历左边的节点并yanzhan
                stack.push(cur);
                cur =cur.left;//left++
            }else{
                //压wan了左边的，到底了，打印当前节点了。
                cur = stack.pop();
                System.out.println(cur.data);

                cur =cur.right;//cur切换为stack右边
            }

        }
    }

    /**
     * 广度优先遍历BFS
     * @param root
     */
    public static void layerOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode front = queue.poll();
            System.out.println(front.data);

            if (front.left != null){
                queue.add(front.left);
            }
            if (front.right != null){
                queue.add(front.right);
            }
        }

    }



}


