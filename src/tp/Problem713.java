package tp;
import java.util.Arrays;

public class Problem713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n == 1) {
            return (nums[0] < k) ? 1 : 0;
        }

        int result = 0;
        int left = 0;
        int right = 0;
        int product = 1;

        while (left < n) {
            product *= nums[left];
            if (product < k) result++;
            while (right < n) {
                product *= nums[right];
                if (product < k) {
                    result++;
                } else {
                    product /= nums[right];
                    right++;
                }
                right++;
            }
            product = 1;
            left++;
            right = left + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}