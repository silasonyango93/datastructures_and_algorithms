package turing;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given an unsorted array of size n. Array elements are in the range of 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.

Examples:

Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3
Explanation: In the array, 2 is missing and 3 occurs twice

Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1
* */

public class MissingAndDuplicateNumber {
    public int[] returnDuplicateAndMissingNumber(int[] arr) {
        int missingNumber = 0, duplicate = 0;

        Map<Integer, Boolean> numberMap
                = new HashMap<>();

        int max = arr.length;

        for (Integer i : arr) {

            if (numberMap.get(i) == null) {
                numberMap.put(i, true);
            } else {
                duplicate = i;
            }
        }
        for (int i = 1; i <= max; i++) {
            if (numberMap.get(i) == null) {
                missingNumber = i;
            }
        }
        return new int[]{duplicate, missingNumber};
    }

    @Test
    public void test() {
        assert Arrays.equals(new int[]{3, 5}, returnDuplicateAndMissingNumber(new int[]{1, 2, 3, 4, 3}));
        assert Arrays.equals(new int[]{2, 3}, returnDuplicateAndMissingNumber(new int[]{1, 2, 2}));
    }
}
