package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int count = k;
        int[] answer = new int[n];
        if (k == 0) {
            return new int[n];
        } else if (k > 0) {
            for (int i = 0; i < n; i++) {
                int start = i + 1;
                while (count != 0) {
                    if (start > n - 1) {
                        start = 0;
                    }
                    answer[i] += code[start];
                    start++;
                    count--;
                }
                count = k;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int start = i - 1;
                while (count != 0) {
                    if (start < 0) {
                        start = n - 1;
                    }
                    answer[i] += code[start];
                    start--;
                    count++;
                }
                count = k;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] code = new int[]{2,4,9,3};
        int k = -2;
        Problem1652 problem1652 = new Problem1652();
        System.out.println(Arrays.toString(problem1652.decrypt(code, k)));
    }



}
