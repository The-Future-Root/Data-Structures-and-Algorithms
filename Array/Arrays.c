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