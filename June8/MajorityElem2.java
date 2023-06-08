package June8;

import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class MajorityElem2 {
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        int candidate = 0;
        int count = 0;
        int candidate1 = 0;
        int count1 = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : arr) {
            if (candidate == num) {
                count++;
            } else if (candidate1 == num) {
                count1++;
            } else if (count == 0) {
                candidate = num;
                count++;
            } else if (count1 == 0) {
                candidate1 = num;
            } else {
                count--;
                count1--;
            }
        }
        int c = 0;
        for (int num : arr) {
            if (num == candidate)
                ++c;
        }
        int c1 = 0;
        for (int num : arr) {
            if (num == candidate1)
                ++c1;
        }
        if (c > (arr.size() / 3))
            ans.add(candidate);
        if (c1 > (arr.size() / 3))
            ans.add(candidate1);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");

        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter elements into arraylist");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        ArrayList<Integer> ans = majorityElementII(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}
