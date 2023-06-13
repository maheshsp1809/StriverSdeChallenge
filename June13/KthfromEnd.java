package June13;

public class KthfromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move the fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the k-th node by skipping it
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // Remove the 2nd node from the end

        KthfromEnd solution = new KthfromEnd();
        ListNode result = solution.removeNthFromEnd(head, n);

        // Print the modified linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
