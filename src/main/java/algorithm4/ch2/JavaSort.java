package algorithm4.ch2;

import java.util.Arrays;

/**
 * @author qin
 * @date 2020-05-18
 */
public class JavaSort {
    public static void main(String[] args) {
        int[] arr = {2,4,1,5,7};
        Arrays.sort(arr);
        // 较小（QUICKSORT_THRESHOLD = 286）直接用三向快速排序DualPivotQuicksort，
        // 其中再小（INSERTION_SORT_THRESHOLD = 47）用插入排序
        // 否则用归并排序
    }
}
