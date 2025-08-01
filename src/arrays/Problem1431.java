package arrays;

import java.util.ArrayList;
import java.util.List;

public class Problem1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = Integer.MIN_VALUE;
        List<Boolean> result = new ArrayList<>();

        for (var candy : candies) {
            if (candy >= maxCandy) maxCandy = candy;
        }

        for (int candy : candies) {
            int currentCandy = extraCandies + candy;
            if (currentCandy >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
