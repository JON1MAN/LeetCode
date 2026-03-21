package arrays;
import java.util.Arrays;

public class Problem238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = generateArrayWithOnes(nums.length);
        int prefix = 1;
        int suffix = 1;
        int left = 0;
        int length = nums.length;
        int right = length - 1;
        while (left != length && right != -1) {
            result[left] *= prefix;
            prefix *= nums[left];
            left++;
            result[right] *= suffix;
            suffix *= nums[right];
            right--;
        }
        return result;
    }

    private static int[] generateArrayWithOnes(int length) {
        int[] nums = new int[length];
        Arrays.fill(nums, 1);
        return nums;
    }

    public static void main(String[] args) {
        Problem238 problem238 = new Problem238();
        int[] test = new int[]{1, 2, 3, 4};
        System.out.println(problem238.productExceptSelf(test));
    }
}
