package Strings;

public class Problem5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int odd = checkPalindrome(i, i, s);
            int even = checkPalindrome(i, i + 1, s);

            int max = Math.max(odd, even);

            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int checkPalindrome(int left, int right, String s) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        System.out.println(problem5.longestPalindrome("aa"));
    }
}

