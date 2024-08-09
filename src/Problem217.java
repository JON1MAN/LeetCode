import java.util.*;

public class Problem217 {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) >= 1) {
                return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        System.out.println(Problem217.containsDuplicate(num));
    }

}
