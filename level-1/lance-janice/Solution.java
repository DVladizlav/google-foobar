public class Solution {

    public static String solution(String s) {
        // 26 = number of characters (a-z) we want to reverse
        final int[] table = new int[26];
        int start = table.length - 1;
        for (int i = 0; i < table.length; i++) {
            table[i] = start;
            start -= 2;
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int tempChar = s.charAt(i);
            // ASCII a-z = 97-122
            if (tempChar >= 97 && tempChar <= 122) {
                tempChar += table[tempChar - 97];
            }
            res += (char) tempChar;
        }

        return res;
    }
}
