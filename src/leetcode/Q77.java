package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qin
 * @date 2020-09-08
 */
public class Q77 {
    public static void main(String[] args) {
        Q77 test = new Q77();
        List<List<Integer>> combine = test.combine(4, 2);
        for (int i = 0; i < combine.size(); i++) {
            for (int j = 0; j < combine.get(i).size(); j++) {
                System.out.print(combine.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private int[] used;
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> curCombine = new ArrayList<>();

    private void backtrace( int curIdx, int n, int k, int[] used) {
        // 剪枝
        if (curCombine.size() + (n - curIdx + 1) < k) {
            return;
        }
        if (curCombine.size() == k) {
            res.add(new ArrayList<>(curCombine));
        }
        if (curIdx > n) {
            return;
        }
        for (int i = curIdx; i < n + 1; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                curCombine.add(i);
                backtrace(i + 1, n, k, used);
                curCombine.remove(curCombine.size() - 1);
                used[i] = 0;
            }
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        used = new int[n + 1];
        backtrace(1, n, k, used);
        return res;
    }
}
