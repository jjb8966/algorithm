input = "abba"

def is_palindrome(string):
    n = len(string)
    
    for i in range(n):
        if string[i] != string[n - i - 1]:
            return False
    
    return True

result = is_palindrome(input)
print(result)