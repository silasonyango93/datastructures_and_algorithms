package smallest_positive_integer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class SmallestPositiveInteger {

    public int solution(int[] array) {

        HashSet<Integer> hashSet = new HashSet<>();

        if (array.length > 0) {
            int arraySize = array.length;
            Arrays.sort(array);

            int smallestValue = array[0];
            int largestValue = array[arraySize - 1];

            for (int i = 0; i < array.length; i++) {
                hashSet.add(array[i]);
            }

            for (int i = smallestValue; i < largestValue + 1; i++) {
               if (!hashSet.contains(i)) {
                   if (i < 0) {
                       return 1;
                   }
                   return i;
               }
            }

            if (smallestValue == 1) {
                return largestValue + 1;
            } else if (smallestValue < 1) {
                return 1;
            }
        }
        return -1;

    }


    @Test
    public void test_solution() {
        int [] array = {-1,-3};

        assert 1 == solution(array);
    }
}
