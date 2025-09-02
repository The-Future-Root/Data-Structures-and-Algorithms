class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

class Queue:
    def __init__(self):
        self.front = self.rear = None
        self.size = 0
    
    def get_size(self):
        return self.size
    
    def is_empty(self):
        return self.front is None
    
    def enqueue(self, val):
        new_node = Node(val)
        if self.is_empty():
            self.front = self.rear = new_node
        else:
            self.rear.next = new_node
            self.rear = new_node
        self.size += 1

    def dequeue(self):
        if self.is_empty():
            raise ValueError("Queue is Empty")
        node = self.front
        self.front = self.front.next
        if self.front is None:
            self.rear = None
        node.next = None
        self.size -= 1
        return node.value

    def __str__(self):
        values = []
        current = self.front
        while current:
            values.append(str(current.value))
            current = current.next
        return " -> ".join(values) if values else "Queue is empty"
    
    def peek(self):
        if self.is_empty():
            raise ValueError("Queue is Empty")
        return self.front.value
