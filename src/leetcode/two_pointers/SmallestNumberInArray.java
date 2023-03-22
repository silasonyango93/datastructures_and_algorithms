package leetcode.two_pointers;

import org.junit.Test;

import java.util.Arrays;

public class SmallestNumberInArray {
    public int solution(int[] A) {
        // Implement your solution here
        if (A.length == 0) {
            return 0;
        }

        boolean hasAPositiveInteger = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > -1) {
                hasAPositiveInteger = true;
            }
        }
        if (!hasAPositiveInteger) {
            return 1;
        }
        Arrays.sort(A);
        int left = 0;
        int right = 1;

        while (right < A.length) {
            int difference = A[right] - A[left];
            if (difference > 1) {
                return A[left] + 1;
            }
            left++;
            right++;
        }
        return right + 1;
    }

    @Test
    public void testSolution() {
        int[] array1 = new int[]{1, 3, 6, 4, 1, 2}; //Expected 5
        int[] array2 = new int[]{1, 2, 3}; //Expected 4
        int[] array3 = new int[]{-1, -3};   //Expected 1
        System.out.println();
        assert 4 == solution(array2);
    }
}
