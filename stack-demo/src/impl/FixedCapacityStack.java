package impl;

/**
 * 可以指定某种类型，不必单一限定
 *  以及实现动态数组的控制
 * @param <Item>  泛型
 */
public class FixedCapacityStack<Item> {

    /**
     * 栈的数据组
     */
    private Item[] a;

    /**
     * 指向指针
     */
    private int N;

    /**
     * 初始化构建 栈的数组
     * @param cap 容量
     */
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    /**
     * 判断栈是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取当前数组的长度
     * @return int
     */
    public int size() {
        return N;
    }

    /**
     * 添加一个item
     * @param item
     */
    public void push(Item item) {
        // 在添加元素时会检测是否已满
        if (N == a.length) {
            // 如果已满就扩容当前长度的两倍
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    /**
     * 弹出一个item
     * @return item
     */
    public Item pop() {
        Item item = a[--N];
        // 避免对象游离 ,该元素也已经无法再被访问，所以回收
        a[N] = null;
        //检查是否元素 已经 小于数组的四分之一
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    /**
     * 动态调整数组大小
     * @param max 新的大小
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }





}
