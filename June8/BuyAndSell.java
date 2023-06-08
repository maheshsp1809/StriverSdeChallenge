package June8;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class BuyAndSell {
    public static int maximumProfit(ArrayList<Integer> prices) {
        int minTillnow = prices.get(0);
        int ans = 0;
        for (int i = 0; i < prices.size(); ++i) {
            ans = Math.max(ans, prices.get(i) - minTillnow);
            minTillnow = Math.min(minTillnow, prices.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of days");
        int n = sc.nextInt();
        ArrayList<Integer> prices = new ArrayList<>();
        System.out.println("Enter the prices");
        for (int i = 0; i < n; i++) {
            prices.add(sc.nextInt());

        }
        System.out.println(maximumProfit(prices));

    }
}
