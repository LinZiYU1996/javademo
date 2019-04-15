package Thread.ProducAndConsumer.demo1;


import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 生产者
 *
 *
 *
 * 创造数据：
 * 生产者-消费者解决的问题就是数据在多线程间的共享，
 * 所以我们首要关心的问题就应该是数据，
 * 我们这里采用的是使用一个AtomicInteger类来为我们创造数据，
 * 使用它的好处是该类是一个保证原子操作的类，我们使用其中的incrementAndGet()方法不仅能够保证线程安全，
 * 还可以达到一个计数的效果，所以是一个既简单又实用的选择，当然也可以使用其他的数据来代替，
 * 这里注意的是要保证该类在内存中只存在一份，使用static修饰；

内存缓冲区：
* 要保证在多线程环境下内存缓冲区的安全，所以我们考虑使用简单的Vector类来作为我们的内存缓冲区，
* 并且使用final修饰保证内存缓冲区的唯一，然后的话我们需要判断队列是否满，
* 需要手动添加一个标识缓冲区大小的变量SIZE，注意也是final修饰；

模拟延迟：
* 这里主要模拟的是一个网络延迟，我们首先定义了一个SLEEPTIME的延迟范围，
* 注意使用的是static final修饰，
* 然后使用Random()类的nextInt()方法来随机选取一个该范围内的值来模拟网络环境中的延迟；

停止方法：
* 首先需要知道在Thread类中有一个弃用的stop()方法，
* 我们自己增加一个标志位isRunning来完成我们自己的stop()功能，
* 需要注意的是使用volatile来修饰，保证该标志位的可见性；

错误处理：
* 当捕获到错误时，
* 我们应该使用Thread类中的interrupted()方法来终止当前的进程；

消息提示：
* 我们主要是要在控制台输出该生产者的信息，
* 包括当前队列的状态，大小，当前线程的生产者信息等，
* 注意的是信息格式的统一(后面的消费者同样的)；

消费者代码


 * @Date 20:12 2019/4/15
 **/
public class Producer implements Runnable{

    private volatile boolean isRunning = true;
    private final Vector sharedQueue;                            // 内存缓冲区
    private final int SIZE;                                      // 缓冲区大小
    private static AtomicInteger count = new AtomicInteger();    // 总数，原子操作
    private static final int SLEEPTIME = 1000;

    public Producer(Vector sharedQueue, int SIZE) {
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        int data;
        Random r = new Random();

//        System.out.println("start producer id = " + Thread.currentThread().getId());
        System.out.println("生产者线程启动了 id 是： " + Thread.currentThread().getId());

        try {
            while (isRunning) {
                // 模拟延迟
                Thread.sleep(r.nextInt(SLEEPTIME));

                // 当队列满时阻塞等待
                while (sharedQueue.size() == SIZE) {
                    synchronized (sharedQueue) {
//                        System.out.println("Queue is full, producer " + Thread.currentThread().getId()
//                                + " is waiting, size：" + sharedQueue.size());

                        System.out.println("队列满了, 生产者 " + Thread.currentThread().getId()
                                + " 正在等待, 队列大小：" + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }

                // 队列不满时持续创造新元素
                synchronized (sharedQueue) {
                    data = count.incrementAndGet();                 // 构造任务数据
                    sharedQueue.add(data);
//                    System.out.println("producer create data:" + data + ", size：" + sharedQueue.size());

                    System.out.println("生产者生产数据:" + data + ", 队列大小：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupted();
        }
    }
    public void stop() {
        isRunning = false;
    }
}
