package June5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Duplicate {
    public static int findDuplicate(ArrayList<Integer> arr, int n) {
        Set<Integer> un = new HashSet<>();
        for (int num : arr) {
            if (!un.add(num))
                return num;
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(2);
        array.add(5);
        array.add(6);
        array.add(3);
        array.add(1);

        int duplicate = findDuplicate(array, array.size());

        System.out.println("Duplicate: " + duplicate);
    }
}
