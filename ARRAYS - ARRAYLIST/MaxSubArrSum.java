public class MaxSubArrSum {
    public static int subArrays(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += numbers[k];
                }
                maxSum = Integer.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int preArray(int numbers[]) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        int prearr[] = new int[numbers.length];
        prearr[0] = numbers[0];
        for (int i = 1; i < prearr.length; i++) {
            prearr[i] = prearr[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {

                currSum = (i == 0) ? prearr[j] : prearr[j] - prearr[i - 1];

                maxSum = Integer.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    public static long Kadane_algo(int numbers[]) {
        long maxSum = Long.MIN_VALUE, currSum = 0;
        for (int i = 0; i < numbers.length; i++) {

            currSum += numbers[i];
            maxSum = Long.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] numbers = { 0, -6, 4, 3, 2, -5, -5 };

        int brute_force = subArrays(numbers);
        int prefixArray = preArray(numbers);
        long Kadane = Kadane_algo(numbers);

        System.out.println("Max subarray sum: " + brute_force);
        System.out.println("Max subarray sum: " + prefixArray);
        System.out.println("Max subarray sum: " + Kadane);

    }
}