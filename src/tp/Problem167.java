package tp;

public class Problem167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{++left, ++right};
            }
            if (sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

}
