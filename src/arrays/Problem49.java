package arrays;

import java.util.*;

public class Problem49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (var str : strs) {
            map.computeIfAbsent(getKey(str), k -> new ArrayList<>()).add(str);
        }

        return map.values().stream().toList();
    }

    private static String getKey(String str) {
        var strChars = str.toCharArray();
        var key = Arrays.copyOf(strChars, strChars.length);
        Arrays.sort(key);
        return Arrays.toString(key);
    }

    public static void main(String[] args) {
        String t1 = "eat";
        String t2 = "tea";
        System.out.println(groupAnagrams(new String[]{t1, t2}));
    }
}
