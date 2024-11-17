package repeat.week1;

public class P26 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int n = nums.length;

        int left = 0;
        int right = 1;

        while (left < right && right < n) {
            if (nums[right] != nums[left]) {
                nums[k] = nums[right];
                left = right;
                k += 1;
            }
            right++;
        }
        return k;
    }
}

