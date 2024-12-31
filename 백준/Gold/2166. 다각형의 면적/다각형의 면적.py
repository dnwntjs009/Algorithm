N = int(input())
cool = []
for _ in range(N):
    x, y = map(int, input().split())
    cool.append([x, y])

sum1 = 0
sum2 = 0
for i in range(N):
    if i == N-1:
        sum1 += cool[i][0] * cool[0][1]
    else:
        sum1 += cool[i][0] * cool[i+1][1]

for i in range(N):
    if i == N-1:
        sum2 += cool[i][1] * cool[0][0]
    else:
        sum2 += cool[i][1] * cool[i+1][0]

print(abs(round((sum1-sum2)/2, 1)))
