package Thread;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 可重入锁
 *
 *
 * 当线程A进入到LoggingWidget的doSomething()方法时，此时拿到了LoggingWidget实例对象的锁。

   随后在方法上又调用了父类Widget的doSomething()方法，它又是被synchronized修饰。

   那现在我们LoggingWidget实例对象的锁还没有释放，进入父类Widget的doSomething()方法还需要一把锁吗？
   不需要的！
   因为锁的持有者是“线程”，而不是“调用”。线程A已经是有了LoggingWidget实例对象的锁了，当再需要的时候可以继续“开锁”进去的！
   这就是内置锁的可重入性。
 * @Date 15:52 2019/4/15
 **/
public class TestSynchronize {

    public static void main(String[] args) {

    }

}


class Widget {

    //synchronized修饰方法
    public synchronized void doSomething() {

    }
}

class LoggingWidget extends Widget {

    //synchronized修饰方法
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}
