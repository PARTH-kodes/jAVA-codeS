/* Given a list s that initially contains only a single value 0. There will be q queries of the following types:

0 x: Insert x in the list
1 x: For every element a in s, replace it with a ^ x. ('^' denotes the bitwise XOR operator)
Return the sorted list after performing the given q queries.

Example 1:

Input:
q = 5
queries[] = {{0, 6}, {0, 3}, {0, 2}, {1, 4}, {1, 5}}
Output:
1 2 3 7
Explanation:
[0] (initial value)
[0 6] (add 6 to list)
[0 6 3] (add 3 to list)
[0 6 3 2] (add 2 to list)
[4 2 7 6] (XOR each element by 4)
[1 7 2 3] (XOR each element by 5)
The sorted list after performing all the queries is [1 2 3 7]. 
Example 2:
Input:
q = 3
queries[] = {{0, 2}, {1, 3}, {0, 5}} 
Output :
1 3 5
Explanation:
[0] (initial value)
[0 2] (add 2 to list)
[3 1] (XOR each element by 3)
[3 1 5] (add 5 to list)
The sorted list after performing all the queries is [1 3 5].

*/

import java.util.*;

public class QueriesinList {
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        
        ArrayList<Integer> arrLst = new ArrayList<>();
        int xor = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            if (queries[i][0] == 1)
                xor ^= queries[i][1];
            else
                arrLst.add(queries[i][1] ^ xor);
        }
        arrLst.add(0 ^ xor);
        arrLst.sort((a, b) -> a - b);
        return arrLst;
    }

    public static void main(String[] args) {
        int q = 5;
        int queries[][] = { { 0, 6 }, { 0, 3 }, { 0, 2 }, { 1, 4 }, { 1, 5 } };
        ArrayList<Integer> result = constructList(q, queries);
        System.out.println(result);
    }
}