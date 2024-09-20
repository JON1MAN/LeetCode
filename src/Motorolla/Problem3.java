package Motorolla;

public class Problem3 {
    public static String solution(String S) {
        int left = 0;
        int right = S.length() - 1;
        char[] chars = S.toCharArray();
        if(S.length() % 2 == 1 && chars[S.length() / 2] == '?'){
            chars[S.length() / 2] = 'a';
        }
        while(left < right){
            char l = S.charAt(left);
            char r = S.charAt(right);
            if (l == '?' && r == '?') {
                chars[left] = 'a';
                chars[right] = 'a';
            }
            else if(l == '?'){
                chars[left] = r;
            } else if (r == '?') {
                chars[right] = l;
            } else if(l != r){
                return "NO";
            }
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(Problem3.solution("ba"));
    }
}
