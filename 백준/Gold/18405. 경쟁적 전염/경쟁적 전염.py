from collections import deque

N, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
S, X, Y = map(int, input().split())
di, dj = [0,1,0,-1], [1,0,-1,0]
cool = []
for i in range(N):
    for j in range(N):
        if arr[i][j] != 0:
            cool.append((arr[i][j], i, j, 0))

cool.sort(key=lambda x:x[0])

q = deque()
q.extend(cool)

while q:
    v, i, j, c = q.popleft()

    if c == S:
        break

    for k in range(4):
        ni, nj = i+di[k], j+dj[k]
        if 0<=ni<N and 0<=nj<N and arr[ni][nj]==0:
            arr[ni][nj] = v
            q.append((v, ni, nj, c+1))

print(arr[X-1][Y-1])