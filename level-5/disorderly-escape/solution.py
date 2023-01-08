from math import factorial
from collections import Counter
from fractions import gcd


def cycle_count(partition, n):
    count = factorial(n)
    for a, b in Counter(partition).items():
        count //= (a**b)*factorial(b)
    return count


def cycle_partitions(n, index=1):
    yield [n]
    for i in range(index, n//2 + 1):
        for p in cycle_partitions(n-i, i):
            yield [i] + p


def solution(w, h, s):
    result = 0
    for partitionW in cycle_partitions(w):
        for partitionH in cycle_partitions(h):
            m = cycle_count(partitionW, w)*cycle_count(partitionH, h)
            sumWH = sum([sum([gcd(i, j) for i in partitionW]) for j in partitionH])
            result += m*(s**sumWH)

    return str(result//(factorial(w)*factorial(h)))

