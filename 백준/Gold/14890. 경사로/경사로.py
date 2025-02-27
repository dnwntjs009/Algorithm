def dfs_row(i, j):
    global result
    if j == n-1:
        result += 1
        return

    if arr[i][j] == arr[i][j+1]:
        dfs_row(i, j+1)
    elif arr[i][j] - arr[i][j+1] == -1:
        if j-l+1 >= 0:
            flag = True
            for k in range(j, j-l, -1):
                if arr[i][k] != arr[i][j] or visited_row[i][k]:
                    flag = False
                    break

            if flag:
                for k in range(j, j-l, -1):
                    visited_row[i][k] = 1

                dfs_row(i, j+1)

                for k in range(j, j-l, -1):
                    visited_row[i][k] = 0
    elif arr[i][j] - arr[i][j+1] == 1:
        if j+l < n:
            flag = True
            for k in range(j+1, j+l+1):
                if arr[i][k] != arr[i][j+1] or visited_row[i][k]:
                    flag = False
                    break

            if flag:
                for k in range(j+1, j+l + 1):
                    visited_row[i][k] = 1

                dfs_row(i, j+1)

                for k in range(j+1, j+l+1):
                    visited_row[i][k] = 0


def dfs_col(i, j):
    global result
    if i == n-1:
        result += 1
        return

    if arr[i][j] == arr[i+1][j]:
        dfs_col(i+1, j)
    elif arr[i][j] - arr[i+1][j] == -1:
        if i-l+1 >= 0:
            flag = True
            for k in range(i, i-l, -1):
                if arr[k][j] != arr[i][j] or visited_col[k][j]:
                    flag = False
                    break

            if flag:
                for k in range(i, i-l, -1):
                    visited_col[k][j] = 1

                dfs_col(i+1, j)

                for k in range(i, i-l, -1):
                    visited_col[k][j] = 0
    elif arr[i][j] - arr[i+1][j] == 1:
        if i+l < n:
            flag = True
            for k in range(i+1, i+l + 1):
                if arr[k][j] != arr[i+1][j] or visited_col[k][j]:
                    flag = False
                    break

            if flag:
                for k in range(i+1, i+l+1):
                    visited_col[k][j] = 1

                dfs_col(i+1, j)

                for k in range(i+1, i+l+1):
                    visited_col[k][j] = 0


n, l = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

result = 0
visited_row = [[0]*n for _ in range(n)]
visited_col = [[0]*n for _ in range(n)]

for i in range(n):
    dfs_row(i, 0)
    dfs_col(0, i)

print(result)