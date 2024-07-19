package org.waysTech;

public class KnapSackAlgorithm {
    public static int knapsack(int[] weights, int[] values, int maxCapacity) {
        int itemCount = weights.length;
        int[][] dp = new int[itemCount + 1][maxCapacity + 1];

        for (int i = 0; i <= itemCount; i++) {
            for (int capacity = 0; capacity <= maxCapacity; capacity++) {
                if (i == 0 || capacity == 0) {
                    dp[i][capacity] = 0;
                } else if (weights[i - 1] <= capacity) {
                    dp[i][capacity] = Math.max(values[i - 1] + dp[i - 1][capacity - weights[i - 1]], dp[i - 1][capacity]);
                } else {
                    dp[i][capacity] = dp[i - 1][capacity];
                }
            }
        }

        return dp[itemCount][maxCapacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 4, 5, 7, 1, 3};
        int[] values = {30, 10, 20, 50, 60, 40};
        int maxCapacity = 15;
        System.out.println("Maximum value in Knapsack = " + knapsack(weights, values, maxCapacity));
    }
}
