import java.util.Scanner;

public class ArrayOperations {
    
    // Traverse and print array elements
    public static void traverseArray(int[] arr, int size) {
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Insert an element at a given position
    public static int insertElement(int[] arr, int size, int pos, int val) {
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];  // shift elements to right
        }
        arr[pos] = val;
        size++;
        System.out.println("Element inserted successfully.");
        return size;
    }

    // Delete an element at a given position
    public static int deleteElement(int[] arr, int size, int pos) {
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];  // shift elements to left
        }
        size--;
        System.out.println("Element deleted successfully.");
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];  // fixed capacity
        int size = 5;

        // initial values
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        int choice, pos, val;

        while (true) {
            System.out.println("\n--- Array Operations ---");
            System.out.println("1. Traverse");
            System.out.println("2. Insert");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    traverseArray(arr, size);
                    break;
                case 2:
                    System.out.print("Enter position (0 to " + size + ") and value to insert: ");
                    pos = sc.nextInt();
                    val = sc.nextInt();
                    if (pos >= 0 && pos <= size) {
                        size = insertElement(arr, size, pos, val);
                    } else {
                        System.out.println("Invalid position.");
                    }
                    break;
                case 3:
                    System.out.print("Enter position (0 to " + (size - 1) + ") to delete: ");
                    pos = sc.nextInt();
                    if (pos >= 0 && pos < size) {
                        size = deleteElement(arr, size, pos);
                    } else {
                        System.out.println("Invalid position.");
                    }
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
