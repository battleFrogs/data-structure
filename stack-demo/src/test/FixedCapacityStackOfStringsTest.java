package test;

import impl.FixedCapacityStackOfStrings;

public class FixedCapacityStackOfStringsTest {



    public static void main(String[] args) {

        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
        System.out.println(stack.size());
        stack.push("value1");
        System.out.println(stack.isEmpty());
        stack.push("value2");
        System.out.println(stack.size());
        String pop = stack.pop();
        System.out.println(pop);


    }


}
