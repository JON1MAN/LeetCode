package Strings;

public class Problem1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }

        if (word1.length() > word2.length()) {
            result.append(word1.substring(minLength));
        } else {
            result.append(word2.substring(minLength));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";

        Problem1768 problem1768 = new Problem1768();

        System.out.println("Result = " + problem1768.mergeAlternately(word1, word2));
    }
}
