package tp;

import java.util.Arrays;

public class Problem80 {

    public int removeDuplicates(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }
        int count = 0;
        int left = 0;
        int right = 1;

        while(right < nums.length){
            if(nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
                count = 0;
            } else if (nums[left] == nums[right] && count < 1) {
                nums[++left] = nums[right];
                count++;
            }
            right++;

        }
        return left + 1;
    }

    public static void main(String[] args) {
        Problem80 problem80 = new Problem80();
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(problem80.removeDuplicates(nums));
        Arrays.stream(nums)
                .forEach(s -> System.out.print(s + " "));
    }

}

/*
0,0,1,1,2,3,3,3,3
            ^   ^
counter = 1
 */
