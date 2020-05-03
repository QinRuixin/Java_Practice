package algorithm4.ch2.section2;

import java.util.Comparator;

/**
 * 自顶向下的归并排序
 * 递归
 *
 * 对于长度为 N 的任意数组，自顶向下的归并排序需要 1/2 NlgN 至 NlgN 次比较；
 *
 * 对于长度为 N 的任意数组，自顶向下的归并排序最多需要访问数组 6NlgN 次，
 * 每次6N 次 2N 复制， 2N 移动回去， 2N 比较
 *
 * 归并排序是一种渐进最优的基于比较排序的算法
 *
 * @author qin
 * @date 2020-05-03
 */
public class Merge {
    private static Comparable[] aux;

    private Merge(){}

    //  合并 [lo,mid] [mid+1,hi]
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++]; // 左边数组已结束
            else if (j > hi) a[k] = aux[i++];  // 右边数组已结束
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 自顶向下的归并排序
     * 递归
     */

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid, hi);
        merge(a, lo, mid, hi);
    }

    private static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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

}
