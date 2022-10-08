package turing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MostRepeatingAlphabetCharacter {
    public String solution(String input) {

        input = input.replaceAll("[-+.^:,]","");
        input = input.replaceAll("\\d","");

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            map.merge(input.charAt(i), 1, Integer::sum);
        }

        int currentMax = 0;
        Character currentMostRepeatedCharacter = ' ';
        for (Character currentKey : map.keySet()) {
            if (map.get(currentKey) > currentMax) {
                currentMostRepeatedCharacter = currentKey;
                currentMax = map.get(currentKey);
            }
        }
        return currentMostRepeatedCharacter.toString();
    }

    @Test
    public void test() {
        String result = solution("abcddefda11113333");
        assert String.valueOf('d').equals(result);

        String result2 = solution("AA0AB0BB0ccc0aa0aw00woOBBBw123123");
        assert String.valueOf('B').equals(result2);
    }
}
