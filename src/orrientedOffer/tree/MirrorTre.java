package orrientedOffer.tree;

import alg.tree.TNode;

/**
 * Created by Administrator on 2017/2/27.
 *
 * 对树进行镜像：
 * 思路：
 * 遍历加上交换:
 *
 * 可以从顶往下遍历时候进行交换；也可以后序遍历
 */
public class MirrorTre {


    //后序遍历；
    public static TNode mirrorTree(TNode root){
        if (root == null){
            return null;
        }

        TNode left = mirrorTree(root.left);
        TNode right = mirrorTree(root.right);

        //交换
        TNode temp = left;
        root.left =right;
        root.right = temp;

        return root;

    }

    //先序遍历:所以不用返回上层的
    public static void mirrorTree2(TNode root){
        if(root == null){
            return ;
        }

        //交换
        TNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //先序遍历
        if (root.left != null){
            mirrorTree2(root.left);

        }

        if (root.right != null){
            mirrorTree2(root.right);

        }



    }


    public static void main(String[] args) {
        TNode root =TNode.buildTree();

        mirrorTree2(root);
        System.out.println("Hello");
    }
}
