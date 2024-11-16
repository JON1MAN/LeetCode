package Java;

public class Problem1512 {

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int[] repeat = new int[101];

        for(int number : nums){
            count += repeat[number]++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1};
        Problem1512 problem1512 = new Problem1512();
        System.out.println(problem1512.numIdenticalPairs(nums));
    }

}
