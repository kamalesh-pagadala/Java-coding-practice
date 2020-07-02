import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LengthOfLongestSubstring {

    /**
     * returns the length of longest string
     *
     * @param s
     * @return
     */
    public int findLengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> mySet = new HashSet<>();
        int result = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (isUnique(s, i, j)) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }

    /**
     * Finds if the string is unique or not
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean isUnique(String s, int start, int end) {

        Set<Character> mySet = new HashSet<>();
        for (int k = start; k < end; k++) {
            Character ch = s.charAt(k);
            if (mySet.contains(ch)) {
                return false;
            } else {
                mySet.add(ch);
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String input = in.nextLine();

        LengthOfLongestSubstring soln = new LengthOfLongestSubstring();
        int length = soln.findLengthOfLongestSubstring(input);
        System.out.println(length);

    }
}
