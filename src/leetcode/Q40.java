package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qin
 * @date 2020-09-10
 */
public class Q40 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> curCombination = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;

    }

    void dfs(int[] candidates, int idx, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curCombination));
            return;
        }
        if (target < 0 || idx >= candidates.length) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            // 剪枝
            if (candidates[i] > target) {
                break;
            }
            // 去重
            if (i != idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curCombination.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i]);
            curCombination.remove(curCombination.size() - 1);
        }
    }
}
