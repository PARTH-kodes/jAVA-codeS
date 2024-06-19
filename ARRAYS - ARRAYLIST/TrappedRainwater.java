public class TrappedRainwater {

    public static int trappedWater(int heights[]) {
        int trapWater = 0;

        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];

        leftMax[0] = heights[0];
        rightMax[rightMax.length - 1] = heights[heights.length - 1];

        for (int i = 1; i < heights.length; i++) {
            leftMax[i] = Integer.max(heights[i], leftMax[i - 1]);
            rightMax[rightMax.length - i - 1] = Integer.max(heights[heights.length - i - 1],
                    rightMax[rightMax.length - i]);
        }

        for (int i = 0; i < heights.length; i++) {
            trapWater += Integer.min(rightMax[i], leftMax[i]) - heights[i];
        }
        return trapWater;
    }

    public static void main(String[] args) {
        int[] heights = { 4, 2, 0, 6, 3, 2, 5 };

        System.out.println("Maximum amount of rainwater trapped is: " + trappedWater(heights));

    }
}