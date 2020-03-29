package impl;

public class HeapSort {


    // 排列堆中最大为顶
    public static void getRootMax(int[] a, int currentRootNode, int size) {

        if (currentRootNode < size) {

            int max = currentRootNode;
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;

            if (left < size) {
                if (a[left] > a[max]) {
                    max = left;
                }
            }

            if (right < size) {
                if (a[right] > a[max]) {
                    max = right;
                }
            }

            if (max != currentRootNode) {
                int temp = a[currentRootNode];
                a[currentRootNode] = a[max];
                a[max] = temp;

                getRootMax(a, max, size);
            }

        }
    }

    // 建堆一次
    public static void getHeap(int[] a, int size) {
        for (int i = size - 1; i >= 0; i--) {
            getRootMax(a, i, size);
        }
    }

    // 建堆去顶部值到数组最后一位，再拿数组去尾部的建堆
    public static void getSort(int[] a) {
        for (int i = 0; i < a.length; i++) {

            getHeap(a, a.length - i);

            int temp = a[0];
            a[0] = a[(a.length - 1) - i];
            a[(a.length - 1) - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {234, 234231, 322, 324, 5452, 1, 322, 11, 234};
        getSort(a);
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println(i1);
        }
    }


}
