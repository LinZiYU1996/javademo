package Thread;




/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 写两个线程，一个线程将某个对象的某个成员变量的值加1，
 * 而另外一个线程将这个成员变量的值减1.
 * 使得该变量的值始终处于[0,2].初始值为0.
 *
 * @Date 10:39 2019/4/15
 **/
public class TestSynchronized {

    public static void main(String[] args) {
        Target target = new Target();
        Thread t1 = new Increase(target);
        t1.setName("Increase");
        Thread t2 = new Decrease(target);
        t2.setName("Decrease");
        t1.start();
        t2.start();

    }


}

class Target {
    private int count;
    public synchronized void increase(){
        if (count == 2) {
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + ":" + count);
        notify();
    }

    public synchronized void decrease(){
        if (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + ":" + count);
        notify();
    }
}

class Increase extends Thread{
    private Target target;
    public Increase(Target target){
        this.target = target;
    }

    @Override
    public void run() {
        for(int i = 0 ; i<30 ;i++){
            try {
                Thread.sleep((long) (Math.random()*500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            target.increase();
        }
    }
}

class Decrease extends Thread{
    private Target target;

    public Decrease(Target target){
            this.target = target;
    }

    @Override
    public void run() {
        for(int i = 0; i < 30 ; i++){
            try {
                Thread.sleep((long) (Math.random()*500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            target.decrease();
        }
    }
}
