package sliding_window;

public class Problem643 {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        double maxAvg = Double.NEGATIVE_INFINITY;
        double currentAvg = 0;
        int numsLength = nums.length;

        for (int i = 0; i < k; i++) {
            currentAvg += (double) nums[i] / k;
        }
        maxAvg = Math.max(maxAvg, currentAvg);
        System.out.println(maxAvg);
        int right = k;
        int left = 0;
        while (right < numsLength) {
            currentAvg -= (double) nums[left] / k;
            currentAvg += (double) nums[right] / k;
            maxAvg = Math.max(maxAvg, currentAvg);
            left++;
            right++;
        }

        return maxAvg;
    }
}
