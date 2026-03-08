package arrays;

/*
TODO:
 s = "ab"
 t = "baab"
      0123
      a - 1, 2
      b - 0, 3
      "aaaaaa"
      "bbaaaa"
       012345
       a - 2, 3, 4, 5
       b - 0, 1
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem392 {
    public static boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> lettersWithPositions = generateLetterWithPositionsMap(t);

        int lastMax = Integer.MIN_VALUE;
        for (char letter : s.toCharArray()) {
            var positions = lettersWithPositions.get(letter);
            if (positions == null) {
                return false;
            }
            int finalLastMax = lastMax;
            var firstHigherThenMax = positions.stream()
                    .filter(position -> position > finalLastMax)
                    .findFirst();
            if (firstHigherThenMax.isEmpty()) {
                return false;
            }
            lastMax = firstHigherThenMax.get();
        }
        return true;
    }

    public static boolean isSubsequenceV2(String s, String t) {
        if (s.isEmpty()) return true;
        int pointerS = 0;
        int pointerT = 0;
        while (pointerT < t.length()) {
            if (t.charAt(pointerT) == s.charAt(pointerS)) {
                pointerS++;
                if (pointerS == s.length()) return true;
            }
            pointerT++;
        }
        return true;
    }

    private static Map<Character, List<Integer>> generateLetterWithPositionsMap(String t) {
        Map<Character, List<Integer>> lettersWithPositions = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            lettersWithPositions.computeIfAbsent(letter, k -> new ArrayList<>())
                    .add(i);
        }
        return lettersWithPositions;
    }

    public static void main(String[] args) {
        String s = "aaaaaa";
        String t = "bbaaaa";
        System.out.println(isSubsequence(s, t));
    }
}
