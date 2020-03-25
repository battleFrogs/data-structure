package impl;

/**
 * 选择排序  前头一定是按顺序的排列
 * 比较 首先认定 第一次头一个的为最小 min索引   min = 0;  [1,min] [2,min] [3,min]
 * 然后后面值一一与他相比，一旦比他小 ，就替换 min 索引  min = j
 * 最后 每次循环的首位 为 最小min索引对应的数组值  a[i] = a[min]
 *
 */
public class ChooseSort extends Base{

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
//        Comparable[] a = {1, 2, 7, 32, 6346, 234, 2344};
//        sort(a);
//        show(a);
        int[] a = {12, 2, 213, 43, 235, 555, 43453};
        sortMySelf(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] sortMySelf(int[] a) {

        for (int i = 0; i < a.length; i++) {
            //首先标记最小值 min = 每次循环一个值
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                // 一旦遇到 有值比 min 索引的数组值小的 就交换min与当前的索引
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            // 交换位置
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }

        return a;
    }


}
