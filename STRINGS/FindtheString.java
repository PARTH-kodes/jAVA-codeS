/* Given two integers N and K, the task is to find the string S of minimum length such that it contains all possible strings of size N as a substring. The characters of the string should be from integers ranging from 0 to K-1.  

Example 1:

Input:
N = 2, K = 2
Output: 
00110
Explanation: 
Allowed characters are from 0 to k-1 (i.e., 0 and 1).
There are 4 string possible of size N=2 
(i.e "00", "01","10","11")
"00110" contains all possible string as a 
substring. It also has the minimum length.
Example 2:

Input:
N = 2, K = 3
Output: 
0010211220
Explanation: 
Allowed characters are from 0 to k-1 (i.e., 0, 1 and 2).
There are total 9 strings possible
of size N, given output string has the minimum
length that contains all those strings as substring. */


import java.util.*;
// import java.lang.*;
import java.io.*;

public class FindtheString {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        System.out.println("Enter the number of test cases");
        FindtheString ob = new FindtheString();
        int t = sc.nextInt();
        while (t-- != 0) {
            System.out.println("Enter the length of each string :\nEnter the range of input characters :");
            int N = sc.nextInt(), K = sc.nextInt();
            String ans = ob.findString(N, K);
            boolean ok = true;
            for (int i = 0; i < ans.length(); i++) {
                char c = ans.charAt(i);
                if (c < '0' || c > K - 1 + '0')
                    ok = false;
            }
            if (!ok) {

                System.out.println("-1");
                continue;
            }
            HashSet<String> st = new HashSet<String>();
            for (int i = 0; i + N - 1 < ans.length(); i++) {
                st.add(ans.substring(i, i + N));
            }
            int tot = 1;
            for (int i = 1; i <= N; i++)
                tot *= K;

            if (st.size() == tot) {
                out.println(ans.length());
            } else {
                out.println("-1");
            }
        }
        out.flush();
    }

    public String findString(int n, int k) {

        K = k;

        N = n;

        st.clear();

        if (n == 1) {

            char[] r = new char[k];

            for (int i = 0; i < k; i++)

                r[i] = (char) (i + '0');

            return new String(r);

        }

        tot = 1;

        for (int i = 1; i <= n; i++)

            tot *= k;

        char[] ansa = new char[n];

        Arrays.fill(ansa, '0');

        ans = new String(ansa);

        st.add(ans);

        dfs();

        return ans;

    }

    int K, N;

    long tot;

    HashSet<String> st = new HashSet<>();

    String ans;

    boolean dfs() {

        if (st.size() == tot) {

            return true;

        }

        String tmp = "";

        if (N > 1) {

            tmp = ans.substring(ans.length() - N + 1);

        }

        for (int i = 0; i < K; i++) {

            tmp += i;

            if (!st.contains(tmp)) {

                ans += i;

                st.add(tmp);

                if (dfs())

                    return true;

                st.remove(tmp);

                ans = ans.substring(0, ans.length() - 1);

            }

            tmp = tmp.substring(0, tmp.length() - 1);

        }

        return false;
    }
}