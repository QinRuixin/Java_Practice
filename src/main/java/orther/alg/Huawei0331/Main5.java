package orther.alg.Huawei0331;

import java.util.Scanner;

public class Main5 {

    static String s1, s2;
    static int res = Integer.MAX_VALUE;
    static int[][] memo;
    private static int dfs(int curP1, int curP2, int curStep){
        if(memo[curP1][curP2]!=-1){
            return memo[curP1][curP2];
        }
        if(curP2>=s2.length()){
            if(curStep<res){
                res = curStep;
                memo[curP1][curP2] = curStep;
            }
            return curStep;
        }
        if(s1.charAt(curP1)==s2.charAt(curP2)){
            if(memo[curP1][curP2]==-1){
                memo[curP1][curP2] = dfs(curP1, curP2+1, curStep);
            }
            return memo[curP1][curP2];
        }
        int leftStep = 0;
        int curP1Left = curP1;
        while (s1.charAt(curP1Left)!=s2.charAt(curP2)){
            curP1Left = (curP1Left+1)%s1.length();
            leftStep++;
        }
        if(memo[curP1Left][curP2+1]==-1){
           memo[curP1Left][curP2+1] = dfs(curP1Left,curP2+1,curStep+leftStep);
        }
        int leftVal = memo[curP1Left][curP2+1];

        int rightStep = 0;
        int curP1Right = curP1;
        while (s1.charAt(curP1Right)!=s2.charAt(curP2)){
            curP1Right--;
            if(curP1Right==-1){
                curP1Right = s1.length()-1;
            }
            rightStep++;
        }
        if(memo[curP1Right][curP2+1]==-1){
            memo[curP1Right][curP2+1]=dfs(curP1Right,curP2+1,curStep+rightStep);
        }
        int rightVal = memo[curP1Right][curP2+1];
        if(memo[curP1][curP2]==-1){
            memo[curP1][curP2] = Math.min(leftVal-leftStep,rightVal-rightStep);
        }
        return memo[curP1][curP2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine();
        s2 = sc.nextLine();
        int point = sc.nextInt();
        memo = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        dfs(point,0,0);
        System.out.println(res);
    }
}
