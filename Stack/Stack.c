#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};


struct Node* top = NULL;

// Push (insert at top)
void push(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("Memory allocation failed\n");
        return;
    }
    newNode->data = data;
    newNode->next = top;
    top = newNode;
}

// Pop (remove from top)
void pop() {
    if (top == NULL) {
        printf("Stack is empty\n");
        return;
    }
    struct Node* temp = top;
    top = top->next;
    free(temp);
}

// Peek (view top element)
void peek() {
    if (top == NULL) {
        printf("Stack is empty\n");
    } else {
        printf("Top element: %d\n", top->data);
    }
}

// Display the stack
void displayStack() {
    struct Node* temp = top;
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

// Free all nodes in the stack
void freeStack() {
    while (top != NULL) {
        pop();
    }
}


int main() {
    push(10);
    push(20);
    push(30);
    displayStack();   

    peek();           

    pop();
    displayStack();   

    freeStack();      
    return 0;
}
