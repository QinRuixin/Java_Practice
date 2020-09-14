package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qin
 * @date 2020-09-11
 */
public class Q216 {

    public static void main(String[] args) {
        Q216 test = new Q216();

        test.combinationSum3(3,7);
    }
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> curCombination = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 45) {
            return res;
        }

        dfs(1, k, n);
        return res;

    }

    private void dfs(int curNum, int k, int n) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(curCombination));
            return;
        }
        if (k < 0 || n < 0) {
            return;
        }
        for (int i = curNum; i < 10; i++) {
            if (curNum > n) {
                return;
            }
            curCombination.add(i);
            dfs(i + 1, k - 1, n - i);
            curCombination.remove(curCombination.size() - 1);
        }
    }
}
