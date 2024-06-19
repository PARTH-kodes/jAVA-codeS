import java.util.*;

public class ReverseLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    public static Node revLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev; // actual reversing step
            prev = curr; /* for the next reversing step */
            curr = next;
        }
        head = prev;
        return head;
    }

    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter head");
        Node head = new Node(sc.nextInt());
        Node tail = head;

        System.out.println("Remaining nodes, till null");
        for (int i = 1; i <= 5; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        System.out.println("\nBefore reversing");
        printList(head);

        head = revLinkedList(head);
        System.out.println("\nAfter reversing");
        printList(head);

        sc.close();
    }
}