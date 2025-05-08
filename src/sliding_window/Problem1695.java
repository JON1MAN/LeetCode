package sliding_window;

import java.util.*;

public class Problem1695 {
    public static int maximumUniqueSubarray(int[] nums) {
        int numsLength = nums.length;

        if (numsLength == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int result = 0;
        int maxScore = 0;
        while (right < numsLength){
            int current = nums[right];
            map.put(current, map.getOrDefault(current, 0) + 1);
            int count = map.get(current);

            maxScore += current;
            if (count < 2) {
                result = Math.max(result, maxScore);
            } else {
                while (map.get(current) >= 2) {
                    int leftValue = nums[left];
                    map.put(leftValue, map.getOrDefault(leftValue, 0) - 1);
                    maxScore -= nums[left];
                    left++;
                }
            }
            right++;
        }

        return result;
    }

    public static int maximumUniqueSubarrayWithSet(int[] nums) {
        int maxScore = 0;
        int result = 0;

        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            while (!set.add(nums[right])) {
                maxScore -= nums[left];
                set.remove(nums[left]);
            }
            maxScore += nums[right];
            set.add(nums[right]);
            right++;
            result = Math.max(result, maxScore);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }
}
