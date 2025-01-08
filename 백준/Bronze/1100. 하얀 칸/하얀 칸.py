arr = [list(input()) for _ in range(8)]
result = 0

for i in range(8):
    for j in range(8):
        if i % 2 == 0 and j % 2 == 0 and arr[i][j] == 'F':
            result += 1
        elif i % 2 == 1 and j % 2 == 1 and arr[i][j] == 'F':
            result += 1

print(result)