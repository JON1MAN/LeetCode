package tp;

import java.util.Arrays;

public class Problem27 {
    //Two pointers
    //Time O(n)
    //Space O(1)
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
