import java.math.BigInteger;

public class Solution {
    
    public static int solution(String x) {
        BigInteger result = new BigInteger(x);
        int count = 0;

        while (result.compareTo(BigInteger.ONE) == 1) {
            if (result.compareTo(BigInteger.valueOf(4)) == -1)
                return result.add(BigInteger.valueOf(count - 1)).intValue();

            if (result.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                result = result.divide(BigInteger.TWO);
            } else {
                if (result.subtract(BigInteger.ONE)
                        .mod(BigInteger.valueOf(4))
                        .equals(BigInteger.ZERO)) {
                    result = result.subtract(BigInteger.ONE);
                } else {
                    result = result.add(BigInteger.ONE);
                }
            }
            count++;
        }

        return count;
    }
}