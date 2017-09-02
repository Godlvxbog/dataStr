package alg.tree.D_C.toTree;

import alg.tree.TNode;

import java.util.ArrayList;

/**
 * 根据一个后序遍历的序列，构建一个BST
 *
 * BST的特征是：最后一个数为根，比此数小的为左子树，大的为右子树
 *
 * 用分治法：
 *
 * 要求生成一棵树。先生成左子树，再生成右子树
 *
 * 分：最终状态为左右孩子节点
 * 治：
 *
 *
 */
public class PostToBST {

    public static TNode postToBst(ArrayList<Integer> list, int start, int end) {
        if (start  > end){
            return null;
        }
        int data = list.get(end);
        TNode node = new TNode(data);

        int mid = getBound(list,start,end);

        TNode left =postToBst(list,start,mid - 1);
        node.left = left;

        TNode right =postToBst(list,mid,end-1);
        node.right = right;

        return node;

    }

    //获取第一个大于数组最后一个数   的索引
    public static int getBound(ArrayList<Integer> list ,int left,int right){
        for (int i = left; i< right ; i++){
            if (list.get(i) > list.get(right)){
                return i;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(16);
        list.add(17);
        list.add(10);

       TNode node =   postToBst(list,0,list.size()-1);
//        System.out.println(getBound(list,0,list.size()-1,list.get(list.size()-1)));
    }
}
