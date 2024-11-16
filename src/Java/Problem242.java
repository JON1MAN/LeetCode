package Java;

import java.util.Arrays;

public class Problem242 {

    public boolean isAnagram(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return first == second;
    }

    public static void main(String[] args) {
        Problem242 problem242 = new Problem242();
        System.out.println(problem242.isAnagram("ab", "a"));
    }

}
