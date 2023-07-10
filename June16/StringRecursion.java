package June16;

import java.util.ArrayList;

public class StringRecursion {
    public static void main(String[] args) {
        String s = "bbaaadcccaa";
        System.out.println(helperString(s));
        System.out.println(Subseq("", "abc"));

    }

    public static String helperString(String s) {
        if (s.length() == 0) {
            return "";
        }
        char c = s.charAt(0);
        if (c == 'a') {
            return helperString(s.substring(1));
        } else {
            return c + helperString(s.substring(1));
        }
    }

    public static ArrayList<String> Subseq(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char c = up.charAt(0);
        ArrayList<String> left = Subseq(p + c, up.substring(1));
        ArrayList<String> right = Subseq(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
