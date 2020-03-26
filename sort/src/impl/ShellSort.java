package impl;

public class ShellSort extends Base {

    public static void sort(Comparable[] a) {

        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }

    }


    public static int[] sortByMyself(int[] a) {


        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i <= ; i++) {

            }
        }

        return a;
    }

}
