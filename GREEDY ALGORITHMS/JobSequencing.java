import java.util.*;

public class JobSequencing {

    static class Job {
        int profit;
        int deadline;
        char id;

        Job(char id, int deadline, int profit) {
            this.profit = profit;
            this.deadline = deadline;
            this.id = id;
        }
    }

    public static void maxProfitJobs(int jobInfo[][]) {
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job((char) (i + 65), jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        ArrayList<Character> jobsDone = new ArrayList<>();
        int time = 0, maxProfit = 0;

        for (Job job : jobs) {
            if (time < job.deadline) {
                time++;
                jobsDone.add(job.id);
                maxProfit += job.profit;
            }
        }

        System.out.println("The maximum jobs done by a person are: " + jobsDone.size()
                + "\nThe maximum profit gained in these jobs are: " + maxProfit);
        System.out.println("Jobs Done: " + jobsDone);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of jobs available: ");
        int n  = sc.nextInt();
        int jobInfo[][] = new int[n][n];
        System.out.println("Enter the deadline and the profit of each job respectively");

        for (int i = 0; i < n; i++) {
            jobInfo[i][0] = sc.nextInt();
            jobInfo[i][1] = sc.nextInt();
        }

        sc.close();
        // int jobInfo[][] = { { 4, 20 }, { 1, 30 }, { 1, 40 }, { 1, 20 } };
        maxProfitJobs(jobInfo);
    }
}