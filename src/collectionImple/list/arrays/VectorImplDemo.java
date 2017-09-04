//package collectionImple.impl;
//
//import java.util.List;
//import java.util.Vector;
//
///**
// * Created by Administrator on 2017/3/2.
// * Vector 是矢量队列，它是JDK1.0版本添加的类。继承于AbstractList，实现了List, RandomAccess, Cloneable这些接口。
// Vector 继承了AbstractList，实现了List；所以，它是一个队列，支持相关的添加、删除、修改、遍历等功能。
// Vector 实现了RandmoAccess接口，即提供了随机访问功能。RandmoAccess是java中用来被List实现，为List提供快速访问功能的。
// 在Vector中，我们即可以通过元素的序号快速获取元素对象；这就是快速随机访问。
// */
//public class VectorImplDemo implements List<E>  {
//
//    Object[] elementData;
//    int elementCount;
//    int capacityIncrement;//增长系数
//
//    public VectorImplDemo(){
//        this.elementCount = 10;
//    }
//
//    public VectorImplDemo(int capacity){
//        this.elementCount = capacity;
//    }
//
//    public VectorImplDemo(int capacity,int capacityIncrement){
//        super();
//        this.elementData = new Object[capacity];
//        this.capacityIncrement = capacityIncrement;
//    }
//
//
//    //关键：容量增长
//    void ensureCapacityHelper(int minCap){
//        int oldCapa = elementData.length;//同期的长度
//
//        if (minCap > oldCapa){
//            Object[] oldData = elementData;//保存旧的数据
//            //要么为原来的两倍，要么直接增加Incr的系数
//            int newCapa = (capacityIncrement >0) ? (oldCapa +capacityIncrement) : (oldCapa *2);
//
//            newCapa = Math.max(newCapa,minCap);
//
//
//        }
//    }
//
//    public synchronized void ensureCapa(int min){
//        ensureCapacityHelper(min);
//    }
//
//    synchronized int capa(){
//        return elementData.length;
//    }
//
//    synchronized int size2(){
//        return elementCount;
//    }
//
//    synchronized boolean isEmpty2(){
//        return size2()==0;
//    }
//
//
//}
