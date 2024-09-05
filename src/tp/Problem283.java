package tp;

import java.util.Arrays;

public class Problem283 {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return;
        }
        int left = 0;
        int right = 1;
        while(right < n){
            if(nums[left] != 0){
                left++;
                right++;
            } else if(nums[right] == 0){
                right++;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Problem283 problem283 = new Problem283();
        int[] nums = new int[]{0,1,0,3,12};
        problem283.moveZeroes(nums);
        Arrays.stream(nums)
                .forEach(System.out::println);
    }

}
