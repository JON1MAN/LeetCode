package arrays;

public class Problem605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowerbedLength = flowerbed.length;
        int countFlowers = 0;

        for (int i = 0; i < flowerbedLength && countFlowers < n; i++) {
            if (flowerbed[i] == 0) {
                int next = (i == flowerbedLength - 1) ? 0 : flowerbed[i + 1];
                int previous = (i == 0) ? 0 : flowerbed[i - 1];

                if (next == 0 && previous == 0) {
                    countFlowers++;
                }
            }
        }

        return countFlowers == n;
    }

    public static void main(String[] args) {
        Problem605 p = new Problem605();
        int[] flowerbed = {0, 1, 0};
        int n = 2;
        System.out.println(p.canPlaceFlowers(flowerbed, n));
    }
}
