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

        for (int j = 0; j < len;j++) {
            palindromic[j][j] = true;
            for (int i = 0; i < j; i++) {
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
        return s.substring(start, end+1);
    }
}
