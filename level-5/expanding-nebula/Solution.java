import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {

    static int N = 0;

    public static int solution(boolean[][] g) {
        N = g.length;
        int M = g[0].length;

        // transpose matrix
        boolean[][] matrix = new boolean[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[j][i] = g[i][j];
            }
        }

        // sum up cols in rows
        int[] nums = new int[M];
        for (int i = 0; i < M; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (matrix[i][j]) {
                    temp += 1L << j;
                }
            }
            nums[i] = temp;
        }

        final int limit = (int) (1L << (N + 1));

        // generate map
        final Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                int gen = (int) generate(i, j);
                if (IntStream.of(nums).anyMatch(x -> x == gen)) {
                    String key = gen + "," + i;
                    ArrayList<Integer> values = map.getOrDefault(key, new ArrayList<>());
                    values.add(j);
                    map.put(key, values);
                }
            }
        }

        // map.forEach((key, value) -> System.out.println(key + " : " + value));

        int[] image = new int[limit];
        for (int i = 0; i < limit; i++) {
            image[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            int[] nextImage = new int[limit];
            for (int j = 0; j < limit; j++) {
                ArrayList<Integer> values = map.getOrDefault(nums[i] + "," + j, new ArrayList<>());
                for (int value : values) {
                    nextImage[value] += image[j];
                }
            }
            image = nextImage;
        }

        return IntStream.of(image).sum();
    }

    static long generate(long i, long j) {
        long a = i & ~(1L << N);
        long b = j & ~(1L << N);
        long c = i >> 1L;
        long d = j >> 1L;

        return (a & ~b & ~c & ~d) | (~a & b & ~c & ~d) | (~a & ~b & c & ~d) | (~a & ~b & ~c & d);
    }

}
