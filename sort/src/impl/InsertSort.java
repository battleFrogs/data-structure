package impl;

/**
 * 插入排序  前头一定是按顺序排列
 * 一旦遇到 当前位与前头位比较 一旦比前头位小，就交换位置 ，
 * 比较索引位 【1,0】 第一次从1号位索引开始与前头所有值比较
 * 【2,1】 , 【1,0】  第二次 从二号位索引开始与前头比较 小就交换位置，然后拿1号位索引去和0号位索引比较，如大就退出
 * 【3,2】 , 【2,1】 , 【1,0】
 */
public class InsertSort extends Base{

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
//        Comparable[] a = {1, 2, 24, 34, 343, 3, 234234, 444, 324};
//        sort(a);
//        show(a);

        int[] a = {12, 3, 24534, 435345, 34634534, 444, 443};
        a = sortMySelf(a);
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println(i1);
        }
    }

    public static int[] sortMySelf(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i ; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        return a;
    }

}
