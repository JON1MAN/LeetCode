package sliding_window;

import java.util.*;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() != right - left + 1) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            max = Math.max(max, map.size());
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("aaab"));
    }
}
