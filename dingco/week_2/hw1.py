"""
Q. 링크드 리스트의 끝에서 K번째 값을 반환하시오.

[6] -> [7] -> [8] # 이런 링크드 리스트가 입력되었을 때, 
                  # 끝에서 2번째 값은 7을 반환해야 합니다!
"""

from typing import Optional

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self, value):
        self.head = Node(value)

    def append(self, value):
        cur = self.head

        while cur.next is not None:
            cur = cur.next

        cur.next = Node(value)

    def get_kth_node_from_last(self, k):
        cur = self.head
        linked_list_size = 0

        while cur is not None:
            cur = cur.next
            linked_list_size += 1
        
        cur = self.head
        find_index = linked_list_size - k

        for i in range(find_index):
            cur = cur.next

        return cur

linked_list = LinkedList(6)
linked_list.append(7)
linked_list.append(8)

print(linked_list.get_kth_node_from_last(2).data)  # 7이 나와야 합니다!