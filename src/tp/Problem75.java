package tp;

public class Problem75 {

    //without two pointers
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            switch (current) {
                case (0) -> zero++;
                case (1) -> one++;
                case (2) -> two++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero != 0) {
                nums[i] = 0;
                zero--;
            } else if (zero == 0 && one != 0) {
                nums[i] = 1;
                one--;
            } else {
                nums[i] = 2;
                two--;
            }
        }
    }

    //two pointer (three)
    public void sortColors2(int[] nums) {
        int left = 0;
        int mid = 0;
        int temp = 0;
        int right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                temp = nums[mid];
                nums[mid] = nums[left];
                nums[right] = temp;
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }
}
