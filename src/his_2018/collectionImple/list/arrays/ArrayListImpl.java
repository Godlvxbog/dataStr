package his_2018.collectionImple.list.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/18.
 */
public class ArrayListImpl {

    /**
     * 字段：数组作为容器,与尺寸
     */
    Object[] elementData;
    int size;

    /**
     * 构造函数
     * @param args
     */

    public ArrayListImpl(int initialSize){
        if (initialSize < 0){
            throw new IllegalArgumentException("LIst容量不够");

        }
        this.elementData =new Object[initialSize];
    }

    public ArrayListImpl(){
        this(10);//默认调用容量为10的构造方法
    }

    /**
     * 添加方法之前有一个容量的扩充
     */

    public boolean add(Object element){
        ensureCapacity(size + 1);//至少扩充容量的1个
        elementData[size++] = element;
        return true;

    }

    /**
     * 确定容量：取max(指定的值minCapacity，1.5倍原来容量+1)；并重新赋值
     */

    public void ensureCapacity(int minCapacity){//默认是为  size + 1：size指的是其中数据个数
        int oldCapacity = elementData.length;//数组的长度
        if (oldCapacity < minCapacity){//原来的空间不够了
            int newlength = (oldCapacity * 3)/2 + 1;
            int newCapacity = Math.max(minCapacity,newlength);

            elementData = Arrays.copyOf(elementData,newCapacity);//复制数组
        }

    }


    public boolean add(int index, Object element){
        if (index < 0 || index > size ){//如果为空或者已经越界了就抛出异常
            throw new ArrayIndexOutOfBoundsException("数组索引错误index:"+ index);
        }
        ensureCapacity(size);
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);//往后偏移一个
        elementData[index] = element;
        size++;
        return true;
    }

    /**
     * 获取index
     * @param o
     * @return
     */

    public int indexOf(Object element){
        for (int i = 0; i< size; i++){
            if (element.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取元素之前需要检查是否越界等
     */

    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    public void rangeCheck(int index){
        if (index > size){
            throw new ArrayIndexOutOfBoundsException("您查找的元素越界了");
        }
    }

    public Object remove(int index){
        rangeCheck(index);
        Object oldElement = elementData[index];//临时保存起来
        int numMoved = size - index - 1;//长度
        if (numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size] =null;//垃圾回收机制开始工作
        return oldElement;
    }

    /**
     * 删除指定的元素
     * @param element
     * @return
     */
    public boolean remove(Object element){
        for (int i = 0; i< size; i++){
            if (element == elementData[i]){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayListImpl myList = new ArrayListImpl();
        myList.add(10);
        myList.add(120);
        myList.add(103);
        myList.add(104);
        myList.add("dsdd");
        myList.add(2,"HelloWorld");
        myList.remove(0);
        System.out.println(myList);
        ArrayList list =new ArrayList();
    }


}
