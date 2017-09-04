//package collectionImple.impl;
//
//import java.util.EmptyStackException;
//import java.util.Stack;
//import java.util.Vector;
//
///**
// * Created by Administrator on 2017/3/2.
// *   1).public Stack() //一个无参构造方法，能直接创建一个Stack
// 2).public E push(E item)   //向栈顶压入一个项
// 3).public synchronized E pop()    //移走栈顶对象，将该对象作为函数值返回
// 4).public synchronized E peek()   //查找栈顶对象，而不从栈中移走。
// 5).public boolean empty()    //测试栈是否为空
// 是同步的
// *
// */
//public class StackImplStd extends Vector<E> {
//
//
//    E push(E item){
//        addElement(item);
//        return item ;
//    }
//
//    synchronized E peek(){
//        int len = size();
//        if (len == 0){
//            throw new EmptyStackException();
//        }
//        return elementAt(len-1);
//    }
//
//    synchronized E pop(){
//        int len = size();
//        E obj = peek();
//        removeElementAt(len-1);
//        return obj;
//    }
//    public static void main(String[] args) {
//
//    }
//}
