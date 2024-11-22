package tp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        int result = 0;

        for(int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int difference = Math.abs(target - sum);

                if(difference < min) {
                    min = difference;
                    result = sum;

                    right--;
                    left++;
                } else if (difference == min){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
