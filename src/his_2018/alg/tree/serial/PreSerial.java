package his_2018.alg.tree.serial;

import his_2018.alg.tree.TNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化：
 * 字符串数组 -- 树
 * 树 --- 数组
 *
 * 序列化，就是一层一层地把节点输出到字符串，所以需要参考3中遍历方式
 * 思路：当前节点，加上其孩子（左，右）
 *
 * 左右孩子一定是已经可以拿到上一层的结果了。【十分重要】
 *
 * 关注返回的值，，为空时候返回null，不为空返回  root
 *
 * 返回的值总是从上一层栈中获取得到的
 */
public class PreSerial {

    public static String serialPreOrder(String str, TNode root){
        if (root == null){
           return "#!";
        }

        str += (root.data +"!");

        str += serialPreOrder(str,root.left);
        str += serialPreOrder(str,root.right);

        return str;
    }

    //反序列化；
//    思路：his_2018.alg.str -- split按照！分割成字符串数组，循环遍历，把每个字符串都压到队列中
//         依次出队，并分别安好  root，left。 right;

    public static Queue<String> splitStr(String str){
        Queue<String> queue = new LinkedList<String>();

        String[] values = str.split("!");
        for (int i = 0; i < values.length; i++ ){
            queue.add(values[i]);
        }
        return queue;
    }

    public static TNode revSerialOrder(Queue<String> queue){
        String str = queue.poll();//

        if (str.equals("#")){
            return null;
        }

        TNode root =new TNode(Integer.valueOf(str));  //先序得到当前节点，后序遍历返回当前作为上一层的左右孩子

        //分：这里用queue.poll()来更新，输入的参数：集合形式的更新；
        TNode left =revSerialOrder(queue);//按照上面循环的规则返回左子树
        root.left =left;

        TNode right =revSerialOrder(queue); //按照上面规则，包含左边的，形成右子树
        root.right = right;

        //治：
        return root;

    }






    public static void main(String[] args) {
        TNode root =TNode.buildTree();

        String str="";
        String str2 = serialPreOrder(str,root);

        System.out.println( str2);


        System.out.println("+++++++++++++++");

        String str3 = "12!3!#!#!#!";
        TNode head = revSerialOrder(splitStr(str3));

    }
}
