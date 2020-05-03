package algorithm4.ch2.section1;

import java.util.Comparator;

/**
 * 希尔排序
 * 思想是使数组中任意间隔为 h 的元素都是有序的，即得到 h 有序数组
 *
 * 每次利用插入排序完成
 *
 * 以下实现使用序列 1/2 * (3^k - 1)
 *
 * 复杂度 O(N^1.5)
 *
 * @author qin
 * @date 2020-05-03
 */
public class Shell {

    private Shell() {
    } // 避免被实例化


    private static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;   // 1, 4, 13, 40, 121, 364, 1093 ...

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                // 从 h 位置开始 一个个向后扫， 前 h-1 个可能被交换
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }

    }

    private static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;   // 1, 4, 13, 40, 121, 364, 1093 ...

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                // 从 h 位置开始 一个个向后扫， 前 h-1 个可能被交换
                for (int j = i; j >= h && less(a[h], a[j - h],comparator); j -= h) {
                    exch(a, h, j - h);
                }
            }
            h /= 3;
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
