package leetcode;

/*
*
* Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
* */
public class LongestPalindrome {


    public String longestPalidromicSubString(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < inputString.length(); i++) {
            int length1 = expandFromMiddle(inputString, i, i);
            int length2 = expandFromMiddle(inputString, i, i);
            int currentMaxLength = Math.max(length1,length2);

            if (currentMaxLength > (end - start)) {
                start = i - (currentMaxLength -1)/2;
                end = i + (currentMaxLength/2);
            }
        }

        return inputString.substring(start,end + 1);
    }


    public int expandFromMiddle(String inputString, int leftIndex, int rightIndex) {
        if (inputString == null || leftIndex > rightIndex) {
            return 0;
        }
        while (leftIndex >= 0 && rightIndex < inputString.length() && inputString.charAt(leftIndex) == inputString.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return rightIndex - leftIndex - 1;
    }
}
