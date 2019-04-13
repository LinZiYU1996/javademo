package Thread;


/*
*
 * @Author Mr.Lin
 * @Description //线程安全的单例模式
 *
 * @Date 16:36 2019/4/13
 **/


public class SingleTon {

    //使用volatile是为了JVM的指令重排
    private volatile static SingleTon uniqueInstance;

    private SingleTon(){

    }

    public static SingleTon getUniqueInstance(){
        //先判断对象是否已经实例过，没有的话才进入加锁代码
        if (uniqueInstance == null) {
            synchronized (SingleTon.class){
                if (uniqueInstance == null){
                    uniqueInstance = new SingleTon();
                }
            }
        }
        return uniqueInstance;
    }


}
