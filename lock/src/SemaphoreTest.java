import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    // 声明同一时刻，只有4个进程同时运行指定代码
    private static Semaphore semaphore = new Semaphore(4);

    public static void task1() {
        try {
            semaphore.acquire(3);
            System.out.println("执行需要消耗3个进程");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("异常");
        }
        semaphore.release(3);

    }

    public static void task2() {

        try {
            semaphore.acquire(4);
            System.out.println("执行需要消耗4个进程");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("异常");
        }
        semaphore.release(4);

    }

    public static void task3() {

        try {
            semaphore.acquire(1);
            System.out.println("执行需要消耗1个进程");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("异常");
        }
        semaphore.release(1);
    }




    public static void main(String[] args) {
        new Thread(()->{task1();}).start();
        new Thread(()->{task2();}).start();
        new Thread(()->{task3();}).start();
    }

}
