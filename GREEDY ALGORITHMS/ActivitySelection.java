import java.util.*;

public class ActivitySelection {
    public static void selectMaxActivity(int start[], int end[]) {

        // store the indices, start time and end time of each activity in a 2-D Array
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // sort the activities on the basis of the end time
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        List<Integer> ans = new ArrayList<>();
        int maxAct = 1;
        ans.add(activities[0][0]);
        int lastAct = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastAct) {
                maxAct++;
                lastAct = activities[i][2];
                ans.add(activities[i][0]);
            }
        }
        System.out.println("Maximum Activity to be performed: " + maxAct);
        // System.out.println(ans);
        for (Integer integer : ans) {
            System.out.print("A" + integer + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of activities");
        int n = sc.nextInt();
        int start[] = new int[n];
        int end[] = new int[n];
        System.out.println("Enter the start time and respective end time of each activity:");
        for (int i = 0; i < end.length; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        selectMaxActivity(start, end);

        sc.close();
    }
}