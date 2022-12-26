def solution(entrances, exits, path):
    count = 0

    for i in range(len(path) - len(exits)):
        max_passengers = sum(path[i + len(entrances)])
        available_passengers = 0
        
        for j in entrances:
            available_passengers += path[j][i + len(entrances)]

        count += min(available_passengers, max_passengers)
        
    return count
