package tp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem167 {

    //Two pointer approach:
    //Time O(n * logn)
    //Space O(1)
    public int[] twoSumBinarySearch(int[] numbers, int target) {
        int arrayLength = numbers.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            int current = numbers[i];
            int left = i + 1;
            int right = arrayLength;
            int searchable = target - current;
            while (left < right) {
                int med = (left + right) / 2;
                if (searchable < numbers[med]) {
                    right = med - 1;
                } else if (searchable > numbers[med]) {
                    left = med + 1;
                } else {
                    return new int[]{i + 1, med + 1};
                }
            }
        }
        return new int[]{1, 2};
    }

    //Two pointer approach:
    //Time O(n)
    //Space O(1)
    public int[] twoSumTwoPointer(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{1, 2};
    }
}
