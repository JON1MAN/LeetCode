package tp;

public class Problem125 {

    //Two pointers
    //Time O(n)
    //Space O(1)
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char s_character = s.charAt(i);
            if (Character.isLetterOrDigit(s_character)) {
                builder.append(s_character);
            }
        }

        int left = 0;
        int right = builder.length() - 1;
        String palindromic = builder.toString();
        System.out.println(palindromic);
        while (left <= right) {
            char leftChar = palindromic.charAt(left);
            char rightChar = palindromic.charAt(right);
            if (leftChar == rightChar) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
