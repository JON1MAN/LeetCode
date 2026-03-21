package arrays;

import java.util.Arrays;

public class Problem58 {
    public int lengthOfLastWord(String s) {
        var unclearedWords = s.split(" +");
        return unclearedWords[unclearedWords.length - 1].length();
    }

    public int lengthOfLastWordFastest(String s) {
        var trimmed = s.trim();
        int lengthOfLast = 0;
        for (int i = trimmed.length() - 1; i >= 0; i--) {
            char currentLetter = trimmed.charAt(i);
            if (currentLetter != ' ' && Character.isAlphabetic(currentLetter)) {
                lengthOfLast++;
            } else {
                break;
            }
        }
        return lengthOfLast;
    }

    public static void main(String[] args) {
        var test = "   fly me   to   the moon.  ".trim();
        var splitted = test.split(" +");
        System.out.println(splitted.length);
        Arrays.stream(splitted).forEach(System.out::println);
    }
}
