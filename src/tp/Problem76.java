package tp;

import java.util.HashMap;
import java.util.Map;

public class Problem76 {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return "";
        }

        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        int remainingChars = n;
        int left = 0;
        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;

        for (int right = 0; right < m; right++) {
            char currentChar = s.charAt(right);
            if (charFrequency.containsKey(currentChar) && charFrequency.get(currentChar) > 0) {
                remainingChars--;
            }
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) - 1);
            if (remainingChars == 0) {
                while (true) {
                    char leftChar = s.charAt(left);
                    if (charFrequency.containsKey(leftChar) && charFrequency.get(leftChar) == 0) {
                        break;
                    }
                    charFrequency.put(leftChar, charFrequency.getOrDefault(leftChar, 0) + 1);
                    left++;
                }

                if (right - left < minEnd - minStart) {
                    minEnd = right;
                    minStart = left;
                }

                charFrequency.put(s.charAt(left), charFrequency.getOrDefault(s.charAt(left), 0) + 1);
                remainingChars++;
                left++;
            }
        }

        return minEnd >= m ? "" : s.substring(minStart, minEnd + 1);
    }
}
