package algorithm4.ch2.section3;

import algorithm4.ch2.section1.Insertion;

/**
 * @author qin
 * @date 2020-05-18
 */
public class Quick {
    private static final int INSERTION_SORT_THRESHOLD = 47;
    private Quick(){
    }

    public static void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // 闭区间
        // if(hi <= lo){return;}
        // 小于阈值用插入排序
        if(hi - lo < INSERTION_SORT_THRESHOLD){
            Insertion.sort(a);
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 随机化以消除对输入的依赖
        int pivot = (int)(Math.random()*(hi-lo)) +lo;
        exch(a,lo,pivot);
        Comparable v = a[lo];
        int i = lo,j = hi+1;
        // a[lo] 被跳过
        while (true){
            while (less(a[++i],v)){
                if(i == hi)
                    break;
            }
            while (less(v,a[--j])){
                if(j == lo)
                    break;
            }
            if(i >= j) break;
            exch(a,i,j); // 交换遇到的低索引大值 和 高索引小值
        }
        // 退出时 j 为 <=v 的最右索引     | <=v .j| >=v |
        exch(a,lo,j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void main(String[] args) {

//        int lo = 0;
//        int hi = 5;
//        for (int i = 0; i < 100; i++) {
//            System.out.print((int)(Math.random()*(hi-lo)) +lo);
//            System.out.print(" ");
//        }
        Integer[] arr = {1,35,5,13,4};
        Integer[] arr2 = {
                1,35,5,13,4,1,35,5,13,4,1,35,5,13,4,1,35,5,13,41,35,5,13,4,1,35,5,
                13,4,1,35,5,13,4,1,35,5,13,4,1,35,5,13,4,1,35,5,13,41,35,5,13,4,
                1,35,5,13,4,1,35,5,13,4,1,35,5,13,4,1,35,5,13,41,35,5,13,4,1,35,5,
                13,4,1,35,5,13,4,1,35,5,13,4,1,35,5,13,4,1,35,5,13,41,35,5,13,4,
                1,35,5,13,4,1,35,5,13,4,1,35,5,13,4,1,35,5,13,41,35,5,13,4,1,35,5,
                13,4,1,35,5,13,4,1,35,5,13,4,1,35,5,13,4,1,35,5,13,41,35,5,13,4
        };
        Quick.sort(arr2);
        for (Integer i:arr2) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
