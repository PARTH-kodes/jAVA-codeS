/*Given a binary string s. Perform r iterations on string s, where in each iteration 0 becomes 01 and 1 becomes 10. Find the nth character (considering 0 based indexing) of the string after performing these r iterations (see examples for better understanding).

Example 1:

Input:
s = "1100"
r = 2
n = 3
Output:
1
Explanation: 
After 1st iteration s becomes "10100101".
After 2nd iteration s becomes "1001100101100110".
Now, we can clearly see that the character at 3rd index is 1, and so the output.

Example 2:

Input:
s = "1010"
r = 1
n = 2
Output:
0
Explanation : 
After 1st iteration s becomes "10011001".
Now, we can clearly see that the character at 2nd index is 0, and so the output.*/

import java.util.*;

public class NthCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch = nCharacter("1010", 1, 2);
        System.out.println(ch);

        sc.close();
    }

    public static char nCharacter(String s, int r, int n) {
        if (r == 0) {
            return s.charAt(n);
        } else {
            String str = "";
            for (int i = 1; i <= r; i++) {
                str = "";
                for (int j = 0; j <= n; j++) {
                    str += (s.charAt(j) == '1') ? "10" : "01";
                }
                s = str;
            }
            // System.out.println(str);
            return (s.charAt(n));
        }
    }
}