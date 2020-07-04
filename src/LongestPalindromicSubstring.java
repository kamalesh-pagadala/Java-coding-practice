public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int len = s.length();

        if (s.isEmpty()) {
            return "";
        }

        int longestString = 0;
        int start = 0;
        int end = 0;

        boolean[][] palindromic = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            palindromic[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || palindromic[i + 1][j - 1])) {
                    palindromic[i][j] = true;
                    if (j - i + 1 > longestString) {
                        longestString = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end);
    }
}
