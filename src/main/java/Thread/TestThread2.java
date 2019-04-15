package Thread;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *三个线程分别打印A，B，C，要求这三个线程一起运行，打印n次，输出形如“ABCABCABC....”的字符串。
 *
 * @Date 16:47 2019/4/15
 **/
public class TestThread2 {

    public static void main(String[] args) {
        PrintABCUsingWaitNotify printABC = new PrintABCUsingWaitNotify(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }

}

//使用wait/notify
class PrintABCUsingWaitNotify {
    private int times;
    private int state;
    private Object objectA = new Object();
    private Object objectB = new Object();
    private Object objectC = new Object();

    public PrintABCUsingWaitNotify(int times) {
        this.times = times;
    }



    public void printA() {
        try {
            print("A", 0, objectA, objectB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB() {
        try {
            print("B", 1, objectB, objectC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC() {
        try {
            print("C", 2, objectC, objectA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String name, int targetState, Object current, Object next)
            throws InterruptedException {
        for (int i = 0; i < times;) {
            synchronized (current) {
                while (state % 3 != targetState) {
                    current.wait();
                }
                state++;
                i++;
                System.out.print(name);
                synchronized (next) {
                    next.notify();
                }

            }
        }
    }
}