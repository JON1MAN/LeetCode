import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem2070 {

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int[] answer = new int[n];
        Map<Integer, Integer> map = new LinkedHashMap<>();


        for (int[] item : items) {
            int key = item[0];
            int value = item[1];
            map.put(key, Math.max(map.getOrDefault(key, 0), value));
        }

        for(int i = 0; i < queries.length; i++) {
            int price = queries[i];
            queries[i] = 0;
            for (Map.Entry<Integer, Integer> set : map.entrySet()) {
                int key = set.getKey();
                int value = set.getValue();

                if (key <= price) {
                    queries[i] = Math.max(value, queries[i]);
                }
            }
        }
        return queries;
     }

    public static void main(String[] args) {
        int[][] items = {{1,2}, {3,2}, {2,4}, {5,6}, {3,5},};
        int[] result = Problem2070.maximumBeauty(items, new int[]{1, 2, 3, 4, 5, 6});

        for (int i : result) {
            System.out.println(i);
        }
    }

}
