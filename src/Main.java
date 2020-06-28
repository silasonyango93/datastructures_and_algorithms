import trial_one.TrialOneBinarySearch;

import java.security.SecureRandom;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();
        int [] searchArray = new int[10000000];

        for (int i = 0;i < searchArray.length;i++) {
            searchArray[i] = 1000 + generator.nextInt(90000);
        }

        Arrays.sort(searchArray);
        System.out.printf("%s%n%n", Arrays.toString(searchArray));

        TrialOneBinarySearch.binarySearch(searchArray,2000);
    }
}
