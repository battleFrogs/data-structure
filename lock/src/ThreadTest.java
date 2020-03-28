import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程相关
 * @author Gjc
 */
public class ThreadTest {

    private static void task1() {
        System.out.println("task1进来了");
    }

    public static class Thread1 extends Thread {

        Thread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            task1();
        }
    }

    public static class Thread2 implements Runnable {

        @Override
        public void run() {
            task1();
        }
    }



    public static void main(String[] args) {
        // 构建 实体类创建Thread线程
        Thread1 thread1 = new Thread1("线程一");
        thread1.start();

        // 实现 Runnable接口 创建线程
        Thread2 thread2 = new Thread2();
        Thread t = new Thread(thread2);
        t.start();

        // jdk8 实现
        new Thread(ThreadTest::task1).start();
        new Thread(()->{
            System.out.println(1);
        }).start();

        // 使用现成的配置好的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(20);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(30);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService.execute(()->{});

        // 手动创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 30, 20, TimeUnit.SECONDS, new PriorityBlockingQueue());
        threadPoolExecutor.execute(()->{});

    }


}
