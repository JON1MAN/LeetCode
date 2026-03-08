package arrays;

import java.util.Arrays;

public class Problem242 {
    public boolean isAnagram(String s, String t) {
        var sChars = s.toCharArray();
        var tChars = t.toCharArray();
        return Arrays.equals(sChars, tChars);
    }
}
