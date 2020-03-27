public class InterruptedTest {


    // 中断失败
    private static void task1() {
        while (true) {
            Thread.yield();
        }
    }

    // 中断成功
    private static void task2() {
        while (true) {
            Thread.yield();

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程被中断，程序退出");
                return ;
            }
        }
    }

    // 中断失败，sleep中断会清除标记
    private static void task3() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程中断，程序退出");
                return;
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("休眠中断，程序退出");
            }

        }
    }


    public static void task4() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程中断，程序退出");
                return;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("休眠中断，程序退出");
                Thread.currentThread().interrupt();
            }

        }
    }

    public static void main(String[] args) {
//        Thread thread1 = new Thread(InterruptedTest::task2);
//        thread1.start();
//        thread1.interrupt();

        Thread thread4 = new Thread(InterruptedTest::task4);
        thread4.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread4.interrupt();

    }

}
