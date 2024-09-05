import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int current = target - nums[i];
            if(map.containsKey(current)){
                return new int[]{i, map.get(current)};
            }
            else{
                map.put(nums[i], i);
            }
        }

        return new int[]{0,0};
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(Arrays.toString(problem1.twoSum(new int[]{3, 2, 4}, 6)));
    }

}
