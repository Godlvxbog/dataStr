package stackAndQueue;

import java.util.LinkedList;

/**
 * 练习使用LinkedList
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        for (int i=0;i<10;i++){
            linkedList.add(i,2*i+1);
        }
        linkedList.addFirst(100);
        linkedList.addLast(1000);

        linkedList.peek();
        linkedList.poll();
        linkedList.getFirst();
        linkedList.push(200);
        linkedList.pop();

        linkedList.getLast();
        linkedList.removeLast();

        System.out.println(linkedList.peek());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.removeLast());

    }
}
