package sept.tree;

import alg.tree.TNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xbog on 2017/9/5.
 * 一个有序数组转换成BST
 */
public class SortArrToBST {

    public static TNode arrToBST(List<Integer> list, int start, int end){
        if (start > end){
            return null;
        }
        if(start == end){
            return new TNode(list.get(start));
        }

        int mid = (start + end) / 2;
        TNode cuNode = new TNode(list.get(mid));//得到当前节点

        cuNode.left = arrToBST(list,start,mid - 1);
        cuNode.right = arrToBST(list,mid + 1,end);

        return cuNode;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(10);
        list.add(16);
        list.add(17);
        TNode res = arrToBST(list,0,list.size() - 1);
        System.out.println(234);
    }
}
