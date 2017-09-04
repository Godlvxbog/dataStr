//package collectionImple.impl;
//
//import java.util.*;
//
///**
// * Created by Administrator on 2017/3/1.
// *
// * JDK7,8和其他的应该不一样
// * 但是它执行插入和删除操作时比ArrayList更加高效，因为它是基于链表的
// * LinkedList 是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。
// LinkedList 实现 List 接口，能对它进行队列操作。
// LinkedList 实现 Deque 接口，即能将LinkedList当作双端队列使用。
// LinkedList 实现了Cloneable接口，即覆盖了函数clone()，能克隆。
// LinkedList 实现java.io.Serializable接口，这意味着LinkedList支持序列化，能通过序列化去传输。
// LinkedList 是非同步的。
// *
// */
//public class LinkedListImplDemo implements List<E>, Deque<E>,{
//
//    //内部泛型类
//    private static class Node<E> {
//        E item;
//        Node<E> next;
//        Node<E> prev;
//
//        Node(Node<E> prev,E element, Node<E> next){
//            this.item = element;
//            this.prev = prev;
//            this.next = next;
//        }
//
//
//
//    }
//
//    Node<E> first ;
//    Node<E> last ;//最后的节点
//    int size = 0;
//
//    void linkFisrt(E e){
//        final Node<E> tempf = first;
//        final Node<E> newNode = new Node<E>( null,e,tempf);//连接原来的头结点
//        first = newNode;//更新头结点
//
//        if (tempf == null){//头为空
//            last = newNode;
//        }else{
//            tempf.prev = newNode;//往前的连接连上
//        }
//        size++;
//
//    }
//    void linkLast(E e){
//        final Node<E> templ = last;
//        final Node<E> newNode = new Node<E>( templ,e,null);//连接原来的头结点
//        last = newNode;//
//
//        if (templ == null){//头为空
//            first = newNode;
//        }else{
//            templ.next = newNode;//往前的连接连上
//        }
//        size++;
//
//    }
//
//    E unlinkFirst(Node<E> first){
//        final E element = first.item;//保留需要返回
//        final Node<E> next = first.next;
//
//        first.item = null;//删除
//        first.next = null;
//
//        first = next;//更新
//
//        if (next != null){
//            next.prev = null;
//        }else{
//            last = null;
//        }
//        size --;
//
//        return element;
//    }
//
//    @Override
//    public void addFirst(E e) {
//
//    }
//
//    @Override
//    public void addLast(E e) {
//
//    }
//
//    @Override
//    public boolean offerFirst(E e) {
//        return false;
//    }
//
//    @Override
//    public boolean offerLast(E e) {
//        return false;
//    }
//
//    @Override
//    public E removeFirst() {
//        return null;
//    }
//
//    @Override
//    public E removeLast() {
//        return null;
//    }
//
//    @Override
//    public E pollFirst() {
//        return null;
//    }
//
//    @Override
//    public E pollLast() {
//        return null;
//    }
//
//    @Override
//    public E getFirst() {
//        return null;
//    }
//
//    public E getLast(){
//        final Node<E> l = last;
//        if (l == null){
//            throw new NoSuchElementException();
//        }
//        return l.item;
//    }
//
//    @Override
//    public E peekFirst() {
//        return null;
//    }
//
//    @Override
//    public E peekLast() {
//        return null;
//    }
//
//    @Override
//    public boolean removeFirstOccurrence(Object o) {
//        return false;
//    }
//
//    @Override
//    public boolean removeLastOccurrence(Object o) {
//        return false;
//    }
//
//    @Override
//    public boolean offer(E e) {
//        return false;
//    }
//
//    @Override
//    public E remove() {
//        return null;
//    }
//
//    @Override
//    public E poll() {
//        return null;
//    }
//
//    @Override
//    public E element() {
//        return null;
//    }
//
//    @Override
//    public E peek() {
//        return null;
//    }
//
//    @Override
//    public void push(E e) {
//
//    }
//
//    @Override
//    public E pop() {
//        return null;
//    }
//
//    @Override
//    public Iterator<E> descendingIterator() {
//        return null;
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return false;
//    }
//
//    @Override
//    public Iterator<E> iterator() {
//        return null;
//    }
//
//    @Override
//    public Object[] toArray() {
//        return new Object[0];
//    }
//
//    @Override
//    public <T> T[] toArray(T[] a) {
//        return null;
//    }
//
//    @Override
//    public boolean add(E e) {
//        return false;
//    }
//
//    @Override
//    public boolean remove(Object o) {
//        return false;
//    }
//
//    @Override
//    public boolean containsAll(Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(Collection<? extends E> c) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(int index, Collection<? extends E> c) {
//        return false;
//    }
//
//    @Override
//    public boolean removeAll(Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public boolean retainAll(Collection<?> c) {
//        return false;
//    }
//
//    public void clear(){
//        for (Node<E> x =first;x!= null ; ){
//            Node<E> next = x.next;
//
//            x.item = null;
//            x.prev = null;
//            x.next = null;
//
//        }
//        first = null;
//        last = null;
//        size = 0;
//    }
//
//    //优化
////    　该方法返回双向链表中指定位置处的节点，而链表中是没有下标索引的，要指定位置出的元素，就要遍历该链表，从源码的实现中，我们看到这里有一个加速动作。源码中先将index与长度size的一半比较，如果index<size/2，就只从位置0往后遍历到位置index处，而如果index>size/2，就只从位置size往前遍历到位置index处。这样可以减少一部分不必要的遍历。
//    Node<E> node(int index) {
//
//
//        if (index < (size >> 1)) {
//            Node<E> x = first;
//            for (int i = 0; i < index; i++)
//                x = x.next;
//            return x;
//        } else {
//            Node<E> x = last;
//            for (int i = size - 1; i > index; i--)
//                x = x.prev;
//            return x;
//        }
//    }
//
//    E get(int index){
//        checkElementIndex(index);
//        return node(index).item;
//    }
//
//    @Override
//    public E set(int index, E element) {
//        return null;
//    }
//
//    @Override
//    public void add(int index, E element) {
//
//    }
//
//    @Override
//    public E remove(int index) {
//        return null;
//    }
//
//    @Override
//    public int indexOf(Object o) {
//        return 0;
//    }
//
//    @Override
//    public int lastIndexOf(Object o) {
//        return 0;
//    }
//
//    @Override
//    public ListIterator<E> listIterator() {
//        return null;
//    }
//
//    @Override
//    public ListIterator<E> listIterator(int index) {
//        return null;
//    }
//
//    @Override
//    public List<E> subList(int fromIndex, int toIndex) {
//        return null;
//    }
//
//    private boolean isElementIndex(int index) {
//        return index >= 0 && index < size;
//    }
//
//    private void checkElementIndex(int index) {
//        if (!isElementIndex(index))
//            throw new IndexOutOfBoundsException();
//    }
//
//
//
//}
