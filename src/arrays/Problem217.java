package arrays;

import java.util.*;

public class Problem217 {
    //Time: nLogn
    //space: O(1)
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    //n
    public boolean containsDuplicateMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    //n
    public boolean containsDuplicateSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return nums.length - set.size() != 0;
    }
}
