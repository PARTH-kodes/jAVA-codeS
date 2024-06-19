/* 
 * Given a string S consisting of only lowercase and uppercase English letters and spaces, your task is to convert it into title case. In title case, the first letter of each word is capitalized while the rest are in lowercase, except for words that are entirely in uppercase (considered as acronyms), which should remain unchanged.

Note:

Words are defined as contiguous sequences of English letters separated by spaces.
Acronyms are words that are entirely in uppercase and should remain unchanged.
Assume the input does not contain leading, trailing, or multiple spaces between words.

 */
public class TitleCaseString {
    public static String titleCase(String str, String temp, StringBuilder result) {
        String words[] = str.split("\\s+");
        for (String string : words) {
            if (string.equals(string.toUpperCase())) {
                result.append(string).append(" ");
            } else {
                char firstChar = Character.toUpperCase(string.charAt(0));
                String remaining = string.substring(1).toLowerCase();
                result.append(firstChar).append(remaining).append(" ");
            }
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "WELCOME to the JUNGLE";
        String s = "the quick BROWN fOx";

        String temp = "";
        titleCase(str, temp, new StringBuilder(""));
        titleCase(s, temp, new StringBuilder(""));
    }
}