package algorithm4.ch1_foundation;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class BinarySearch0 {
    public static int rank1(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int rank2(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi - lo > 1) {
            int mid = (lo + hi) / 2;
            // < is in the left
            if (key < a[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return key == a[lo] ? lo : -1;
    }

    public static void main(String[] args) {
        int[] whitelist = StdIn.readAllInts();
        Arrays.sort(whitelist);
        System.out.println(rank1(2, whitelist));
        System.out.println(rank2(2, whitelist));
    }
}
