package impl;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 实现迭代器的栈 ,且去除了构造器实现初始化
 * @param <Item>
 * @author Gjc
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    /**
     * 栈的数据组
     */
    private Item[] a = (Item[]) new Object[1];

    /**
     * 指向指针
     */
    private int N = 0;


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


    // 获取迭代器
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        // 支持后进先出的迭代
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
