package sept.tree;

import alg.tree.TNode;

/**
 * Created by xbog on 2017/9/5.
 */
public class MirrorTree {

    //使用前序遍历：进行swap（root.left,root.right）
    public static TNode genMirror(TNode root){

        swapChild(root);

        if (root.left != null){
            genMirror(root.left);
        }

        if (root.right != null){
            genMirror(root.right);

        }

        return root;


    }

    public static TNode swapChild(TNode t1){
        if (t1 == null){
            return t1;
        }

        TNode temp = t1.left;
        t1.left = t1.right;
        t1.right = temp;

        return t1;
    }


    public static void main(String[] args) {
        TNode root = TNode.buildTree();
        TNode mirror = genMirror(root);

        System.out.println("sf");
    }
}
