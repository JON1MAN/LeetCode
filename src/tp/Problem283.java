package tp;

import java.util.Arrays;

public class Problem283 {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int k = 0;
        if (n < 2) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < n; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroesUpdate(int[] nums) {
        int n = nums.length;
        int k = 0;
        if (n < 2) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                k++;
            } else if (k > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        Arrays.stream(nums)
                .forEach(System.out::println);
    }
}
