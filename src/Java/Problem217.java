package Java;

import java.util.HashMap;
import java.util.Map;

public class Problem217 {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> resultmap = new HashMap<>();
        for(int num : nums){

            if(resultmap.containsKey(num) && resultmap.get(num) > 1){
                return true;
            }
            resultmap.put(num, resultmap.getOrDefault(num, 1) + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        System.out.println(Problem217.containsDuplicate(num));
    }

}
