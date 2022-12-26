import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static String solution(int[] panels) {
        if (panels.length == 1)
            return Integer.toString(panels[0]);

        BigInteger product = BigInteger.valueOf(0);
        ArrayList<Integer> positiveNums = new ArrayList<>();
        ArrayList<Integer> negativeNums = new ArrayList<>();

        for (int power : panels) {
            if (power > 0)
                positiveNums.add(power);
            else if (power < 0)
                negativeNums.add(power);
        }

        if (negativeNums.size() % 2 == 1) {
            Collections.sort(negativeNums, Collections.reverseOrder());
            negativeNums.remove(0);
        }

        if (positiveNums.size() + negativeNums.size() > 0) {
            product = BigInteger.ONE;
            for (int power : positiveNums) {
                product = product.multiply(BigInteger.valueOf(power));
            }
            for (int power : negativeNums) {
                product = product.multiply(BigInteger.valueOf(power));
            }
        }

        return product.toString();
    }

}
