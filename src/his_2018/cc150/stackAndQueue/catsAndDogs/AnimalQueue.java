package stackAndQueue.catsAndDogs;

import java.util.LinkedList;

/**
 * Created by Administrator on 2016/11/14.
 */
public class AnimalQueue {
    //；两个容器
    LinkedList<Dog> dogs=new LinkedList<Dog>();
    LinkedList<Cat> cats=new LinkedList<Cat>();
    //
    private int order;
    //入队
    public void enqueue(Animal animal){
        animal.setOrder(order);
        order++;//自动分类序号给animal

        //加入指定的队列中
        if (animal instanceof Dog){
            dogs.addLast((Dog)animal);
        }
        if (animal instanceof Cat){
            cats.addLast((Cat)animal);
        }
    }

    //出队，任意都可以

    public Animal dequeueany(){
        //当某个队列已经有空的时候
        if (dogs.size()==0){
            return dequeueCat();
        }else if (cats.size()==0){
            return dequeueDog();
        }

        //比较两个年龄的大小
        Dog dog=dogs.peek();
        Cat cat=cats.peek();
        if (dog.isOlder(cat)){
            return dequeueDog();
        }else{
            return dequeueCat();
        }

    }

    public Dog dequeueDog(){
        return dogs.poll();//移除头
    }
    public Cat dequeueCat(){
        return cats.poll();
    }

    public static void main(String[] args) {
        AnimalQueue myqueue=new AnimalQueue();
        for (int i=0;i<10;i++){
            Animal dog=new Dog(String.format("Ndog--%d",i*2));
            Animal cat=new Cat(String.format("Ncat--%d",i));
            myqueue.enqueue(dog);
            myqueue.enqueue(cat);
        }
        Animal a1= myqueue.dequeueany();
        Animal a2= myqueue.dequeueany();
        Animal a3= myqueue.dequeueany();

        System.out.println(a1.getName() +" == "+ a1.getOrder());
        System.out.println(a2.getName() +" == "+ a2.getOrder());
        System.out.println(a3.getName() +" == "+ a3.getOrder());

        System.out.println(myqueue.dequeueCat().getOrder());
        System.out.println(myqueue.dequeueCat().getOrder());

        System.out.println(myqueue.dequeueDog().getOrder());
        System.out.println(myqueue.dequeueDog().getOrder());

        Animal a4= myqueue.dequeueany();
        Animal a5= myqueue.dequeueany();

        System.out.println(a4.getName() +" == "+ a4.getOrder());
        System.out.println(a5.getName() +" == "+ a5.getOrder());


    }
}
