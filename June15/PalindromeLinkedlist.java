package June15;

public class PalindromeLinkedlist {
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // Example test cases
        LinkedListNode<Integer> head1 = new LinkedListNode<>(1);
        head1.next = new LinkedListNode<>(2);
        head1.next.next = new LinkedListNode<>(3);
        head1.next.next.next = new LinkedListNode<>(4);
        head1.next.next.next.next = new LinkedListNode<>(5);

        System.out.println("Is palindrome? " + isPalindrome(head1)); // Expected output: true

        LinkedListNode<Integer> head2 = new LinkedListNode<>(1);
        head2.next = new LinkedListNode<>(2);
        head2.next.next = new LinkedListNode<>(2);
        head2.next.next.next = new LinkedListNode<>(1);

        System.out.println("Is palindrome? " + isPalindrome(head2)); // Expected output: false

    }

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> mid = getMid(head);

        LinkedListNode<Integer> rev = reverse(mid);
        LinkedListNode<Integer> currentm = rev;
        LinkedListNode<Integer> current = head;
        while (currentm != null) {
            if (current.data != currentm.data) {
                return false;
            }
            current = current.next;
            currentm = currentm.next;
        }
        LinkedListNode<Integer> revagain = reverse(rev);
        return true;
    }

    public static LinkedListNode<Integer> getMid(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        return slow;
    }

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;

        while (current != null) {
            LinkedListNode<Integer> nex = current.next;
            current.next = prev;
            prev = current;
            current = nex;
        }

        return prev;
    }

    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
