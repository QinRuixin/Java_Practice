package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qin
 * @date 2020-09-09
 */
public class Q39 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5,7};
        Arrays.sort(nums);
    }

    private ArrayList<Integer> curCombine = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    private void backtrace(int[] candidates, int curIdx, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curCombine));
            return;
        }
        if (target < 0 || candidates[curIdx] > target) {
            return;
        }
        for (int i = curIdx; i < candidates.length; i++) {
            curCombine.add(candidates[i]);
            backtrace(candidates, i, target - candidates[i]);
            curCombine.remove(curCombine.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrace(candidates,0,target);
        return res;

    }
}
