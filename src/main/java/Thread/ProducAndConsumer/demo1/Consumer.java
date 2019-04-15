package Thread.ProducAndConsumer.demo1;


import java.util.Random;
import java.util.Vector;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 跟生产者相同的，你需要注意内存缓冲区/ 模拟延迟/ 错误处理/ 消息提示这些方面的细节问题，
 * 总体来说消费者就是持续不断的消费，也比较容易实现；
 * @Date 20:19 2019/4/15
 **/
public class Consumer implements Runnable{


    private final Vector sharedQueue;                            // 内存缓冲区
    private final int SIZE;                                      // 缓冲区大小
    private static final int SLEEPTIME = 1000;

    public Consumer(Vector sharedQueue, int SIZE) {
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        Random r = new Random();

//        System.out.println("start consumer id = " + Thread.currentThread().getId());
        System.out.println("消费者线程启动 id 是： " + Thread.currentThread().getId());
        try {
            while (true) {
                // 模拟延迟
                Thread.sleep(r.nextInt(SLEEPTIME));

                // 当队列空时阻塞等待
                while (sharedQueue.isEmpty()) {
                    synchronized (sharedQueue) {
//                        System.out.println("Queue is empty, consumer " + Thread.currentThread().getId()
//                                + " is waiting, size：" + sharedQueue.size());

                        System.out.println("队列空了, 消费者：" + Thread.currentThread().getId()
                                + " 正在等待, 队列大小：" + sharedQueue.size());


                        sharedQueue.wait();
                    }
                }

                // 队列不空时持续消费元素
                synchronized (sharedQueue) {
//                    System.out.println("consumer consume data：" + sharedQueue.remove(0) + ", size：" + sharedQueue.size());
                    System.out.println("消费者消耗数据：" + sharedQueue.remove(0) + ", 队列大小：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
