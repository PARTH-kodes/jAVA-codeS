import java.util.*;



public class ArrangeConsonantVowel {
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            next = null;
        }
    }
    public static Node arrangeCV(Node head) { // USING STRING-BUILDER
        if (head == null || head.next == null) {
            return head;
        }
        StringBuilder str = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            str.append(temp.data);
            temp = temp.next;
        }

        StringBuilder consonant = new StringBuilder();

        for (int i = 0; i < str.length();) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                i++;
            } else {
                consonant.append(ch);
                str.deleteCharAt(i);
            }
        }

        str.append(consonant);

        Node newHead = new Node(str.charAt(0));
        Node tail = newHead;
        int i = 1;

        while (str.length() != i) {
            tail.next = new Node(str.charAt(i));
            tail = tail.next;
            i++;
        }

        return newHead;
    }

    public static Node arrangeVC(Node head) { // USING NODES
        Node temp = head;
        Node dummy = new Node('s');
        Node curr = dummy;
        while (temp != null) {
            if ((temp.data == 'a') || (temp.data == 'e') || (temp.data == 'i') || (temp.data == 'o')
                    || (temp.data == 'u')) {
                Node newNode = new Node(temp.data);
                curr.next = newNode;
                curr = curr.next;
            }
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if ((temp.data != 'a') && (temp.data != 'e') && (temp.data != 'i') && (temp.data != 'o')
                    && (temp.data != 'u')) {
                Node newNode = new Node(temp.data);
                curr.next = newNode;
                curr = curr.next;
            }
            temp = temp.next;
        }
        printList(dummy.next);
        return dummy.next;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the linked list");
        int n = sc.nextInt();
        System.out.println("Enter all the characters in any random order");
        Node head = new Node(sc.next().charAt(0));
        Node tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new Node(sc.next().charAt(0));
            tail = tail.next;
        }
        System.out.println("Original Linked List: ");
        printList(head);

        System.out.println("Linked List after arranging vowels and consonants");
        printList(arrangeVC(head));

        sc.close();
    }
}