from collections import deque


def bfs1(x, y, cnt):
    q = deque()
    visited = [[0] * C for _ in range(R)]
    visited[x][y] = 1
    q.append((x, y, cnt))

    while q:
        water = []
        for wi in range(R):
            for wj in range(C):
                if arr[wi][wj] == '*':
                    for k in range(4):
                        ni, nj = wi + di[k], wj + dj[k]
                        if 0 <= ni < R and 0 <= nj < C and arr[ni][nj] == '.':
                            water.append((ni, nj))
        for wi, wj in water:
            arr[wi][wj] = '*'

        for _ in range(len(q)):
            i, j, c = q.popleft()

            if i == d_i and j == d_j:
                return c

            for k in range(4):
                ni, nj = i + di[k], j + dj[k]
                if 0 <= ni < R and 0 <= nj < C and not visited[ni][nj] and (arr[ni][nj] == '.' or arr[ni][nj] == 'D'):
                    visited[ni][nj] = 1
                    q.append((ni, nj, c + 1))

    return 'KAKTUS'


di, dj = [0, 1, 0, -1], [1, 0, -1, 0]
R, C = map(int, input().split())
arr = [list(input().strip()) for _ in range(R)]

d_i, d_j = 0, 0
s_i, s_j = 0, 0

for i in range(R):
    for j in range(C):
        if arr[i][j] == 'D':
            d_i, d_j = i, j
        if arr[i][j] == 'S':
            s_i, s_j = i, j

print(bfs1(s_i, s_j, 0))
