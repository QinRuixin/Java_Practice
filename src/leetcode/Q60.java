package leetcode;

import java.util.ArrayList;

/**
 * @author qin
 * @date 2020-09-05
 */
public class Q60 {
    public static String getPermutation(int n, int k) {
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = factorials[i-1]*i;
        }
        int[] used = new int[n+1];
        StringBuilder tempRes = new StringBuilder();
        while( n>0 ) {
            int a0 = (k+factorials[n-1]-1) / factorials[n-1];
            tempRes.append(getNum(used,a0));
            k -= (a0 - 1) * factorials[n-1];
            n = n-1;
        }
        return tempRes.toString();

    }

    static int getNum(int[] used,int rank){
        for (int i = 1; i < used.length; i++) {
            if(used[i]==1){
                continue;
            }
            if(rank==1){
                used[i] = 1;
                return i;
            }else {
                rank--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;


        System.out.println(getPermutation(n,k));



    }
}
