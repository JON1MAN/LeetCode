package sliding_window;

public class Problem209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        Problem209 problem209 = new Problem209();
        int[] nums = new int[]{1, 1, 1, 1, 3};
        int target = 3;
        System.out.println(problem209.minSubArrayLen(target, nums));
    }
}
