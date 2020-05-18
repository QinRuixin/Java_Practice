package algorithm4.ch2.section3;

/**
 * @author qin
 * @date 2020-05-18
 */
public class Quick3way {
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;   // 三指针
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a,lt++,i++);
            } else if (cmp > 0){
                exch(a,i,gt--);
            }else {
                ++i;
            }
        }   // 现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi] 成立
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }


    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
