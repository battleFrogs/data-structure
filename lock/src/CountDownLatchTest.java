import java.util.concurrent.CountDownLatch;

// 等子线程全部消耗结束，主线程才开始
public class CountDownLatchTest {

    // 设置计数为2
    private final static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void task1() {
        System.out.println("子开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("异常");
        }finally {
            // 消耗计数
            countDownLatch.countDown();
        }


    }



    public static void main(String[] args) {
        for (int i = 0; i < countDownLatch.getCount(); i++) {
            new Thread(CountDownLatchTest::task1).start();
        }
        System.out.println("正在等待所有玩家准备好");
        try {
            // 开始阻塞 等待数字消耗完
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始游戏");


    }
}
