import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 操作
 * @author Gjc
 */
public class ReentrantLockTest {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    private static void task1() {
        // 如果已经被 lock，则立即返回 false 不会等待，达到忽略操作的效果
        if (reentrantLock.tryLock()) {
            try {
                System.out.println("task1进来了");
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private static void task2() {
        System.out.println("开始等待");
        try {
            //如果被其它资源锁定，会在此等待锁释放，达到暂停的效果
            reentrantLock.lock();
            System.out.println("执行");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("解锁");
            reentrantLock.unlock();

        }

    }

    public static void task3() {
        try {
            // 如果已经被 lock，尝试等待 2s，看是否可以获得锁，如果 2s 后仍然无法获得锁则返回 false 继续执行
            System.out.println("开始等待");
            if (reentrantLock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println("操作");
                    Thread.sleep(2000);
                } finally {
                    // 解锁必须放在进锁的里面才给解
                    System.out.println("解锁");
                    reentrantLock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task4() {
        try {
            System.out.println(Thread.currentThread().getName() + "开始");
            // 如果发现该操作已经在执行，等待执行。这时可中断正在进行的操作立刻释放锁继续下一操作(类似取消同步操作)
            reentrantLock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + "操作");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放");
            reentrantLock.unlock();
        }

    }


    public static void task5() {
        Condition condition = reentrantLock.newCondition();

    }




    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            // 构建 匿名 构建线程
            new Thread(ReentrantLockTest::task4).start();
        }
    }


}
