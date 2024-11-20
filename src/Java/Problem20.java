package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem20 {
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        Stack<Character> braces = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('{', '}');
        pairs.put('[', ']');
        pairs.put('(', ')');

        char[] chars = s.toCharArray();
        for (char current : chars) {
            if (current == '}' ||
                current == ')' ||
                current == ']') {
                if (braces.empty() || current != braces.peek()) {
                    return false;
                } else {
                    braces.pop();
                }
            } else {
                braces.push(pairs.get(current));
            }
        }

        return braces.empty();
    }

    public static void main(String[] args) {
        String s = "()";
        Problem20 p = new Problem20();
        System.out.println(p.isValid(s));
    }
}
