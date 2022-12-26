from itertools import permutations


def combinations(N):
    perms = [list(x) for x in permutations(range(1, N-1))]
    combs = []
    N -= 3
    while N > 0:
        for p in perms:
            temp = []
            for i in range(0, N):
                temp.append(p[i])
            if temp not in combs:
                combs.append(temp)
        N -= 1

    return perms + combs


def solution(times, time_limit):
    N = len(times)
    if N <= 2:
        return []

    for i in range(N):
        for r in range(N):
            for c in range(N):
                times[r][c] = min(times[r][c], times[r][i] + times[i][c])

    # negative cycle
    for i in range(N):
        if times[i][i] < 0:
            return range(N - 2)

    combs = combinations(N)
    for comb in combs:
        time_passed = 0
        temp = [0] + comb + [N-1]
        path = [[temp[i], temp[i+1]] for i in range(0, len(temp)-1)]

        for r, c in path:
            time_passed += times[r][c]

        if time_passed <= time_limit:
            return sorted(i - 1 for i in comb)

    return []


