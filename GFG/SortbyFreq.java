import java.util.*;

public class SortbyFreq
{
    public static ArrayList<Integer> sortByFreq(int arr[]){
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(arr);

        int freq[][] = new int[arr.length][2];

        freq[0][0] = arr[0];
        freq[0][1] = 1;
        int k = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == freq[k][0]){
                freq[k][1]++;
            }else{
                freq[++k][0] = arr[i];
                freq[k][1] = 1;
            }
        }

        Arrays.sort(freq, (a, b) -> Integer.compare(b[1], a[1]));

        for(int i = 0; i <= k; i++){
            while(freq[i][1]-- > 0){
                result.add(freq[i][0]);
            }
        }

        return result;
    }
    public static void main(String[] args)
    {
        int arr[] = {5,9,2,9};
        ArrayList<Integer> result = sortByFreq(arr);
        System.out.println((result.toString()));
    }
}