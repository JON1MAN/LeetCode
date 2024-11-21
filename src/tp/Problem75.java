package tp;

public class Problem75 {
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
}
