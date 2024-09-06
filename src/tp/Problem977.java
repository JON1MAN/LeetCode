package tp;

import java.util.Arrays;

public class Problem977 {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0 ;
        int right = n - 1;
        int[] result = new int[n];

        for(int p = n - 1; p >= 0; p--){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[p] = nums[left] * nums[left];
                left++;
            } else{
                result[p] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem977 problem977 = new Problem977();
        int[] nums = new int[]{-7,-3,2,3,11};
        nums = problem977.sortedSquares(nums);
        Arrays.stream(nums)
                .forEach(s -> System.out.print(s + " "));
    }


}
