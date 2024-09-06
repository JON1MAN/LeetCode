package tp;

import java.util.Arrays;

public class Problem26 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 1){
            return n;
        }
        int count = 0;
        int left = 0;
        int right = 1;

        while(right < n){
            if(nums[left] != nums[right]){
                count++;
                nums[++left] = nums[right];
            }
            right++;
        }
        return count + 1;

    }

    public static void main(String[] args) {
        Problem26 problem26 = new Problem26();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(problem26.removeDuplicates(nums));
        System.out.println();
        Arrays.stream(nums)
                .forEach(s -> System.out.print(s + " "));
    }

}
