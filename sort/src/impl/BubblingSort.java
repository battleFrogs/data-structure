package impl;

// 冒泡排序
public class BubblingSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 4123, 324, 323, 324324, 2342341};
        sortMySelf(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sortMySelf(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i + 1; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }


    }


}
