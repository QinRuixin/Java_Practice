package orther.alg;

/**
 * @author qin
 * @description 阿里笔试题2
 * 在一个数组中 寻找 i < j < k 且 a[i]<a[j]<a[k] 的一组序列，
 * 再这一系列中使得 b[i]+b[j]+b[k]最小。
 * 数据量 3000。
 *
 * 暴力 83%
 *
 *
 * @date 2021-03-19
 */
public class Ali20210319 {
    public static void main(String[] args) {

    }
}

/**
 笔试题1
 平方
 */
//public class Main {
//
//    static int getClosestGap(int[] powrList, int n){
//        if(n<=2){
//            return n-1;
//        }
//        int left = 0;
//        int right = powrList.length-1;
//        int mid = left+(right-left)/2;
//        while (left<right){
//            if(powrList[mid]==n){
//                return 0;
//            }else if(powrList[mid]<n){
//                left = mid+1;
//            }else {
//                right = mid;
//            }
//            mid = left+(right-left)/2;
//        }
//        if(powrList[right]-n > n-powrList[right-1]){
//            return  n-powrList[right-1];
//        }
//        return powrList[right]-n;
//
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        int[] gapVal = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int[] powrList= new int[31625];
//        for (int i = 0; i < 31625; i++) {
//            powrList[i] = (i+1)*(i+1);
//        }
//        for (int i = 0; i < n; i++) {
//            gapVal[i] = getClosestGap(powrList, a[i]);
//        }
//        Arrays.sort(gapVal);
//        int ans = 0;
//        for (int i=0; i<n/2; ++i){
//            ans += gapVal[i];
//        }
//        System.out.println(ans);
//
//
//    }
//}