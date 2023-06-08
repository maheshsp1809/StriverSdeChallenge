package June8;

import java.io.*;
import java.util.*;

public class DeleteNode {
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void deleteNode(LinkedListNode<Integer> node) {
        if (node == null || node.next == null) {
            return; // Nothing to delete or last node, cannot delete
        }

        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4
        LinkedListNode<Integer> node1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Before deletion:");
        printLinkedList(node1);

        // Delete the node containing value 2
        deleteNode(node2);

        System.out.println("After deletion:");
        printLinkedList(node1);
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
