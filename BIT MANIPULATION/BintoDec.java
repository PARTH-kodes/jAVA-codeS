import java.util.*;

public class BintoDec    
{
    public static long converter(long binNum) {
        long decNum = 0;
        int pow = 0;
        while (binNum != 0) {
            if ((binNum % 10 == 0) || (binNum % 10 == 1)) {
                decNum = decNum + ((binNum % 10) * (int) Math.pow(2, pow));
                binNum /= 10;
                pow++;
            }
            else {
                return -1;
            }
            
        }
        return decNum;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a binary number: ");
        long binNum = sc.nextLong();
        if (converter(binNum) == -1) {
            System.out.println("Enter a valid binary value only.");
        }
        else {
            System.out.println("Decimal equivalent of " + binNum + " is: " + converter(binNum));
        }
        sc.close();
    }
}