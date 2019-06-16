package battle_2019.alg;

import battle_2019.datastruct.MyNode;

import java.util.Stack;

/**
 *
 * 【剑指Offer ：37】
 * 找出两个链表的第一个公共节点。
 * 拓扑结构是 Y型。
 *
 * 1、两个辅助的stack，
 *      先压栈，然后top（），然后比较最后一个相同节点。
 * 2、优化为
 *
 */
public class TwoNodeCommonNode {
    public static void main(String[] args) {

    }

    public static MyNode commonNode(MyNode node1,MyNode node2){
        Stack<MyNode> stack1 = new Stack<>();
        Stack<MyNode> stack2 = new Stack<>();

        while (node1 !=null){
            stack1.push(node1);
        }


        while (node2 !=null){
            stack2.push(node2);
        }
        MyNode top1 = null;
        MyNode top2 = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            top1 = stack1.peek();
            top2 = stack2.peek();
            if (top1.data == top2.data){
                stack1.pop();
                stack2.pop();
            }
        }
        return top1;
    }
}
