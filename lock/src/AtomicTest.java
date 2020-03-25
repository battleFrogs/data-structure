import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * atomic原子操作
 * @author Gjc
 */
public class AtomicTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static AtomicReference<String> atomicReference = new AtomicReference<>("string");
    private static AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("initialRef", 1);
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);


    public static void main(String[] args) {
        // 获取值
        int i = atomicInteger.get();
        System.out.println(i);

        // 设置值
        atomicInteger.set(2);
        int i1 = atomicInteger.get();
        System.out.println(i1);

        // 获取值然后再设置
        int andSet = atomicInteger.getAndSet(3);
        System.out.println(andSet);

        // 加一然后获取
        int i2 = atomicInteger.incrementAndGet();
        // 获取并加一
        atomicInteger.getAndIncrement();
        System.out.println(i2);

        // 减去一然后获取
        int i3 = atomicInteger.decrementAndGet();
        // 获取并减一
        atomicInteger.getAndDecrement();
        System.out.println(i3);

        // 比较期望值 是设置值
        boolean b = atomicInteger.compareAndSet(1, 4);
        System.out.println(b);

        /********************************/
        // 比较期望值 是设置值
        boolean b1 = atomicReference.compareAndSet("except", "update");
        System.out.println(b1);

        // 获取值 然后设置值
        String newValue = atomicReference.getAndSet("newValue");
        System.out.println(newValue);


        /********************************/
        String reference = atomicStampedReference.getReference();
        int stamp = atomicStampedReference.getStamp();

        // 比较期望ref值 和 stamp值
        boolean b2 = atomicStampedReference.compareAndSet("except", "newReference", 1, 2);
        System.out.println(b2);


    }


}
