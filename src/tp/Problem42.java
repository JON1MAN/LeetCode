package tp;

public class Problem42 {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (height[max] < height[i]) {
                max = i;
            }
        }

        int left = 0;
        for (int i = 0; i < max; i++) {
            if (height[left] < height[i]) {
                left = i;
            }
            sum += height[left] - height[i];
        }

        int right = n - 1;
        for (int i = n - 1; i > max; i--) {
            if (height[right] < height[i]) {
                right = i;
            }
            sum += height[right] - height[i];
        }

        return sum;
    }
}
