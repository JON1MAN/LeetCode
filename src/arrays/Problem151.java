package arrays;

import java.util.Arrays;

public class Problem151 {
    public String reverseWords(String s) {
        var words = s.trim()
                .split(" +");

        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
