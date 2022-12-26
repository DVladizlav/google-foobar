def solution(xs):
    if len(xs) == 1:
        return str(xs[0])

    product = 0
    negativeNums = []
    positiveNums = []

    for num in xs:
        if num > 0:
            positiveNums.append(num)
        elif num < 0:
            negativeNums.append(num)

    if len(negativeNums) % 2 != 0:
        negativeNums.sort()
        negativeNums.pop()

    if positiveNums or negativeNums:
        product = 1
        for x in positiveNums + negativeNums:
            product *= x

    return str(product)


