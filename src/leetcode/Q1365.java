package leetcode;

/**
 * @author qin
 * @date 2020-10-26
 */
public class Q1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int i = 0; i < 101; ++i) {
            count[i] = 0;
        }
        for (int i = 0; i < nums.length; ++i) {
            count[nums[i]]++;
        }
        int lessThan[] = new int[101];
        ;
        for (int i = 1; i < 101; ++i) {
            lessThan[i] = lessThan[i - 1] + count[i - 1];
        }
        int res[] = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            res[i] = lessThan[nums[i]];
        }
        return res;

    }

}
