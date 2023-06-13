package June13;

import java.util.*;

public class MergeSortedLinked {
    public static class ListNode<T> {
        T data;
        ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }
    }

    public static ListNode<Integer> sortTwoLists(ListNode<Integer> first, ListNode<Integer> second) {
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> current = dummy;

        while (first != null && second != null) {
            if (first.data <= second.data) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        }

        if (second != null) {
            current.next = second;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<>(1);
        l1.next = new ListNode<>(2);
        l1.next.next = new ListNode<>(4);

        ListNode<Integer> l2 = new ListNode<>(1);
        l2.next = new ListNode<>(3);
        l2.next.next = new ListNode<>(4);

        ListNode<Integer> merged = sortTwoLists(l1, l2);

        while (merged != null) {
            System.out.print(merged.data + " ");
            merged = merged.next;
        }
    }
}
