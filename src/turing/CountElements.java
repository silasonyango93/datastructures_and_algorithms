package turing;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*
* Given an integer array arr, count element x such that x + 1 is also in arr.If there're duplicates in arr, count them separately.

Example 1: Input: arr = [1,2,3] Output: 2 Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

Example 2: Input: arr = [1,1,2] Output: 2 Explanation: 1 counted twice cause 2 is in arr.

Example 3: Input: arr = [1,1,3,3,5,5,7,7] Output: 0 Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

Example 4: Input: arr = [1,1,2,2] Output: 2 Explanation: Two 1s are counted cause 2 is in arr.
* */

public class CountElements {
    public int countElements(int[] arr) {
        Set<Integer> lookup = new HashSet<>();
        for (Integer i : arr) {
            lookup.add(i);
        }
        int count = 0;
        for (Integer i : arr) {
            if (lookup.contains(i + 1)) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assert 2 == countElements(new int[]{1, 2, 3});
        assert 0 == countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7});
    }
}
