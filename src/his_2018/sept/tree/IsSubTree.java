package his_2018.sept.tree;

import his_2018.alg.tree.TNode;

/**
 * Created by xbog on 2017/9/4.
 * 判断一棵树是不是另一棵树的孩子树：
 *
 * 1） 向下分解：
 * 2）匹配得上吗？
 *
 */
public class IsSubTree {

    /**
     * 在root中找到孩子树伟t2的：
     * 这里递归的是root
     * @param root
     * @param t2
     * @return
     */
    static boolean isSubTree(TNode root,TNode t2){
        if (t2 == null){
            return true;
        }

        //下面是当t2不为空是否
        if (root == null){
            return false;
        }

        //找到root中的某个节点与t2的根节点一致，这时候开始root这个节点下的是否是和t2完全相同
        if (root.data == t2.data){
            boolean curMatch = isSame(root,t2);
            if (curMatch){
                return true;//包含了
            }
        }


        boolean left = isSubTree(root.left,t2);
        boolean right = isSubTree(root.right,t2);

        return left ||right;
    }


    /**
     * 判断两棵树是否相同：依然是从上往下扩散，从下往上进行返回：上一层的依赖于下一层的结果
     *
     * @param root
     * @param t2
     * @return
     */
    static boolean isSame(TNode root,TNode t2){

        //1 两个都是null返回的是true
        if (root == null && t2 == null){
            return true;
        }

        //2 两个中有一个是null返回的是false
        if (root == null || t2 == null){
            return false;
        }

        //3 两个都不为空： 至上往下的扩散，先序遍历
        if (root.data != t2.data){
            return false;
        }

        boolean left = isSame(root.left,t2.left);
        boolean right = isSame(root.right,t2.right);

        if (left && right){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TNode root=new TNode(8);
        root.insert(root,6);
        root.insert(root,10);
        root.insert(root,5);
        root.insert(root,7);
        root.insert(root,9);
        root.insert(root,11);


        TNode t2=new TNode(10);
        t2.insert(t2,9);
        t2.insert(t2,11);


        TNode t3=new TNode(10);
        t3.insert(t3,9);
        t3.insert(t3,11);

        System.out.println(isSubTree(root,t2));

    }
}
