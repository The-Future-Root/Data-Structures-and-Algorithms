class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top = null;

    // Push (insert at top)
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop (remove from top)
    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        top = top.next;
    }

    // Peek (view top element)
    public void peek() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element: " + top.data);
        }
    }

    // Display the stack
    public void displayStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Free all nodes in the stack (in Java, GC handles memory,
    // but we can clear manually)
    public void freeStack() {
        top = null;  // let garbage collector reclaim memory
    }
}

public class StackLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.displayStack();   // 30 -> 20 -> 10 -> NULL

        stack.peek();           // Top element: 30

        stack.pop();
        stack.displayStack();   // 20 -> 10 -> NULL

        stack.freeStack();
    }
}
