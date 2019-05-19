package his_2018.alg.tree.D_C;

import his_2018.alg.tree.TNode;
import his_2018.alg.tree.serial.LayerSerial;

/**
 * 已知一颗树是H，问t2是否是H的孩子：
 *
 * 如果两者相同应该满足：
 *
 * 1，H和t2的各自的左节点相一致
 * 2，H和t2的各自的右节点一致。
 * 3, t2为空
 *
 * 如果包含有三种情况：
 *
 *
 * 1，当前节点就已经cheacked,
 * 2,左包含，
 * 3，右包含
 *
 *
 *
 * 关于前序与后序的区分：
 *
 * 前序相当于小老板要做的事情：我就是小老板  ，当前节点要做的事，
 *
 * 后序，就是对，左下级，右下级 布置的任务，，归拢来，，并做处理
 *
 *
 * 、
 *
 */



public class IsSonTree {

    //返回H的当前节点 时候是与  t2的当前节点相同。如果是的，说明该层相同
    public static boolean checked(TNode node,TNode t2){
        if (t2 == null ){
            return true;
        }

        //值不相等,不用往下分了，直接返回。
        if (node.data != t2.data ){
            return  false;
        }
        //已经遍历到最后了
        if (node == null){
            return false;
        }

        boolean left = checked(node.left, t2.left);
        boolean right = checked(node.right, t2.right);

        boolean result = left && right;//合并下级汇上来的记过

        return result;


    }

//    w问你这个组织有么有某个结构，只需要求得：

//    1，当前层是不是有
//    2，左孩子是不是有
//    3,右孩子是不是有
//    然后合并起来，返回给上一层。始终记住，你一定处于中间，，需要向上会包，可以把左右孩子结果收上来
    public static boolean contains(TNode node ,TNode t2){

        boolean curCheacked = checked(node,t2);//计算当前层,注意，一旦找到了需要立刻返回，如果没有找到就放下找
        if (curCheacked){
            return true;
        }
        boolean leftContains = contains(node.left,t2);//收左孩子
        if (leftContains){
            return true;
        }
        boolean rightContains =contains(node.right,t2);//收右孩子
        if (rightContains){
            return true;
        }

        boolean res =curCheacked || leftContains || rightContains;

//        return checked(node,t2)|| contains(node.left,t2) ||contains(node.left,t2);

        return res;
    }

    public static void main(String[] args) {

        String str1 = "1!2!3!4!5!6!7!8!9!10!#!#!#!#!#!#!#!#!#!#!#!";
        TNode node = LayerSerial.revLayer(LayerSerial.splitStr(str1));

        String str2 ="2!4!5!8!#!#!#!#!#!";
        TNode t2 = LayerSerial.revLayer(LayerSerial.splitStr(str2));

        System.out.println(contains(node,t2));


    }



}
