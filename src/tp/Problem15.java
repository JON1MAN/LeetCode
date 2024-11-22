package tp;

import java.util.*;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return result;
        }

        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];
                if (current == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    left++;
                    right--;
                } else if (current > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result.stream()
                .distinct()
                .toList();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 0, 2, 2};
        Problem15 p = new Problem15();
        System.out.println(p.threeSum(nums).toString());
    }
}
