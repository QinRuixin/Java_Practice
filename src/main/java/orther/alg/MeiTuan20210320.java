package orther.alg;

/**
 * @author qin
 * @description 美团笔试题
 *
 * 1. 流，模拟；
 * 2. 多重集合，不是特别优美，但还是过了，散列表存取模的数，找个最小的，然后一个个去比较，暴力，反正数据范围小；
 * 3. 奶茶，二分答案法，知道方法就一次 A 了；
 * 4. 值日，必然会出现循环；
 * 5. 溶液，模拟。
 *
 * 1 模拟a了  2 不会  3 题目不明  4 思路对的 没a  5 模拟几乎a了
 * @date 2021-03-20
 */
public class MeiTuan20210320 {
    public static void main(String[] args) {

    }

    public static void ans1() {
//        String s = sc.nextLine();
//        String a = sc.nextLine();
//        int ans = 0;
//        int idxS = 0, idxA = 0;
//        while (true){
//            if(s.charAt(idxS)==a.charAt(idxA)){
//                idxA++;
//            }else {
//                ans++;
//            }
//            if(idxA==a.length()){
//                break;
//            }
//            idxS = (idxS+1)%26;
//        }
//        System.out.println(ans);
    }

    public void ans2(){

    }

    public void ans3(){
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int C = sc.nextInt();
////        int[] tea = new int[m+1];
////        int[] times = new int[m+1];
//        int totalTime = 0;
//        for (int i = 1; i < m + 1; i++) {
////            times[i] = (sc.nextInt()+C-1)/C;
//            totalTime += (sc.nextInt()+C-1)/C;
//        }
//        System.out.println((totalTime+n-1)/n);
    }
    public void ans4(){

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long m = sc.nextLong();
//        int[][] a = new int[n+1][n+1];
//        int oneLoopNum = n*(n-1)+1;
//
//        for(int j = 1; j < n+1; j++ ){
//            for (int i = 1; i < n + 1; i++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        if(m<=2){
//            System.out.println(m);
//            return;
//        }
//        int first = 1;
//        int second = 2;
////        int [] tmpRes = new int[oneLoopNum];
//        ArrayList<Integer> tmpRes = new ArrayList<>();
//        tmpRes.add(1);
//        tmpRes.add(2);
//        int rightLoopNum = 2;
//        long cnt = m-2;
//        int ans = 0;
//        while(true){
//            rightLoopNum++;
//            if(a[first][second]<0){
//                rightLoopNum-=3;
//                break;
//            }
//            ans = a[first][second];
//            a[first][second] = -a[first][second];
//            tmpRes.add(ans);
//            first = second;
//            second = ans;
//            --cnt;
//            if(cnt==0){
//                System.out.println(ans);
//                return;
//            }
//        }
////        System.out.println(rightLoopNum);
//        System.out.println( tmpRes.get((int)(m-1)%rightLoopNum) );
    }
    public void ans5(){
//  见 Main
    }
}
