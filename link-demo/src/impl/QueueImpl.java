package impl;

public class QueueImpl<Item> {

    // 指向最早的节点链接
    private Node first;
    // 指向最近添加的节点链接
    private Node last;
    // 队列中的元素数量
    private int N;
    // 定义节点的嵌套类
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    // 表尾添加数据 , 将原队列最后一个节点 先保存，然后创建一个新的最后节点，将新的最后节点赋值，新的最后节点无指向下一个
    // 判断队列是否为空，从而判断 队列的头和尾是否是同一个
    public void enqueue(Item item) {
        Node oldLastNode = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }else{
            oldLastNode.next = last;
        }
        N++;
    }

    // 表头弹出数据
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        N--;
        return item;
    }

}
