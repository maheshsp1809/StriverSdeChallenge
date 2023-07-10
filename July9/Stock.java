package July9;

import java.util.ArrayList;

public class Stock {
    public static int maximumProfit(ArrayList<Integer> prices) {
        int max = 0;
        int lmin = prices.get(0);
        for (int i = 1; i < prices.size(); ++i) {
            int diff = prices.get(i) - lmin;
            max = Math.max(diff, max);
            lmin = Math.min(lmin, prices.get(i));
        }
        return max;
    }

    public static void main(String[] args) {
        // Example test case
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(7);
        prices.add(1);
        prices.add(5);
        prices.add(3);
        prices.add(6);
        prices.add(4);

        int maxProfit = maximumProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
