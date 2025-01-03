N = int(input())
graph = [[] for _ in range(N+1)]
result = set()

for i in range(1, N+1):
    graph[int(input())].append(i)

for i in range(1, N+1):
    visited = [0]*(N+1)
    stack = [i]
    visited[i] = 1

    while stack:
        v = stack.pop()
        for j in graph[v]:
            if not visited[j]:
                stack.append(j)
                visited[j] = 1
            elif visited[j] and i == j:
                result.add(j)

result = list(result)
result.sort()

print(len(result))
for i in result:
    print(i)