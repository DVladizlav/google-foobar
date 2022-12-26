def solution(n):
    m = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    m[0][0] = 1 # first stair
    for stair in range(1, n + 1):
        for prev in range(0, n + 1):
            m[stair][prev] = m[stair - 1][prev]
            if prev >= stair:
                m[stair][prev] += m[stair - 1][prev - stair]

    return m[n][n] - 1

