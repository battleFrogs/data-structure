package impl;

public class Base {

    /**
     * 对元素进行比较
     * @param v 元素一
     * @param w  元素二
     * @return boolean
     */

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 将元素交换位置
     * @param a 数组a
     * @param i 位置一
     * @param j 位置二
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 单行打印
     * @param a 数组a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否排序
     * @param a 数组
     * @return boolean
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
