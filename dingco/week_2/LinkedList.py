from Node import Node

class LinkedList:
    def __init__(self, value):
        self.head = Node(value)
            
    def append(self, value):
        cur = self.head
        
        while cur.next is not None:
            cur = cur.next
        
        cur.next = Node(value)
        
linked_list = LinkedList(5)
linked_list.append(3)
