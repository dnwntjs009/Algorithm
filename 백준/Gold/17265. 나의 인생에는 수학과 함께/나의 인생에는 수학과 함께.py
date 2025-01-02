def dfs1(i, j, path):
    global min_v, max_v
    di, dj = [0, 1], [1, 0]

    path.append(arr[i][j] if arr[i][j] in ['+', '-', '*'] else int(arr[i][j]))

    if len(path) == 3:
        if path[1] == '+':
            result = path[0] + path[2]
        elif path[1] == '-':
            result = path[0] - path[2]
        elif path[1] == '*':
            result = path[0] * path[2]
        path = [result]

    if i == N - 1 and j == N - 1:
        min_v = min(min_v, path[0])
        max_v = max(max_v, path[0])
        return

    for k in range(2):
        ni, nj = i + di[k], j + dj[k]
        if 0 <= ni < N and 0 <= nj < N:
            dfs1(ni, nj, path[:])


N = int(input())
arr = [list(input().split()) for _ in range(N)]

min_v = 21e8
max_v = -21e8

dfs1(0, 0, [])

print(max_v, min_v)
