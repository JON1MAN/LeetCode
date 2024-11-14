package tp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem26 {

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int left = 0;
        int right = 1;
        while (left < right  && right < nums.length) {
            if(nums[left] != nums[right]) {
                nums[k] = nums[right];
                left = right;
                k++;
                right++;
            } else {
                right++;
            }
        }
        return k - 1;
    }

    public static void main(String[] args) {
        Problem26 problem26 = new Problem26();
        int[] nums = new int[]{1, 2};
        System.out.println(problem26.removeDuplicates(nums));
        System.out.println();
        Arrays.stream(nums)
                .forEach(s -> System.out.print(s + " "));
    }

}
