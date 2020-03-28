import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    // 等所有线程准备好， 所有都各自往下走
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void task() {
        System.out.println("开始");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("都各自开始走下一步");
    }

    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            new Thread(CyclicBarrierTest::task).start();
        }
    }


}
