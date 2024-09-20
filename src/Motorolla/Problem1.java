package Motorolla;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public static int solution(String S) {
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        int max = 0;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            switch (c){
                case '^' :
                    up++;
                    break;
                case 'v' :
                    down++;
                    break;
                case '>' :
                    right++;
                    break;
                case '<' :
                    left++;
                    break;
            }
        }
        max = Math.max(Math.max(up, down), Math.max(left, right));
        return S.length() - max;
    }

    public static void main(String[] args) {
        String S = "^><^^";
        System.out.println(Problem1.solution(S));
    }
}

/*
^><^^
 */
