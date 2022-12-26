import java.math.BigInteger;

public class Solution {

    public static String solution(String m, String f) {
        if (m == "1" && f == "1")
            return "0";

        BigInteger mach = new BigInteger(m);
        BigInteger facula = new BigInteger(f);

        String result = "impossible";
        BigInteger count = BigInteger.ZERO;

        while (true) {
            final int comparison = mach.compareTo(facula);
            if (comparison == 1) {
                BigInteger increase = mach.divide(facula);
                if (increase.compareTo(BigInteger.ONE) == 1)
                    increase = increase.subtract(BigInteger.ONE);
                count = count.add(increase);
                mach = mach.subtract(increase.multiply(facula));
            } else if (comparison == -1) {
                BigInteger increase = facula.divide(mach);
                if (increase.compareTo(BigInteger.ONE) == 1)
                    increase = increase.subtract(BigInteger.ONE);
                count = count.add(increase);
                facula = facula.subtract(increase.multiply(mach));
            }
            if (mach.equals(BigInteger.ONE) && facula.equals(BigInteger.ONE)) {
                result = String.valueOf(count);
                break;
            }
            if (mach.compareTo(BigInteger.ONE) == -1 || facula.compareTo(BigInteger.ONE) == -1 || mach.equals(facula))
                break;

        }

        return result;
    }
}
