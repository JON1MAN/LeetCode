package sliding_window;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }

        var array = s2.getBytes();
        var s1_bytes = s1.getBytes();

        int target = IntStream.range(0, s1_bytes.length)
                .map(i -> s1_bytes[i])
                .sum();

        int n = s2.length();
        int left = 0;
        int right = s1.length() - 1;

        while (right < n) {
            int sum = IntStream.range(left, right + 1)
                    .map(i -> array[i])
                    .sum();
            if(target == sum) {
                return true;
            } else {
                right++;
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem567 problem567 = new Problem567();
        String s1 = "abc";
        String s2 = "ccccbbbbaaaa";
        System.out.println(problem567.checkInclusion(s1, s2));
    }
}
