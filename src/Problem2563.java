import java.util.Arrays;

public class Problem2563 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int low = lowerBound(nums, i + 1,  nums.length, lower - nums[i]);
            int up = upperBound(nums, i + 1, nums.length, upper - nums[i]);
            result += up - low;
        }
        return result;
    }

    public int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Problem2563 problem2563 = new Problem2563();
        int[] nums = {0,1,7,4,4,5};
        System.out.println(problem2563.countFairPairs(nums, 3, 6));
    }

}
