#include <stdio.h>

// Traverse and print array elements using index-based access
void traverseArray(int arr[], int size) {
    printf("Array elements:\n");
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

