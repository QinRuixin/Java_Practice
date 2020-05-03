package algorithm4.ch2.section1;

import java.util.Comparator;

/**
 * 选择排序
 * 特点：
 *      1. 运行时间与输入无关  // 比较 N^2 / 2 次
 *      2. 数据移动是最少的    // 交换 N 次
 *      3. 不稳定              // 5^ 4 5 2 1
 *
 * 复杂度分析：
 *      最好情况：O(N^2)
 *      最坏情况：O(N^2)
 *      平均情况：O(N^2)
 *
 * @author qin
 * @date 2020-05-02
 */
public class Selection {
    private Selection() {
    } // 避免被实例化


    private static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[minIdx])) {
                    minIdx = j;
                }
            }
            exch(a, i, minIdx);
        }
    }

    private static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[minIdx], comparator)) {
                    minIdx = j;
                }
            }
            exch(a, i, minIdx);
        }
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
