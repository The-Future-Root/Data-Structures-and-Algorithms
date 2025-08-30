class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class Stack:

    def __init__(self):
        self.top = None
        self.size = 0

    def length(self):
        return self.size

    def push(self, val):
        new_node = Node(val)
        new_node.next = self.top
        self.top = new_node
        self.size += 1

    def pop(self):
        if self.is_empty():
            raise ValueError("Stack is Empty")

        pop_val = self.top.value
        self.top = self.top.next
        self.size -= 1
        return pop_val

    def peek(self):
        if self.is_empty():
            raise ValueError("Stack is Empty")
        return self.top.value

    def is_empty(self):
        return self.top is None

    def __str__(self):
        values = []
        current = self.top
        while current:
            values.append(str(current.value))
            current = current.next
        return " -> ".join(values) if values else "Stack is empty"
