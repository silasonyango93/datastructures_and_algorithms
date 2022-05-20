package leetcode;


/*
* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
* */


public class ValidPalindrome {

    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        if (input.isEmpty()) {
            return true;
        }

        StringBuilder formattedString = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetterOrDigit(input.charAt(i))) {
                formattedString.append(input.charAt(i));
            }
        }

        formattedString = new StringBuilder(formattedString.toString().replace(" ","").toLowerCase());

        return formattedString.toString().equals(formattedString.reverse().toString());
    }
}

