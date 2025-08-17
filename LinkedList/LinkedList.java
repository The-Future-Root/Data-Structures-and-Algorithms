package LinkedList;

import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}


class LLOperations{
    private Node head = null;

    // Insert at end
    public void insert(int data) {
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
    }

    // Delete first occurrence of a value
    public void delete(int val) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == val) {
            head = head.next;
            System.out.println("Deleted successfully.");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != val) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Deleted successfully.");
        }
    }

    // Traverse and print
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class LinkedList
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        LLOperations list = new LLOperations();
    while (true) {
            System.out.println("\n--- Linked List Operations ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Traverse");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int val = sc.nextInt();
                    list.insert(val);
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int delVal = sc.nextInt();
                    list.delete(delVal);
                    break;
                case 3:
                    list.traverse();
                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}