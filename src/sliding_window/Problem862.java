package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem862 {
    public int shortestSubarray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            sum += nums[right];
            while (sum >= k) {
                sum -= nums[left];
                min = Math.min(min, right - left + 1);
                left++;
            }
            right++;
        }
        return min;
    }

    public static void main(String[] args) {
        Problem862 problem862 = new Problem862();
        int[] nums = new int[]{2, -1, 2, 3};
        int k = 3;
        System.out.println(problem862.shortestSubarray(nums, k));

    }
}
