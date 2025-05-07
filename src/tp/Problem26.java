package tp;

public class Problem26 {
    //Two pointer (i, k)
    //Time O(n)
    //Space O(1)
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
