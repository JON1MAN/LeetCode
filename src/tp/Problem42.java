package tp;

public class Problem42 {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        int sum = 0;
        int[] Left = new int[n];
        int[] Right = new int[n];

        for (int i = 0; i < n; i ++) {
            Left[i] = i == 0 ? height[i] : Math.max(height[i - 1], height[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            Right[i] = i == n - 1 ? height[i] : Math.max(height[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++){
            sum += Math.min(Right[i], Left[i]) - height[i];
        }

        return sum;
    }
}
