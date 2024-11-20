package Java;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2070 {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int q = queries.length;
        int n = items.length;
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        int[] maxBeauty = new int[n];
        maxBeauty[0] = items[0][1];
        for(int i = 1; i < n; i++) {
            maxBeauty[i] = Math.max(items[i][1], maxBeauty[i - 1]);
        }

        for (int i = 0; i < q; i++) {
            int price = queries[i];
            int right = n - 1;
            int left = 0;

            while (left <= right) {
                int mid = left + (right  - left)/ 2;
                if(items[mid][0] <= price) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (right >= 0) {
                queries[i] = maxBeauty[right];
            } else {
                queries[i] = 0;
            }
        }

        return queries;
    }

    public static void main(String[] args) {
        Problem2070 problem2070 = new Problem2070();
        int[][] items = {{1,2}, {3,2}, {2,4}, {5,6}, {3,5},};
        int[] result = problem2070.maximumBeauty(items, new int[]{1, 2, 3, 4, 5, 6});

        for (int i : result) {
            System.out.println(i);
        }
    }

}
