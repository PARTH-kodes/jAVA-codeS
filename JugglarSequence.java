import java.util.*;

public class JugglarSequence
{
    public static List<Long> printSequence(long n) {
        List<Long> store = new ArrayList<>();
        store.add(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n = (long) Math.sqrt(n);
                store.add(n);
            } else {
                n = (long) (Math.sqrt(Math.pow(n, 3)));
                store.add(n);
            }
        }
        System.out.println(store);
        return store;
    }
    public static void main(String[] args)
    {
        printSequence(798465632);
    }
}