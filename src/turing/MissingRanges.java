package turing;

/*
* Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return [“2”, “4->49”, “51->74”, “76->99”].
* */

import java.util.LinkedList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<String>();
        if (nums.length == 0) {
            findRange(result, lower, upper);
            return result;
        }
        if (nums[0] != Integer.MIN_VALUE) {
            findRange(result, lower, nums[0] - 1);
        }
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] == nums[i+1]) {
                continue;
            }
            findRange(result, nums[i] + 1, nums[i+1] - 1);
        }
        if (nums[nums.length - 1] != Integer.MAX_VALUE) {
            findRange(result, nums[nums.length - 1] + 1, upper);
        }

        return result;
    }
    private void findRange(List<String> result, int low, int up) {
        if (low > up){
            return;
        }
        if (low == up) {
            result.add((low) + "");
            return;
        }
        result.add(low + "->" + up);
    }
}
