package leetcode.dynamic_programming;

import org.junit.Test;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int leftCouter = 0;
        int rightCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftCouter+= nums[0];
                continue;
            }
            if (i % 2 == 0) {
                leftCouter+= nums[i];
            } else {
                rightCounter+= nums[i];
            }
        }

        return Math.max(leftCouter, rightCounter);
    }

    @Test
    public void testSolution() {
        int[] array = new int[] {1,2,1,1};
        assert 2 == rob(array);
    }
}
