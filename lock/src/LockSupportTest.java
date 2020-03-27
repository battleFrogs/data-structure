import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {



    // unpark 先执行给它一个许可，许可不可叠加，最多只能一个
    // park 消耗必须是 每一个都消耗一个
    static void task1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始线程阻塞");
        LockSupport.park();
        System.out.println("结束线程阻塞");
    }


    static void task2() {
        System.out.println("开始线程阻塞");
        LockSupport.park();
        LockSupport.park();
        System.out.println("结束线程阻塞");
    }



    public static void main(String[] args) {
        Thread thread = new Thread(LockSupportTest::task2);
        thread.start();
        System.out.println("开始线程唤醒");
        LockSupport.unpark(thread);
        System.out.println("结束线程唤醒");
    }


}
