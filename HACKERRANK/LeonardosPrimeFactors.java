import java.util.*;

public class LeonardosPrimeFactors
{
    public static boolean isPrime(long n){
        for(long i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static long primeCount(long n){
        if(n == 1) return 0;

        long count = 0, i = 2;

        while(n >= i){

            if(i > 2 && i % 2 == 0){
                i++;
                continue;
            }
            if(isPrime(i)){
                n /= i;
                count++;
            }
            i++;
        }

        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of test cases: ");
        int tc = sc.nextInt();

        while(tc-- > 0){
            System.out.println("Enter the number: ");
            long n = sc.nextLong();
            
            System.out.println(primeCount(n));

        }

        sc.close();
    }
}