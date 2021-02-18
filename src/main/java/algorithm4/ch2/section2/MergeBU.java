package algorithm4.ch2.section2;

/**
 * 自底向上的归并排序
 * 迭代
 *
 * @author qin
 * @date 2020-05-03
 */
public class MergeBU {
    private static Comparable[] aux;

    private MergeBU() {
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }

    }

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

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
