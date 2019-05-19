package stackAndQueue.catsAndDogs;

/**
 * 要求，猫狗都有自己的序号，所以需要用Animal父类来接收 Dog 和 Cat
 */
public abstract class Animal {
    private int order;//序号，作为动物你总的序号
    private String name;
    public Animal(String AniName){
        name=AniName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //比较当前类的序号大小
    public boolean isOlder(Animal a){

        return a.order < this.order ;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
