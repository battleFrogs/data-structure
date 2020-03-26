import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();


    public static void task1() {

        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println("读锁");
            Thread.sleep(1000);
            reentrantReadWriteLock.readLock().unlock();
        } catch (InterruptedException e) {
            System.out.println("异常");
        }

    }

    public static void task2() {

        try {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println("写锁");
            Thread.sleep(1000);
            reentrantReadWriteLock.writeLock().unlock();
        } catch (InterruptedException e) {
            System.out.println("异常");
        }

    }



    public static void main(String[] args) {
//        new Thread(ReentrantReadWriteLockTest::task1).start();
//        new Thread(ReentrantReadWriteLockTest::task1).start();
        new Thread(ReentrantReadWriteLockTest::task2).start();
        new Thread(ReentrantReadWriteLockTest::task2).start();
    }

}
