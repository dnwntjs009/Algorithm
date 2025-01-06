def cool(cnt):
    if cnt == L:
        cnt1 = cnt2 = 0

        for i in password:
            if i in vowels:
                cnt1 += 1
            else:
                cnt2 += 1

        if cnt1 >= 1 and cnt2 >= 2:
            word = ''.join(password)
            if word not in total:
                total.append(word)
        return

    for i in arr:
        if i not in password:
            if password:
                if ord(password[-1]) <= ord(i):
                    password.append(i)
                    cool(cnt + 1)
                    password.pop()
            else:
                password.append(i)
                cool(cnt+1)
                password.pop()


L, C = map(int, input().split())
arr = list(map(str, input().split()))
arr.sort()
vowels = ['a', 'e', 'i', 'o', 'u']
password = []
total = []
cool(0)

for i in total:
    print(i)

