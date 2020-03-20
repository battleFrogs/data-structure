package impl;

/**
 * 栈 普通对字符串的插入
 * @author Gjc
 */
public class FixedCapacityStackOfStrings {

    /**
     * 栈的数据组
     */
    private String[] a;

    /**
     * 指向指针
     */
    private int N;

    /**
     * 初始化构建 栈的数组
     * @param cap 容量
     */
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
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
    public void push(String item) {
        a[N++] = item;
    }

    /**
     * 弹出一个item
     * @return
     */
    public String pop() {
        return a[--N];
    }



}
