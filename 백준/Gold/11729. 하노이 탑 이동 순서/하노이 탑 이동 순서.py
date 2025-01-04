def hanoi(n, A, B, C):
    if n == 1:
        arr.append((A, C))
        return

    hanoi(n-1, A, C, B)
    arr.append((A, C))
    hanoi(n-1, B, A, C)


N = int(input())
arr = []

hanoi(N, 1, 2, 3)
print(len(arr))
for i, j in arr:
    print(i, j)