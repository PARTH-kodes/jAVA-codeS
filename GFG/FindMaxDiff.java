import java.util.*;

public class FindMaxDiff
{
    public static int maxDiff(int arr[]){
        int ls[] = new int[arr.length];
        int rs[] = new int[arr.length];
        
        Stack<Integer> st = new Stack<>();
        
        ls[0] = 0;
        rs[arr.length - 1] = 0;
        st.push(0);
        
        for(int i = 1; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                    st.pop();
            }
            if(!st.isEmpty()){
                ls[i] = arr[st.peek()];
            }else{
                ls[i] = 0;
            }
            st.push(i);
        }
        
        st.clear();

        st.push(arr.length - 1);
        
        for(int i = arr.length - 2; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rs[i] = arr[st.peek()];
            } else{
                rs[i] = 0;
            }
            st.push(i);
        }
        
        int max = -1;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, (int)Math.abs(ls[i] - rs[i]));
        }

        System.out.println(max);
        return 0;
    }
    public static void main(String[] args)
    {
        int arr[] = {2,4,8,7,7,9,3};
        maxDiff(arr);
    }
}