target = 4
finding_numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]

def binary_search (target, array):
    min = 0
    max = len(array) - 1
    mid = (min + max) // 2

    while min <= max:
        if array[mid] == target:
            return True
        
        if array[mid] < target:
            min = mid + 1

        if array[mid] > target:
            max = mid - 1
        
        mid = (min + max) // 2
        
    return False

result = binary_search(target, finding_numbers)
print(result)
