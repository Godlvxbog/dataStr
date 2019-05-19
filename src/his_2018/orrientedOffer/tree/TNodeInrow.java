package his_2018.orrientedOffer.tree;

import his_2018.alg.tree.TNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/3/1.
 *
 * 按照行进行打印；
 * 思路：
 *
 * 需要用一个row来临时装一个每次需要的打印
 *
 * 如果是（cur ==慢指针）{
 *     更新慢指针 = 快指针；
 *     添加row，
 *     新建 row用来创建  【到尾部进行新建，比如递归中的到节点】
 * }
 *
 * cur:当前要操作的节点
 * fast : 当前节点的孩子节点： 作为最新的节点
 * slow: 上一层
 *
 * list< row ></>
 *
 *
 *
 *
 *
 * 快指针：准备工作每次弹出节点的最新的孩子节点；
 * 慢指针： 记录当前行的
 *      层序遍历，+ 两根指针
 *      当道了一层的最后就更新指针，
 *
 */
public class TNodeInrow {


    public static ArrayList<ArrayList<TNode>> printInrow(TNode root){
        ArrayList< ArrayList<TNode> > result = new ArrayList<ArrayList<TNode>>();
        ArrayList<TNode> row = new ArrayList<TNode>();

        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(root);

        TNode fast = root;//实时更新为最新的孩子节点
        TNode slow  = fast;

        while(!queue.isEmpty()){
            TNode cur = queue.poll();
//            row.add(cur);//每次要操作的对象对象应该是cur，而非其孩子节点
            System.out.print(cur.data + " ") ;

            if (cur.left != null){
                queue.add(cur.left);
                fast = cur.left;
            }
            if (cur.right != null){
                queue.add(cur.right);
                fast = cur.right;//新的指针
            }

            if (cur == slow){//如果当前的节点等于弹出的节点

//                result.add(row);
//                row = new ArrayList<TNode>();
                System.out.println();
                slow = fast;//更新到下一层
            }
        }
        return result;
    }


    public static ArrayList<ArrayList<TNode>> printInrow2(TNode root){

        ArrayList< ArrayList<TNode> > result = new ArrayList<ArrayList<TNode>>();


        if (root == null){
            return result;
        }

        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(root);

        while (!queue.isEmpty()){

            ArrayList<TNode> row = new ArrayList<TNode>();//每一行的容器
            int start = 0,end = queue.size();//每一行的循环次数

            while(start < end ){
                TNode cur = queue.peek();
                System.out.print(cur.data + " ");
                row.add(cur);//每次的元素
                queue.poll();
                //准备下一层
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }

                start ++;
            }

            result.add(row);
            System.out.println();


        }
        return result;


    }



    public static void main(String[] args) {
        TNode root =TNode.buildTree();
        ArrayList<ArrayList<TNode>> res = printInrow2(root);

    }
}
