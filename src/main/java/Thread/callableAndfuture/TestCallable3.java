package Thread.callableAndfuture;

import java.util.ArrayList;
import java.util.concurrent.*;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 *
 * @Date 10:59 2019/4/19
 **/
public class TestCallable3 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new Task(i)));
        }
        System.out.println("====================cost:" + (System.currentTimeMillis() - start));
        int count = 0;

        for (Future<String> fs : results) {
            System.out.println("========cost:"+(System.currentTimeMillis()-start));
            long start2 = System.currentTimeMillis();
            try {
                //取数据
                System.out.println(fs.get());

            } catch (InterruptedException e) {
                System.out.print(e);

            } catch (ExecutionException e) {
                System.out.print(e);
            } finally {
                exec.shutdown();

            }
            System.out.println((count++)+"====================cost:"+(System.currentTimeMillis()-start2));


        }

    }
}

class Task implements Callable<String> {

    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return " 结果是 ： " + id;
    }
}
