package leetcode;

import org.junit.Test;

import java.util.HashMap;

/*
* Determine if a given word can be constructed from a scrambled string.
*
* */

public class ScrambledStringSubset {

    public boolean isASubSet(String scrambledString, String word) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            map.merge(word.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < scrambledString.length(); i++) {
            map.merge(scrambledString.charAt(i), -1, Integer::sum);
        }

        for (Character key : map.keySet()) {
            if (map.get(key) > 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test_IsASubSet() {
        assert isASubSet("tsfssvbjjjjacxxfbbbn", "bac");
        assert !isASubSet("tsfssvbjjjjacxxfbbbn", "bacz");
    }
}
