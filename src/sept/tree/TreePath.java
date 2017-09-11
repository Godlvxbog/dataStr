package sept.tree;

import alg.tree.TNode;
import alg.tree.trans.InOrder;
import collectionImple.list.ListImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xbog on 2017/9/5.
 *
 * 树的路径问题，使用全局变量:可以是值，一个引用，一个对象
 * 要求使用先序
 * 还没有解决
 */
public class TreePath {

    static class Result {
        int curSum = 0;
        List<Integer> curPath = new ArrayList<Integer>();
    }

    /**
     * 关键点：把当前的path 和结果作为参数传入到每个方法进行压栈
     * 先序是通过入参的所以返回值是void，先序遍历一定是改变入参
     * 后续是通过返回的
     */
    public void pathEqualsNumPost(TNode root,int stdSum ,Result curRes, List<Result> results) {
        //节点为空：说明我们已经走完了，到了叶子节点下面
        if (root == null){
            return;
        }

        curRes.curPath.add(root.data);
        curRes.curSum += root.data;

        if (curRes.curSum == stdSum){
            results.add(curRes);
            curRes = new Result();
        }
        pathEqualsNumPost(root.left,stdSum,curRes,results);
        pathEqualsNumPost(root.right,stdSum,curRes,results);
    }

    public static void main(String[] args) {
        TNode root = TNode.buildTree() ;
        List<Result> results = new ArrayList<Result>();
        Result curRes = new Result();

        TreePath treePath = new TreePath();

        treePath.pathEqualsNumPost(root,14,curRes,results);
        System.out.println(234);
    }
}
