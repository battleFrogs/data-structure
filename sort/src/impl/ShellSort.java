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


        for (int gap = a.length / 2; gap >= 1; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                for (int j = i - gap; j >= 0 && a[j] > a[j + gap]; j = j - gap) {
                    int temp = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = temp;
                }

            }
        }

        return a;
    }


    public static void main(String[] args) {
        int[] a = {21321, 21, 241, 435, 6547, 47, 234};
        sortByMyself(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
