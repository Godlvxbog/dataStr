package his_2018.alg.tree.trans;

import his_2018.alg.tree.TNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 把树变成二维数组并打印：
 * 设置  last ；当前打印的节点
 *       nlast: 就绪节点的最新值
 *
 *       java中linkedLIst实现了Queue接口 poll peek
 *
 *       temp:当前出队操作节点
 *       last：上一行操作的及诶诶单
 *       if (last == temp) :
 */
public class LayerOrder {


    public static ArrayList<ArrayList<TNode>> layerOrder(TNode root){
        ArrayList< ArrayList<TNode> > result =new ArrayList<ArrayList<TNode>>();
        ArrayList<TNode> row = new ArrayList<TNode>();

        TNode last = root,nlast = null;

        LinkedList<TNode> queue = new LinkedList<TNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            //操作元素出队,并让孩子入队
            TNode temp =  queue.poll();
            row.add(temp);//row把当前节点都打印

            if (temp.left != null){//孩子节点入队
                queue.add(temp.left);
                nlast = temp.left;
            }
            if (temp.right != null){
                queue.add(temp.right);
                nlast = temp.right;
            }

            if (temp == last){//当前操作节点是上一次打印的的最后一个节点，
                result.add(row);
                row = new ArrayList<TNode>();

                last = nlast;
            }

        }
        return result;

    }


    public static void main(String[] args) {
        TNode root = TNode.buildTree();
        layerOrder(root);
    }

}
