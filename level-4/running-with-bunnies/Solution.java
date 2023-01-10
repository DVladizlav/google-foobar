import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public static int[] solution(int[][] times, int timeLimit) {
        final int N = times.length;
        if (N <= 2) {
            return new int[] {};
        }
        for (int i = 0; i < N; i++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    times[r][c] = Math.min(times[r][c], times[r][i] + times[i][c]);
                }
            }
        }
        // negative cycle
        for (int i = 0; i < N; i++) {
            if (times[i][i] < 0) {
                return IntStream.range(0, N - 2).toArray();
            }
        }

        List<List<Integer>> combs = combinations(IntStream.range(1, N - 1).toArray());

        for (List<Integer> c : combs) {
            int timePassed = 0;
            List<List<Integer>> paths = path(c, N);
            
            for (List<Integer> p : paths) {
                timePassed += times[p.get(0)][p.get(1)];
            }
            if (timePassed <= timeLimit) {
                return c.stream().mapToInt(x -> x - 1).toArray();
            }
        }

        return new int[] {};
    }

    static List<List<Integer>> path(List<Integer> comb, int N) {
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.addAll(comb);
        temp.add(N - 1);

        List<List<Integer>> paths = new ArrayList<>();
        for (int i = 0; i < temp.size() - 1; i++) {
            paths.add(new ArrayList<>(Arrays.asList(temp.get(i), temp.get(i + 1))));
        }
        return paths;
    }

    static List<List<Integer>> combinations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(0, nums, result);

        // added separate result to avoid duplicates in loop
        List<List<Integer>> subResult = new ArrayList<>();

        int N = nums.length - 1;
        while (N > 0) {
            for (List<Integer> r : result) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    temp.add(r.get(i));
                }
                if (!subResult.contains(temp)) {
                    subResult.add(temp);
                }
            }
            N--;
        }
        result.addAll(subResult);
        return result;
    }

    static void permute(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            result.add(list);
        } else {
            for (int j = i, l = nums.length; j < l; j++) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                permute(i + 1, nums, result);
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
