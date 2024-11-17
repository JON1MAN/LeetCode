package repeat.week1;

import java.util.HashMap;
import java.util.Map;

public class P3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int n = array.length;

        int left = 0;
        int right = 0;
        int max = 0;

        while (right < n) {
            map.put(array[right], map.getOrDefault(array[right], 0) + 1);
            while (right - left + 1 != map.size()) {
                map.put(array[left], map.get(array[left]) - 1);
                if (map.get(array[left]) == 0) {
                    map.remove(array[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        P3 p3 = new P3();
        String s = "abcabcbb";
        System.out.println(p3.lengthOfLongestSubstring(s));
    }
}
