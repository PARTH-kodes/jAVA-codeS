// import java.lang.*;

import java.util.*;

class BetterString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter \"1\" to know what does the program do");
        int choice = sc.nextInt();
        char choices = ' ';

        if (choice == 1) {
            System.out.println(
                    "The program returns the better string between the two user input strings.\nThe better string is the    string having more number of distinct subsequences.");
            System.out.println("Enter \"Y\" to continue with the program.\nElse Enter \"N\" to terminate.");
            choices = sc.next().charAt(0);
        }
        if (choices == 'Y' || choices == 'y') {
            System.out.println("Enter the number of test cases");
            int t = sc.nextInt();
            while (t-- > 0) {
                System.out.print("Enter two strings to compare for better string: ");
                String str1 = sc.next();
                String str2 = sc.next();

                String ans = betterString(str1, str2);
                System.out.println("The better string is: " + ans + "\n");
            }
        } else if (choices == 'N' || choices == 'n') {
            System.out.println("Program Terminated");
        } else {
            System.out.println("Wrong command.\nProgram Terminated.\nRun again.");
        }
        sc.close();
    }

    public static String betterString(String str1, String str2) {

        int n1 = getUniqueSubsequence(str1);

        int n2 = getUniqueSubsequence(str2);

        return n1 >= n2 ? str1 : str2;

    }

    public static int getUniqueSubsequence(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {

            int x = hm.getOrDefault(s.charAt(i - 1), -1);

            dp[i] = (2 * dp[i - 1]) - (x > 0 ? dp[x - 1] : 0);

            hm.put(s.charAt(i - 1), i);

        }

        return dp[s.length()];

    }
}