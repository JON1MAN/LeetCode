import java.util.*;

public class Problem217 {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        System.out.println(Problem217.containsDuplicate(num));
    }

}
