def soln(A, target):
    chk = [True for _ in target]
    c = 0
    answer = 0
    for i in range(len(A)):
        found = 0
        for j in range(len(target)):
            if chk[j] and target[j] in A[i]:
                chk[j] = False
                c += 1
                found = 1
        answer += found
        if c == len(target):
            return answer

    return "the target word cannot be made wtf do i return?"

print(soln([
    "programming",
    "for",
    "developer"
    ], "frog"))