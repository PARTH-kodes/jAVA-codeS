import java.util.*;

public class MaximumChainLength {
    public static int findChainLength(int pairs[][]) {
        int availableChains[][] = new int[pairs.length][3];
        for (int i = 0; i < pairs.length; i++) {
            availableChains[i][0] = i;
            availableChains[i][1] = pairs[i][0];
            availableChains[i][2] = pairs[i][1];
        }

        Arrays.sort(availableChains, Comparator.comparingDouble(o -> o[2]));
        ArrayList<Integer> chain = new ArrayList<>();
        int chainLength = 1;
        chain.add(availableChains[0][0]);
        int lastEnd = availableChains[0][2];

        for (int i = 1; i < pairs.length; i++) {
            if (availableChains[i][1] >= lastEnd) {
                chainLength++;
                chain.add(availableChains[i][0]);
                lastEnd = availableChains[i][2];
            }
        }
        for (int i = 0; i < chain.size(); i++) {
            System.out.println("Chain No." + (chain.get(i) + 1));
        }

        return chainLength;
    }

    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        System.out.println("The maximum length of the chain formed is: " + findChainLength(pairs));
    }
}