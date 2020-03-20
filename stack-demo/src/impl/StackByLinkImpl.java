package impl;

public class StackByLinkImpl<Item> {

    // 栈顶
    private Node first;

    // 数目
    private int N;

    // 内部类 节点
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
        // 或者 N == 0
    }

    public int size() {
        return N;
    }

    // 保存原来的首节点, 再新增一个新节点，新节点的下一个指向为之前的原节点
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    // 取出原来节点对应的值，再将原来节点的赋值为原先节点的下一个节点
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }


}
