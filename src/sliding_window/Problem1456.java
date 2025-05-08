package sliding_window;

import java.util.ArrayList;
import java.util.List;

public class Problem1456 {
    public int maxVowels(String s, int k) {
        int stringLength = s.length();
        int left = 0;
        int right = k;
        int result = 0;
        List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                result++;
            }
        }

        int current = result;

        while (right < stringLength) {
            char leftChar = s.charAt(left++);
            char rightChar = s.charAt(right++);

            if (vowels.contains(leftChar)) {
                current--;
            }

            if (vowels.contains(rightChar)) {
                current++;
            }

            result = Math.max(result, current);
        }
        return result;
    }
}
