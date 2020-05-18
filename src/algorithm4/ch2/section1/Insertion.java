package algorithm4.ch2.section1;

import java.util.Comparator;

/**
 * 选择排序
 * 特点：
 * 1. 稳定              // 5^ 4 5 2 1
 * <p>
 * 复杂度分析：
 * 最好情况：O(N)     // 比较 N - 1 次
 * 最坏情况：O(N^2)     // 比较 N^2 / 2 次
 * 平均情况：O(N^2)     // 比较 N^2 / 4 次
 *
 * @author qin
 * @date 2020-05-02
 */
public class Insertion {
    private Insertion() {
    } // 避免被实例化


    public static void sort(Comparable[] a) {
        int N = a.length;
        int exchanges = 0;
        // 将最小的元素作为哨兵置于最左边
        for (int i = N - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i - 1);
                ++exchanges;
            }
        }
        if(exchanges==0){
            return;
        }
        // 前两个已有序
        for (int i = 2; i < N; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j-1])){
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }

        assert isSorted(a);
    }

    private static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        int exchanges = 0;
        // 将最小的元素作为哨兵置于最左边
        for (int i = N - 1; i > 0; i--) {
            if (less(a[i], a[i - 1],comparator)) {
                exch(a, i, i - 1);
                ++exchanges;
            }
        }
        if(exchanges==0){
            return;
        }
        // 前两个已有序
        for (int i = 2; i < N; i++) {
            Object v = a[i];
            int j = i;
            while (less(v, a[j-1],comparator)){
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }

//        assert isSorted(a,comparator);
    }

    private static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void exch(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"hello2", "world", "hello1"};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
