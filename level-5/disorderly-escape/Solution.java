import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static String solution(int w, int h, int s) {
        BigInteger result = BigInteger.ZERO;

        for (List<Integer> partitionW : cyclePartitions(w, 1)) {
            for (List<Integer> partitionH : cyclePartitions(h, 1)) {

                BigInteger m = BigInteger.valueOf(countCycles(partitionW, w))
                        .multiply(BigInteger.valueOf(countCycles(partitionH, h)));
                int sum = 0;
                for (int i : partitionW)
                    for (int j : partitionH)
                        sum += gcd(i, j);

                result = result.add(BigInteger.valueOf(s).pow(sum).multiply(m));
            }
        }

        result = result.divide(BigInteger.valueOf(factorial(w)).multiply(BigInteger.valueOf(factorial(h))));

        return result.toString();
    }

    static int countCycles(List<Integer> partition, int n) {
        int result = factorial(n);

        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        partition.forEach((p) -> map.merge(p, 1, Integer::sum));

        for (Map.Entry<Integer, Integer> set : map.entrySet())
            result /= Math.pow(set.getKey(), set.getValue()) * factorial(set.getValue());

        return result;
    }

    static List<List<Integer>> cyclePartitions(int n, int index) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(n)));

        for (int i = index; i < n / 2 + 1; i++) {
            for (List<Integer> partition : cyclePartitions(n - i, i)) {
                partition.add(0, i);
                result.add(partition);
            }
        }
        return result;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    /** for positive numbers and 0 only */
    static int factorial(int num) {
        int result = 1;
        for (int i = num; i > 0; i--)
            result *= i;

        return result;
    }
}