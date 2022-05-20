package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i],1,Integer::sum);
        }

        for (Integer currentKey : map.keySet()) {
            if (map.get(currentKey) > 1) {
                return true;
            }
        }
        return false;
    }

}
