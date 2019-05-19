package his_2018.alg.tree.serial;

import his_2018.alg.tree.TNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化思路  ：输入的是树  str来保存数据，层序遍历
 *        取出当前点 如果为空就 #，否则XX，然后压入当前节点的孩子
 *
 *
 *  反序列化思路：
 *
 *  输入时一个字符串的队列，，，，需要一个遍历的队列，用来保存当前操作的节点，，
 *
 *  myQueue的对头，temp作为生成节点，， 再次从queue中取出左右孩子节点，如果是空，直接设置即可，
 *  如果非空，需要压入myQueue作为就绪队列，头部将会被捞起来，生成下一层的操作节点。
 */
public class LayerSerial {

    public static String layerSerial(TNode root){
        String str = "";
        Queue<TNode> queue =new LinkedList<TNode>();

        queue.add(root);

        while (!queue.isEmpty()){
            TNode temp = queue.poll();

            if (temp == null){
                str += "#!";
            }else {
                str +=(temp.data+"!");
                queue.add(temp.left);
                queue.add(temp.right);
            }

        }

        return str;

    }


    public static Queue<String> splitStr(String str){
        Queue<String> queue = new LinkedList<String>();

        String[] values = str.split("!");
        for (int i = 0; i < values.length; i++ ){
            queue.add(values[i]);
        }
        return queue;
    }

    public static TNode generateNodeByStr(String str){
        if (str.equals("#")){
            return null;
        }
        return new TNode(Integer.valueOf(str));
    }


    public static TNode revLayer(Queue<String> queue){
        Queue<TNode> myQueue = new LinkedList<TNode>();//用来做层序遍历用的

        TNode head = generateNodeByStr(queue.poll());
        myQueue.add(head);

        while (!myQueue.isEmpty()){
            TNode temp = myQueue.poll();///本次取出的节点，下一步需要把该孩子节点压入，同时需要生成树的左右孩子节点

            TNode left = generateNodeByStr(queue.poll());
            temp.left = left;
            if (left != null){
                myQueue.add(left);
            }

            TNode right = generateNodeByStr(queue.poll());
            temp.right = right;//把生成的节点生成树

            if (right != null){//作为准备序列
                myQueue.add(right);
            }
        }
        return head;

    }


    public static  void main(String[] args) {
//        TNode root =TNode.buildTree();
        String str = "3!4!#!#!#!";

        Queue<String> queue = splitStr(str);

        TNode head = revLayer(queue);


    }


}
