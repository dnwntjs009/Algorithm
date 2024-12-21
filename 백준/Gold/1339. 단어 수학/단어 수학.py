words = [[] for _ in range(9)]
alphabet = ['' for _ in range(26)]
alphabet_count = [0 for _ in range(26)]
alphabet_set = set()

input_list = []

# 입력 처리
for _ in range(int(input())):
    word = input()
    input_list.append(word)
    l = len(word)
    for i in range(l):
        alphabet_count[ord(word[i]) - 65] += 10 ** (l - i - 1)  # 자리값 가중치 계산
        alphabet_set.add(word[i])

# 알파벳 가중치 기준으로 정렬
sorted_alphabet = []
for i in range(26):
    if alphabet_count[i] > 0:
        sorted_alphabet.append((alphabet_count[i], chr(i + 65)))

sorted_alphabet.sort(reverse=True, key=lambda x: x[0])  # 가중치 기준 내림차순 정렬

# 숫자 할당
cnt = 9
for _, char in sorted_alphabet:
    alphabet[ord(char) - 65] = str(cnt)
    cnt -= 1

# 총합 계산
total = 0
for word in input_list:
    cool = ''
    for w in word:
        cool += alphabet[ord(w) - 65]
    total += int(cool)

print(total)
