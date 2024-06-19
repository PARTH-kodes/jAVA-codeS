public class stringCompression {

    public static String compression(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(str.charAt(0));
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                if (count != 1) {
                    sb.append(count);
                    count = 1;
                }
                sb.append(str.charAt(i));
            }
        }
        return (sb.toString());
    }

    public static void main(String[] args) {

        System.out.println(compression("abcd "));
    }
}