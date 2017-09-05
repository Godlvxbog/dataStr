package sept.tree;

import alg.tree.TNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xbog on 2017/9/5.
 *
 * 层序遍历
 */
public class LayerOrder {

    public static void  layerOrder(TNode root){
        //使用队列进行遍历
        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(root);

        //开始遍历
        while (!queue.isEmpty()){
            //1 开始访问当前树的根节点
            TNode temp = queue.poll();
            System.out.println(temp.data);

            //2 压入做右孩子树
            if (temp.left != null){
                queue.add(temp.left);
            }

            if (temp.right != null){
                queue.add(temp.right);
            }
        }

    }

    public static void main(String[] args) {
        TNode node = TNode.buildTree();
        layerOrder(node);
    }
}
