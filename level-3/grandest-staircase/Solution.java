public class Solution {

    public static int solution(int n) {
        int[][] staircase = new int[n + 1][n + 1];
        staircase[0][0] = 1; // first stair

        for (int stair = 1; stair < n + 1; stair++) {
            for (int prev = 0; prev < n + 1; prev++) {
                staircase[stair][prev] = staircase[stair - 1][prev];
                if (prev >= stair) {
                    staircase[stair][prev] += staircase[stair - 1][prev - stair];
                }
            }
        }

        return staircase[n][n] - 1;
    }
}
