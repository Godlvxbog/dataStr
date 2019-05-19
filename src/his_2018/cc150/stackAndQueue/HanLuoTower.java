package stackAndQueue;

import java.util.Stack;

/**
 * 移动汉诺塔：
 * 1、有三个tower  ORi，Buff， Dest
 * 2、以栈作为tower，主要操作有：add，moveTop，moveDisks,(移动 n-1 个towers)
 * 步骤：
 * 1、MoveDisks：把n-1个tower从this ---（Des为缓冲区）--->Buff
 * 2、MoveTop：把剩余的tower从this--->Des
 * 3、MoveDisks：把Buffer中的n-1个tower 从buffer---（this为缓冲区）--->Des
 *
 * 关于递归：
 * 1、分成最底下的盘子和其上的n-1个盘子（遍历），操作元素为最底下的盘子MoveTop
 * 2、上层的n-1，先放在buffer上，在把n-1，的buffer放在desc中
 *
 */
public class HanLuoTower {
    private Stack<Integer> disk;
    private int index;
    public HanLuoTower(int i){
        disk=new Stack<Integer>();
        index=i;
    }

    public int index(){
        return index;
    }

    //add
    public void add(int d){
        if (!disk.isEmpty()&& d>=disk.peek()){
            System.out.println("放置Tower错误");
        }else{
            disk.push(d);
        }
    }
    //moveTop
    public void moveTopTo(HanLuoTower t){
        int top=disk.pop();
        t.add(top);
        System.out.println("移动tower的top元素，从"+this.index()+"到"+t.index());
    }

    //moveDisks
    public void moveDisks(int n,HanLuoTower des,HanLuoTower buf){
        if (n==0){
            return;
        }else{
            moveDisks(n-1,buf,des);//不断的压栈

            //出栈要做的事情1,2
            moveTopTo(des);
            buf.moveDisks(n-1,des,this);
        }
    }






}
