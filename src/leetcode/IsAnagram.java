package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public boolean isAnagram(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            return false;
        }

        if (firstString.isEmpty() && secondString.isEmpty()) {
            return true;
        }

        if (firstString.equals(secondString)) {
            return true;
        }

        if (firstString.length() != secondString.length()) {
            return false;
        }

        Map<Character,Integer> firstStringMap = new HashMap<>();
        Map<Character,Integer> secondStringMap = new HashMap<>();

        for (int i = 0; i < firstString.length(); i++) {
            firstStringMap.merge(firstString.charAt(i),1,Integer::sum);
            secondStringMap.merge(secondString.charAt(i),1,Integer::sum);
        }

        for (Character currentCharacter : firstStringMap.keySet()) {
            if (!firstStringMap.get(currentCharacter).equals(secondStringMap.get(currentCharacter))) {
                return false;
            }
        }
        return true;
    }
}
