package tp;

public class Problem42 {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        int sum = 0;
        int current = 0;

        while (current < n) {
            int left = current == 0 ? height[current] : Math.max(height[current - 1], height[current]);
            int right = current == n - 1 ? height[current] : Math.max(height[current + 1], height[current]);
            sum = Math.max(left, right) - height[current];
            current++;
        }
        return sum;
    }
}
