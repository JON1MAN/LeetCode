package repeat.week1;

import java.util.Arrays;

public class P2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long answer = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int low = lowerBound(nums, i + 1, lower - nums[i]);
            int up = upperBound(nums, i + 1, upper - nums[i]);
            answer += up - low;
        }
        return answer;
    }
    public int lowerBound(int[] nums, int start, int target) {
        int n = nums.length;
        while (start < n) {
            int mid = start + (n - start) / 2;
            if(nums[mid] >= target) {
                n = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int upperBound(int[] nums, int start, int target) {
        int n = nums.length;
        while (start < n) {
            int mid = start + (n - start) / 2;
            if(nums[mid] > target) {
                n = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
