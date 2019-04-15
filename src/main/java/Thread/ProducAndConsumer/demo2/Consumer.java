package Thread.ProducAndConsumer.demo2;


import java.util.Random;
import java.util.concurrent.BlockingQueue;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *BlockingQueue阻塞队列方式实现
 * @Date 21:02 2019/4/15
 **/
public class Consumer implements Runnable{


    private BlockingQueue<Integer> queue;                            // 内存缓冲区
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int data;
        Random r = new Random();

        System.out.println("start consumer id = " + Thread.currentThread().getId());
        try {
            while (true) {
                // 模拟延迟
                Thread.sleep(r.nextInt(SLEEPTIME));

                // 从阻塞队列中获取数据
                if (!queue.isEmpty()) {
                    data = queue.take();
                    System.out.println("consumer " + Thread.currentThread().getId() + " consume data：" + data
                            + ", size：" + queue.size());
                } else {
                    System.out.println("Queue is empty, consumer " + Thread.currentThread().getId()
                            + " is waiting, size：" + queue.size());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
