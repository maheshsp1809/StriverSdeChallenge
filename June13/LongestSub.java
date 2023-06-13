package June13;

import java.util.*;

public class LongestSub {
    public static int uniqueSubstrings(String input) {
        int i = 0, j = 0;
        int len = 0;
        int n = input.length();
        HashMap<Character, Integer> set = new HashMap<>();
        while (j < n) {
            if (set.containsKey(input.charAt(j))) {
                i = Math.max(set.get(input.charAt(j)) + 1, i);
            }
            set.put(input.charAt(j), j);
            len = Math.max(len, j - i + 1);
            ++j;
        }
        return len;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int result = uniqueSubstrings(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
