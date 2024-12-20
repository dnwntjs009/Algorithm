from collections import deque
import sys

input = sys.stdin.readline

di, dj = [0,1,0,-1], [1,0,-1,0]

def bfs1(x, y, cnt):
    q = deque()
    fq = deque()
    visited = [[0]*w for _ in range(h)]
    visited[x][y] = 1
    q.append((x,y,cnt))

    for i in range(h):
        for j in range(w):
            if arr[i][j] == '*':
                fq.append((i, j))

    while q:
        # 불 먼저 옮기기
        for _ in range(len(fq)):
            fi, fj = fq.popleft()
            for k in range(4):
                ni, nj = fi+di[k], fj+dj[k]
                if 0<=ni<h and 0<=nj<w and arr[ni][nj] == '.':
                    arr[ni][nj] = '*'
                    fq.append((ni, nj))

        # 이동하기
        for _ in range(len(q)):
            i, j, c = q.popleft()

            if i == 0 or i == h-1 or j == 0 or j == w-1:
                return c

            for k in range(4):
                ni, nj = i+di[k], j+dj[k]
                if 0<=ni<h and 0<=nj<w and not visited[ni][nj] and arr[ni][nj] != '#' and arr[ni][nj] != '*':
                    visited[ni][nj] = 1
                    q.append((ni, nj, c+1))

    return 'IMPOSSIBLE'

for _ in range(int(input())):
    w, h = map(int, input().split())
    arr = [list(input()) for _ in range(h)]
    si, sj = 0, 0
    for i in range(h):
        for j in range(w):
            if arr[i][j] == '@':
                si, sj = i, j
                break

    print(bfs1(si, sj, 1))