package tp;

import java.util.*;

public class Problem15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            findTriplets(-nums[i], left, right, nums, triplets);
        }

        return triplets;
    }

    private static void findTriplets(int target, int left, int right, int[] nums, List<List<Integer>> triplets) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> currentTriplets = new ArrayList<>();
                currentTriplets.add(-target);
                currentTriplets.add(nums[left]);
                currentTriplets.add(nums[right]);
                triplets.add(currentTriplets);

                while (right > left && nums[right] == nums[right - 1]) right--;
                while (left < right && nums[left] == nums[left + 1]) left++;

                right--;
                left++;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,1,2};
        var result = threeSum(nums);
        result.forEach(System.out::println);
    }
}
