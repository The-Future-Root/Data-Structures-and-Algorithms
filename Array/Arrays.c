#include <stdio.h>

// Traverse and print array elements using index-based access
void traverseArray(int arr[], int size) {
    printf("Array elements:\n");
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

// Insert an element at a given position in the array
void insertElement(int arr[], int *size, int pos, int val) {
    for (int i = *size; i > pos; i--) {
        arr[i] = arr[i - 1];  // Shift elements to the right
    }
    arr[pos] = val;
    (*size)++;
    printf("Element inserted successfully.\n");
}

// Delete an element from a given position in the array
void deleteElement(int arr[], int *size, int pos) {
    for (int i = pos; i < *size - 1; i++) {
        arr[i] = arr[i + 1];  // Shift elements to the left
    }
    (*size)--;
    printf("Element deleted successfully.\n");
}

int main() {
    int arr[100] = {10, 20, 30, 40, 50};
    int size = 5;
    int choice, pos, val;

    while (1) {
        printf("\n--- Array Operations ---\n");
        printf("1. Traverse\n2. Insert\n3. Delete\n4. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                traverseArray(arr, size);
                break;
            case 2:
                printf("Enter position (0 to %d) and value to insert: ", size);
                scanf("%d %d", &pos, &val);
                if (pos >= 0 && pos <= size) {
                    insertElement(arr, &size, pos, val);
                } else {
                    printf("Invalid position.\n");
                }
                break;
            case 3:
                printf("Enter position (0 to %d) to delete: ", size - 1);
                scanf("%d", &pos);
                if (pos >= 0 && pos < size) {
                    deleteElement(arr, &size, pos);
                } else {
                    printf("Invalid position.\n");
                }
                break;
            case 4:
                return 0;
            default:
                printf("Invalid choice.\n");
        }
    }
}