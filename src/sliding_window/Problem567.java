package sliding_window;

public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }

        int n = s2.length();
        StringBuilder stringBuilder = new StringBuilder(s2);
        stringBuilder.reverse();
        int left = 0;
        int right = s1.length() - 1;

        while (right < n) {
            if(s1.equals(stringBuilder.substring(left, right + 1))) {
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
        String s1 = "ab";
        String s2 = "eidbaoo";
        System.out.println(s2.substring(0, 1));
        System.out.println(problem567.checkInclusion(s1, s2));
    }
}
