package his_2018.alg.tree.D_C.toTree;

import his_2018.alg.tree.TNode;

import java.util.ArrayList;

/**
 * 从一个sortArr中生成BST
 *
 * BST概念是：左《 中 《 右节点
 *
 * 所以每次取中间的数，为根节点，分，
 */
public class SortArrToBST {

    public static TNode sortArrtoBST(ArrayList<Integer> list ,int start,int end){
        if (start > end){
            return null;
        }

        int mid =( start + end )/ 2;
        TNode node = new TNode(list.get(mid));

        node.left = sortArrtoBST(list,start,mid -1);
        node.right = sortArrtoBST(list,mid + 1, end);

        return node;


    }

    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(10);
        list.add(16);
        list.add(17);

        TNode node = sortArrtoBST(list,0,list.size() -1);
    }
}
