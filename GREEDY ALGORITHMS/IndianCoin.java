import java.util.*;

public class IndianCoin {
    public static int minDenomination(int currency[], int fare) {
        int count = 0;
        Arrays.sort(currency);

        for (int i = currency.length - 1; i >= 0; i--) {
            if (currency[i] < fare && fare > 0) {
                System.out.println(currency[i] + " -> " + (fare / currency[i]) + " times.");
                count += (fare / currency[i]);
                fare -= (currency[i] * (fare / currency[i]));
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currency[] = { 1, 2, 5, 20, 100, 10, 50, 2000, 500 };
        System.out.println("Enter the amount to be paid: ");
        int fare = sc.nextInt();
        System.out.println("The minimum amount of currencies given are: " + minDenomination(currency, fare));

        sc.close();
    }
}