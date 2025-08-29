# Linked-list

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def is_empty(self):
        return self.head is None

    def traverse(self):
        if self.is_empty():
            print("Empty List")
        else:
            temp = self.head
            while temp:
                print(temp.value, end=" -> ")
                temp = temp.next
            print("None")

    def search(self, val):
        if self.is_empty():
            print("Empty List")
            return False
        temp = self.head
        while temp:
            if temp.value == val:
                print(f"{val} is Present")
                return True
            temp = temp.next
        print(f"{val} is Not Present")
        return False

    def length(self):
        count = 0
        temp = self.head
        while temp:
            count += 1
            temp = temp.next
        return count

    def insert_begin(self, val):
        new_node = Node(val)
        new_node.next = self.head
        self.head = new_node

    def insert_end(self, val):
        new_node = Node(val)
        if self.is_empty():
            self.head = new_node
            return
        last = self.head
        while last.next:
            last = last.next
        last.next = new_node

    def insert_pos(self, pos, val):
        if pos < 0 or pos > self.length():
            print("Invalid Position")
            return
        new_node = Node(val)
        if pos == 0:
            new_node.next = self.head
            self.head = new_node
            return
        temp = self.head
        for _ in range(pos - 1):
            temp = temp.next
        new_node.next = temp.next
        temp.next = new_node

    def delete_val(self, val):
        if self.is_empty():
            print("Empty List")
            return
        temp = self.head

        if temp.value == val:
            self.head = temp.next
            temp = None
            return

        prev = None
        while temp and temp.value != val:
            prev = temp
            temp = temp.next

        if temp is None:
            print(f"{val} not found in the list")
            return

        prev.next = temp.next
        temp = None

    def delete_begin(self):
        if self.is_empty():
            print("Empty List")
            return
        self.head = self.head.next

    def delete_end(self):
        if self.is_empty():
            print("Empty List")
            return
        if self.head.next is None:
            self.head = None
            return
        temp = self.head
        while temp.next.next:
            temp = temp.next
        temp.next = None


if __name__ == "__main__":
    ll = LinkedList()
    ll.insert_end(10)
    ll.insert_end(20)
    ll.insert_end(30)
    ll.insert_begin(5)
    ll.insert_pos(2, 15)
    ll.traverse()
    print("Length:", ll.length())
    ll.search(20)
    ll.search(100)
    ll.delete_begin()
    ll.traverse()
    ll.delete_end()
    ll.traverse()
    ll.delete_val(15)
    ll.traverse()



# Doubly Linked-list

class DLLNode:
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def is_empty(self):
        return self.head is None

    def traverse_forward(self):
        if self.is_empty():
            print("Empty List")
            return
        temp = self.head
        while temp:
            print(temp.value, end=" <-> ")
            temp = temp.next
        print("None")

    def traverse_backward(self):
        if self.is_empty():
            print("Empty List")
            return
        temp = self.tail
        while temp:
            print(temp.value, end=" <-> ")
            temp = temp.prev
        print("None")

    def length(self):
        count = 0
        temp = self.head
        while temp:
            count += 1
            temp = temp.next
        return count

    def insert_begin(self, value):
        new_node = DLLNode(value)
        if self.is_empty():
            self.head = self.tail = new_node
        else:
            new_node.next = self.head
            self.head.prev = new_node
            self.head = new_node

    def insert_end(self, value):
        new_node = DLLNode(value)
        if self.is_empty():
            self.head = self.tail = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node

    def insert_pos(self, pos, value):
        if pos < 0 or pos > self.length():
            print("Invalid Position")
            return
        
        if pos == 0:
            self.insert_begin(value)
            return
        
        if pos == self.length():
            self.insert_end(value)
            return
        
        new_node = DLLNode(value)
        temp = self.head
        for _ in range(pos - 1):
            temp = temp.next
        new_node.next = temp.next
        new_node.prev = temp
        temp.next.prev = new_node
        temp.next = new_node

    def delete_begin(self):
        if self.is_empty():
            print("Empty List")
            return
        
        if self.head == self.tail:
            self.head = self.tail = None
        else:
            self.head = self.head.next
            self.head.prev = None

    def delete_end(self):
        if self.is_empty():
            print("Empty List")
            return
        
        if self.head == self.tail:
            self.head = self.tail = None
        else:
            self.tail = self.tail.prev
            self.tail.next = None

    def delete_val(self, value):
        if self.is_empty():
            print("Empty List")
            return
        
        temp = self.head
        while temp:
            if temp.value == value:

                if temp == self.head:
                    self.delete_begin()

                elif temp == self.tail:
                    self.delete_end()

                else:
                    temp.prev.next = temp.next
                    temp.next.prev = temp.prev
                return
            temp = temp.next
        print(f"{value} not found in the list")

    def search(self, value):
        temp = self.head
        while temp:
            if temp.value == value:
                print(f"{value} is Present")
                return True
            temp = temp.next
        print(f"{value} is Not Present")
        return False


if __name__ == "__main__":
    dll = DoublyLinkedList()
    dll.insert_end(10)
    dll.insert_end(20)
    dll.insert_begin(5)
    dll.insert_pos(1, 15)
    dll.traverse_forward()
    dll.traverse_backward()
    print("Length:", dll.length())
    dll.delete_val(10)
    dll.traverse_forward()
    dll.delete_begin()
    dll.traverse_forward()
    dll.delete_end()
    dll.traverse_forward()

