public class Solution {
 
    public static String[] solution(String[] l) {

        for (int i = 0; i < l.length; i++) {
            for (int j = i + 1; j < l.length; j++) {
                final String[] a1 = l[i].split("\\.");
                final String[] a2 = l[j].split("\\.");

                final int len = Math.min(a1.length, a2.length);
                boolean sorted = false;

                for (int r = 0; r < len; r++) {
                    final int num1 = Integer.parseInt(a1[r]);
                    final int num2 = Integer.parseInt(a2[r]);

                    if (num1 == num2)
                        continue;
                    else if (num1 > num2) {
                        final String tmp = l[i];
                        l[i] = l[j];
                        l[j] = tmp;
                    }
                    sorted = true;
                    break;
                }

                if (!sorted && a1.length > a2.length) {
                    final String tmp = l[i];
                    l[i] = l[j];
                    l[j] = tmp;
                }

            }
        }

        return l;
    }
}
