package tp;

import java.util.*;

public class Problem763 {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[128];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            arr[chars[i]] = i;
        }

        List<Integer> answer = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;

        while (right < chars.length) {
            int current = arr[chars[right]];
            max = Math.max(max, current);
            if (max == right) {
                answer.add(right - left + 1);
                left = right + 1;
                max = Integer.MIN_VALUE;
            }
            right++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem763 problem763 = new Problem763();
        String s = "eccbbbbdec";
        problem763.partitionLabels(s).forEach(System.out::println);
    }
}
