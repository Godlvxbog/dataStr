package his_2018.alg.tree;

/**
 * 关于递归函数设计：
 *
 * 1，明确函数参数列表 本层与下一层时候需要切换 ，比如 node 切换到 node.left,
 *
 * 2, 明确递归的条件，以及正常的条件  常见如 if(node == null)return  在else中参与计算和递归
 *
 *
 *
 *
 */
public class TNode {
    public int data;

    public TNode left;
    public TNode right;

    public TNode(){

    }

    public TNode(int data){
        this.data = data;
    }

    public static TNode insert(TNode node,int data) {
        if (node == null) {
            node = new TNode(data);
            return node;
        } else {
            if (data < node.data) {
                if (node.left == null) {
                    node.left = new TNode(data);
                    return node;
                } else {
                    insert(node.left, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new TNode(data);
                    return node;
                } else {
                    insert(node.right, data);
                }
            }
        }
        return node;
    }



    public static TNode buildTree() {


        TNode root=new TNode(8);
        root.insert(root,6);
        root.insert(root,10);
        root.insert(root,5);
        root.insert(root,7);
        root.insert(root,9);
        root.insert(root,11);

        return root;
    }


    public static void main(String[] args) {
        buildTree();
    }





}
