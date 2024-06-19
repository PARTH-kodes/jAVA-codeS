import java.util.*;

public class FractionalKnapsack {
    public static void maxKnapsack(int price[], int weight[], int W) {
        double ratio[][] = new double[price.length][2];
        for (int i = 0; i < price.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = price[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble((double[] o) -> o[1]).reversed());
        double maxValue = 0;

        // ArrayList<Double> currValue = new ArrayList<>(); /*
        // * The array list or the
        // * // HashMap are used to store the quantity and the value of
        // * each quantity
        // */
        // ArrayList<Integer> quantity = new ArrayList<>();

        HashMap<Integer, Double> contains = new HashMap<>();
        for (int i = 0; i < price.length; i++) {
            int indx = (int) ratio[i][0];
            if (weight[indx] <= W) {
                maxValue += price[indx];
                W -= weight[indx];
                // quantity.add(indx);
                // currValue.add((double) value[indx]);
                contains.put(indx, (double) price[indx]);
            } else {
                maxValue += ratio[i][1] * W;
                // quantity.add(indx);
                // currValue.add(ratio[i][1] * W);
                contains.put(indx, ratio[i][1] * W);
                W = 0;
                break;
            }
        }
        System.out.println("The maximum quantities the knapsack can contain: " + maxValue);
        System.out.println("The quantity and its price contained in knapsack are:");
        for (Map.Entry<Integer, Double> entry : contains.entrySet()) {
            System.out.println("Q" + entry.getKey() + 1 + " -> " + entry.getValue());
        }
        // for (int i = 0; i < contains.size(); i++) {
        // System.out.println("Q" + quantity.get(i) + " -> " + currValue.get(i));
        // }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of quantities:");
        int n = sc.nextInt();
        int weight[] = new int[n];
        int price[] = new int[n];
        System.out.println("Enter the price and weight of each quantity:");
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        System.out.println("Enter the maximum weight Knapsack can hold: ");
        int W = sc.nextInt();

        maxKnapsack(price, weight, W);
        sc.close();
    }
}