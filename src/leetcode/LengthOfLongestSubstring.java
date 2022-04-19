package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String inputString) {
        int inputStringLength = inputString.length();
        HashSet<Character> hashSet = new HashSet<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int maxSubStringLength = 0;

        while (rightPointer < inputStringLength) {
            if (!hashSet.contains(inputString.charAt(rightPointer))) {
                hashSet.add(inputString.charAt(rightPointer));
                rightPointer++;
                maxSubStringLength = Math.max(hashSet.size(),maxSubStringLength);
            } else {
                hashSet.remove(inputString.charAt(leftPointer));
                leftPointer++;
            }
        }
        return maxSubStringLength;
    }

    @Test
    public void test_longestSubString() {
        String string = "dvdf";

        assert 3 == lengthOfLongestSubstring(string);
    }
}
