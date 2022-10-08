package turing;

import org.junit.Test;

import java.util.HashMap;

public class Exercise {

    public int solution(int [] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }

        Integer currentHighest = 0;
        for (Integer currentKey : map.keySet()) {
            if (map.get(currentKey) > currentHighest) {
                currentHighest = currentKey;
            }
        }

        if (map.get(currentHighest) < 2) {
            return 0;
        }

        int iterator = 0;
        for (Integer currentKey : map.keySet()) {
            if (map.get(currentKey).equals(map.get(currentHighest))) {
                iterator++;
                if (currentKey > currentHighest && iterator < 2) {
                    currentHighest = currentKey;
                } else {
                    return 0;
                }
            }
        }
        return currentHighest;
    }



    @Test
    public void test() {
        int res = solution(new int[] {1,2,5,9,2,7});
        assert 2 == solution(new int[] {1,2,5,9,2,7});

        assert 0 == solution(new int[] {1,3,2,5,4});

        assert 0 == solution(new int[] {1,2,5,2,5,9,5,7,9,7});

        assert 5 == solution(new int[] {1,2,3,2,3,5,4,5,6});
    }
}
