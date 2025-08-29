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


