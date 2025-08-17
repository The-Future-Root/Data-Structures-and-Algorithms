package LinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head = null;

    // Insert at end
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert at beginning
    public void insertBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Delete a value
    public void delete(int val) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        // if head is to be deleted
        if (temp.data == val) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            System.out.println("Deleted successfully.");
            return;
        }

        // find the node
        while (temp != null && temp.data != val) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found.");
            return;
        }

        // unlink
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        System.out.println("Deleted successfully.");
    }

    // Traverse forward
    public void traverseForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Traverse backward
    public void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next; // move to last node
        }
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
}

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        while (true) {
            System.out.println("\n--- Doubly Linked List Operations ---");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Beginning");
            System.out.println("3. Delete a Value");
            System.out.println("4. Traverse Forward");
            System.out.println("5. Traverse Backward");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    dll.insertEnd(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    dll.insertBeginning(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    dll.delete(sc.nextInt());
                    break;
                case 4:
                    dll.traverseForward();
                    break;
                case 5:
                    dll.traverseBackward();
                    break;
                case 6:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
