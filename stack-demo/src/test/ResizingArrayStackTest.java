package test;

import impl.ResizingArrayStack;

import java.util.Iterator;

public class ResizingArrayStackTest {



    public static void main(String[] args) {

        ResizingArrayStack<Integer> resizingArrayStack = new ResizingArrayStack<>();
        resizingArrayStack.push(1);
        resizingArrayStack.push(2);
        resizingArrayStack.push(3);
        resizingArrayStack.push(4);

        Iterator<Integer> iterator = resizingArrayStack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }



}
