package sliding_window;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {

        int[] array = new int[128];
        var s1_chars = s1.toCharArray();
        var s2_chars = s2.toCharArray();

        for(char curr : s1_chars) {
            ++array[curr];
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int n = s2.length();
        int counter = 0;

        while (right < n) {
            char curr = s2_chars[right];
            if (--array[curr] >= 0) {
                counter++;
            }
            while (counter == s1.length()) {
                int curLen = right - left + 1;
                min = Math.min(min, curLen);

                char leftChar = s2_chars[left];
                if(++array[leftChar] >= 0) {
                    counter--;
                }
                left++;
            }
            right++;
        }
        return min == s1.length();
    }

    public static void main(String[] args) {
        Problem567 problem567 = new Problem567();
        String s1 = "abc";
        String s2 = "ccccbbbbaaaa";
        System.out.println(problem567.checkInclusion(s1, s2));
    }
}
