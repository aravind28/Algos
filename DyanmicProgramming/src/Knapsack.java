import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Knapsack {
    public static int findMaxValue(int[] weights, int[] values, int target) {
        int[][] result = new int[weights.length][target + 1];
        for (int i = 0; i < weights.length; i++) {
            result[i][0] = 0;
        }
        int x = 0;
        while (x <= target) {
            if ((x - weights[0]) < 0) {
                result[0][x] = 0;
            } else {
                result[0][x] = Math.max(0, values[0]);
            }
            x++;
        }
        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (weights[i] <= j) {
                    result[i][j] = Math.max((result[i - 1][j]), values[i] + result[i - 1][j - weights[i]]);
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println();
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(" " + result[i][j]);
            }
        }
        return result[weights.length - 1][target];
    }

    @Test
    public void threeItems() {
        int[] weights = new int[]{3, 4, 5};
        int[] values = new int[]{1, 5, 4};
        int target = 7;
        assertEquals(6, findMaxValue(weights, values, target));
    }

    @Test
    public void singleItem() {
        int[] weights = new int[]{3,};
        int[] values = new int[]{1};
        int target = 7;
        assertEquals(1, findMaxValue(weights, values, target));
    }
}
