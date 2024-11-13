import java.util.*;

public class Problem2070 {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int[] answer = new int[n];

        Arrays.sort(queries);
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        for (int[] item : items) {
            System.out.println(Arrays.toString(item));
        }

        for (int i = 1; i < items.length - 1; i++) {
            items[i][1] = Math.max(items[i - 1][1], items[i][1]);
        }

        for (int[] item : items) {
            System.out.println(Arrays.toString(item));
        }

        for (int i = 0; i <= n - 1; i++) {
            int maxBeauty = binarySearch(items, queries[i]);
            answer[i] = maxBeauty;
        }

        return answer;
    }

    public int binarySearch(int[][] array, int price) {
        int maxBeauty = 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid][0] <= price) {
                maxBeauty = Math.max(maxBeauty, array[mid][1]);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxBeauty;
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
