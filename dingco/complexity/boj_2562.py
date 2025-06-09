numbers = []

for i in range(9):
    number = input()
    numbers.append(number)

numbers = [int(number) for number in numbers]

maxNumber = 0;
maxNumberIndex = 0;

for i, number in enumerate(numbers):
    if int(number) > maxNumber:
        maxNumber = number
        maxNumberIndex = i + 1

print(maxNumber, maxNumberIndex)