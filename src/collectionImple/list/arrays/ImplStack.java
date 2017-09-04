//package collectionImple.impl;
//
//import java.util.EmptyStackException;
//import java.util.Stack;
//import java.util.Vector;
//
///**
// * Created by Administrator on 2017/3/2.
// * 所以是线程同步的
//// */
//public class ImplStack{
//
//
//    private LinkedList<T> stack;
//
//    //无参构造函数
//    public ImplStack() {
//        stack = new LinkedList<T>();
//    }
//
//    //构造一个包含指定collection中所有元素的栈
//    public ImplStack(Collection<? extends T> c) {
//        stack = new LinkedList<T>(c);
//    }
//
//    //入栈
//    public void push(T t) {
//        stack.addFirst(t);
//    }
//
//    //出栈
//    public T pull() {
//        return stack.remove();
//    }
//
//    //栈是否为空
//    boolean isEmpty2() {
//        return stack.isEmpty();
//    }
//
//    //打印栈元素
//    public void display() {
//        for (Object o : stack)
//            System.out.println(o);
//    }
//
//
//
//    public static void main(String[] args) {
//
//    }
//
//}
