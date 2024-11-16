package Java;

import java.util.Locale;

public class Problem125 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase(Locale.ROOT);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                builder.append(c);
            }
        }
        s = builder.toString();
        int left = 0;
        int right = builder.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem125 problem125 = new Problem125();
        System.out.println(problem125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(problem125.isPalindrome("raceacar"));
    }

}
