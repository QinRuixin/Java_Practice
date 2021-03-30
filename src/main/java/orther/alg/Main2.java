package orther.alg;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int N_num = s.charAt(N-1)-'0';
        int start_num = s.charAt(0)-'0';
        if (start_num == N_num) {
            System.out.println(1);
            return;
        }
        int[][] vec = new int[10][10];
        for (int i = 1; i < s.length(); i++) {
            vec[s.charAt(i-1)-'0'][s.charAt(i)-'0']=1;
        }
        if(vec[start_num][N_num]==1){
            System.out.println(2);
            return;
        }else {
            for (int i = 0; i < 10; i++) {
                if(vec[start_num][i]==1 && vec[i][N_num]==1){
                    System.out.println(3);
                    return;
                }
            }
        }

        System.out.println(4);
    }
}

//        int MOD_NUM = 1000000007;
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][][] dp =new int[n+1][m+1][m+1];
//        dp[0][0][0] = 1;
//        dp[1][1][0] = 1;
////        dp[2][2][0] = 1;
////        dp[3][2][1] = 1;
////        dp[3][1][2] = 1;
//        //dp[3][3][0] = 1;
//        for (int i = 2; i <= n; i++) {
//            for (int gap = 1; gap <= m; gap++) {
//                if(i-gap<0){
//                    break;
//                }
//                for (int j = 0; j <= m; j++) {
//                    if(gap!=j){
//                        for (int k = 0; k <= m; k++) {
//                            if(gap!=k){
//                                dp[i][gap][j] += dp[i-gap][j][k];
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        int ans = 0;
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= m; j++) {
//                ans += dp[n][i][j] % 1000000007;
//            }
//        }
//        System.out.println(ans % 1000000007);
