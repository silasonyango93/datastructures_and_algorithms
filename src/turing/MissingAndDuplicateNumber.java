package turing;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
