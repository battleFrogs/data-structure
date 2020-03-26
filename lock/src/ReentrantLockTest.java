import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 操作
 * @author Gjc
 */
public class ReentrantLockTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();


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


    private static Condition produceCondition = reentrantLock.newCondition();
    private static Condition consumeCondition = reentrantLock.newCondition();
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);


    // 生产
    public static void task5And1()  {
        reentrantLock.lock();
        try {
            while (atomicInteger.get() % 2 != 0) {
                System.out.println("数目可以消费");
                produceCondition.await();
            }
            int i = atomicInteger.incrementAndGet();
            System.out.println("1我生产" + i);
            consumeCondition.signal();
        } catch (Exception e){
            System.out.println("异常");
        } finally {
            reentrantLock.unlock();
        }

    }

    // 消费
    public static void task5And2() {
        reentrantLock.lock();
        try {
            while (atomicInteger.get() % 2 == 0) {
                System.out.println("数目可以生产");
                consumeCondition.await();
            }
            int i = atomicInteger.decrementAndGet();
            System.out.println("2我消费了" + i);
            produceCondition.signal();
        } catch (Exception e){
            System.out.println("异常");
        } finally {
            reentrantLock.unlock();
        }


    }




    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            // 构建 匿名 构建线程
            new Thread(ReentrantLockTest::task5And1).start();

            new Thread(ReentrantLockTest::task5And2).start();
        }
    }


}
