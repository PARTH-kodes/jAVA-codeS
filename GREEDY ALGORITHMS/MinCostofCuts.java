import java.util.*;

public class MinCostofCuts {
    public static void getMinCost(int[] hc, int[] vc) {
        Integer horCost[] = Arrays.stream(hc).boxed().toArray(Integer[]::new); /*
                                                                                * converts primitive type array to its
                                                                                * objects type array
                                                                                */
        Integer vertCost[] = Arrays.stream(vc).boxed().toArray(Integer[]::new);

        Arrays.sort(horCost, Collections.reverseOrder());
        Arrays.sort(vertCost, Collections.reverseOrder());

        int horCuts = 0, vertCuts = 0;
        int horPiece = 1, vertPiece = 1; /*
                                          * initially the complete thing is one single piece, both horizontally and
                                          * vertically.
                                          */
        int minCost = 0;

        while (horCuts < horCost.length && vertCuts < vertCost.length) {
            if (horCost[horCuts] <= vertCost[vertCuts]) { // vertical cost > horizontal cost therefore vertical cut
                minCost += vertCost[vertCuts] * horPiece;
                vertPiece++; // 1 vertical cut increases 1 vertical piece
                vertCuts++;
            } else { // horizontal cost > vertical cost therefore horizontal cut
                minCost += horCost[horCuts] * vertPiece;
                horPiece++; // 1 horizontal cut increases 1 horizontal piece
                horCuts++;
            }
        }

        while (horCuts < horCost.length) { // for any remaining horizontal cuts
            minCost += horCost[horCuts] * vertPiece;
            horPiece++;
            horCuts++;
        }

        while (vertCuts < vertCost.length) { // for any remaining vertical cuts
            minCost += vertCost[vertCuts] * horPiece;
            vertPiece++;
            vertCuts++;
        }

        System.out.println("Minimum Cost to cut the object is: " + minCost);
    }

    public static void main(String[] args) {
        int[] horCost = { 4, 1, 2 };
        int[] vertCost = { 2, 1, 3, 1, 4 };
        getMinCost(horCost, vertCost);
    }
}