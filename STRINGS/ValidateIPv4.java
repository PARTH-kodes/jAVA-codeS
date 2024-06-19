import java.util.*;

public class ValidateIPv4 {
    public static boolean isValid(String s) {
        if (s.startsWith(".") || s.endsWith(".")) {
            return false;
        }

        StringTokenizer parts = new StringTokenizer(s, ".");
        // System.out.println(parts.countTokens());
        if (parts.countTokens() != 4) {
            return false;
        }
        while (parts.hasMoreTokens()) {
            String currToken = parts.nextToken();

            if (currToken.isBlank() || !currToken.matches("\\d+")) {
                return false;
            }
            // System.out.println(currToken);
            if (currToken.length() > 1 && currToken.charAt(0) == '0') {
                return false;
            } else {
                int part = Integer.parseInt(currToken);
                if (part < 0 || part > 255) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("0.0.0.0."));
    }
}