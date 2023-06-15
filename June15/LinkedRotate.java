package June15;

public class LinkedRotate {
    public static class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // Create a sample linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Rotate the linked list by 2 positions
        int k = 2;
        head = rotate(head, k);

        // Print the rotated linked list
        printLinkedList(head);
    }

    public static Node rotate(Node head, int k) {
        if (k < 1 || head == null || head.next == null) {
            return head;
        }
        Node current = head;
        int length = 1;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        current.next = head;
        Node prev = null;
        Node newLast = head;
        k = k % length;
        k = length - k;
        while (k > 0) {
            prev = newLast;
            newLast = newLast.next;
            k--;
        }
        prev.next = null;
        head = newLast;
        return head;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
