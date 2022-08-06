package com.codedifferently.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem01 {
    /**
     *
     * @param input the string to be searched
     * @param letter the letter that you will search for
     * @return
     */
    public Integer countDuplicateLetters(String input, String letter){
        Map<Character, Integer> map = new HashMap<>();
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            Character current = input.charAt(i);
            int count = map.getOrDefault(current, 0);
            map.put(current, ++count);
        }
        return map.get(letter.charAt(0));
    }
}
