package his_2018.singleton;

/**
 * Created by Administrator on 2017/2/12.
 */
public  class SingleTonFactory {
    private static SingleTon instance = new SingleTon();

    public static SingleTon getInstance3(){
        return SingleTonFactory.instance;
    }

}
