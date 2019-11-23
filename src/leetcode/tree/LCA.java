package leetcode.tree;

import battle_2019.datastruct.TreeNode;

/**
 * 最近公共祖先：235 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * 题目描述：在二叉查找树中寻找最近的公共祖先
 *
 * 函数定义：
 *
 * 用例拆分，归纳
 * 1、qp在同一个子树上
 * 2、pq不在同一个子树上。
 * 3、p在当前节点上。
 *
 */
public class LCA {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1、边界检查
        assert (p != null && q != null);
        if (root == null){
            return null;
        }

        //2、同一侧
        if (p.data < root.data && q.data < root.data){
            return lowestCommonAncestor(root.left,p,q);
        }
        if (p.data > root.data && q.data > root.data){
            return lowestCommonAncestor(root.right,p,q);
        }

        // 3 qp在两侧，那么当前节点就是 最近的公共节点,
        // 4、qp其中有一个就是当前root，这两种情况的根节点都是root
        // 5、这里假设了。pq都是存在的。
        return root;

    }
}
