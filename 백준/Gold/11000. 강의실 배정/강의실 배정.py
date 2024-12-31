from heapq import heappush, heappop

classes = []
for _ in range(int(input())):
    S, T = map(int, input().split())
    classes.append((S, T))

classes.sort(key=lambda x: x[0])

heap = []

for S, T in classes:
    if heap and heap[0] <= S:
        heappop(heap)

    heappush(heap, T)

print(len(heap))
