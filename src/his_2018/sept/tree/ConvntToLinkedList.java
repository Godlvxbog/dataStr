package his_2018.sept.tree;

import his_2018.alg.tree.TNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xbog on 2017/9/5.
 *
 * ### 思路：
 1、引入哑结点，作为层与层之间的分隔符
 2、若当前节点是哑结点，表示当前层已经全部访问完了，比如压入到了列表中：
 I 把前面的levelList结果放到result中
 II 并且表示当前层的下一层所有节点也全部入队了，那么需要添加一个新的分隔符到队列中去

 */
public class ConvntToLinkedList {

    static boolean isDummy(TNode node){
        return node.left == node;
    }


    public static List< List<TNode> > convtToLinkedList(TNode root){
        List< List<TNode> > result = new ArrayList<List<TNode>>();
        List<TNode> levelList = new ArrayList<TNode>();

        Queue<TNode> nodeQueue = new LinkedList<TNode>();

        TNode curNode ;

        //构造一个dummyNode ：左孩子就是其本身
        TNode dummyNode = new TNode(0);
        dummyNode.left = dummyNode;

        nodeQueue.add(root);
        nodeQueue.add(dummyNode);

        while (!nodeQueue.isEmpty()){
            curNode = nodeQueue.poll();

            if (isDummy(curNode)){
                //如果是dummyNode：说明当前层已经完成后了， 需要做两件事：
                // 1 需要添加到result中
                if (!levelList.isEmpty()) {
                    result.add(levelList);
                    levelList = new ArrayList<TNode>();
                }

                //2 当前层的下一层也已经全部如队列了
                if (!nodeQueue.isEmpty()){
                    nodeQueue.add(dummyNode);
                }else {
                    break;
                }


            }else {//没有dummyNode ：正常的入队和出队
                //每一层需要访问的
                levelList.add(curNode);
                if (curNode.left != null){
                    nodeQueue.add(curNode.left);
                }

                if (curNode.right != null){
                    nodeQueue.add(curNode.right);
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        TNode root = TNode.buildTree();
        List< List<TNode> > res = convtToLinkedList(root);
        System.out.println(23);

    }
}
