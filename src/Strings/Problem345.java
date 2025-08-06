package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem345 {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>(
                List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        );
        char[] chars = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char leftChar = chars[l];
            char rightChar = chars[r];
            while (!vowels.contains(leftChar) && l < r) {
                l++;
                leftChar = chars[l];
            }

            while (!vowels.contains(rightChar) && l < r) {
                r--;
                rightChar = chars[r];
            }

            chars[l] = rightChar;
            chars[r] = leftChar;
            r--;
            l++;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Problem345 p = new Problem345();
        System.out.println(p.reverseVowels("hello"));
    }
}
