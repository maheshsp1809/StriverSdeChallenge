package June21;

import java.util.*;

public class MinimumCoins {
    public static void main(String[] args) {
        int amount = 267;
        int minimumCoins = findMinimumCoins(amount);
        System.out.println("Minimum number of coins needed: " + minimumCoins);
    }

    public static int findMinimumCoins(int amount) {
        int[] currency = new int[] { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };
        int count = 0;
        int i = 0;
        while (amount > 0 && i < 9) {
            if (amount < currency[i]) {
                i++;
                continue;
            }
            count++;
            amount -= currency[i];
        }
        return count;
    }
}
