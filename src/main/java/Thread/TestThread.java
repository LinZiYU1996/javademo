package Thread;


import java.util.Vector;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 锁消除

*
* Vector是默认加锁的，但JVM如果发现vector变量仅仅在vectorTest()方法中使用
* ，那该vector是线程安全的。JVM会把vector内部加的锁去除，这个优化就叫做：锁消除。


 * @Date 16:05 2019/4/15
 **/
public class TestThread {


    public void vectorTest(){
        Vector<String> vector = new Vector<String>();
        for(int i = 0 ; i < 10 ; i++){
            vector.add(i + "");
        }

        System.out.println(vector);
    }



}
