public class Solution {
    
    public static int solution(int[] entrances, int[] exits, int[][] path) {
        int count = 0;
        for (int i = entrances.length; i < path.length - exits.length; i++) {
            int maxPassengers = 0;
            for (int bunnies : path[i])
                maxPassengers += bunnies;

            int availablePassengers = 0;
            for (int j = 0; j < entrances.length; j++)
                availablePassengers += path[j][i];

            count += Math.min(maxPassengers, availablePassengers);
        }
        return count;
    }
}