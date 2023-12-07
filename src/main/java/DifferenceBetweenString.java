import java.util.Scanner;

public class DifferenceBetweenString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        int min = 0, max = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '?' || b.charAt(i) == '?') {
                max++;
                continue;
            }
            if (a.charAt(i) != b.charAt(i)) {
                min++;
                max++;
            }
        }
        System.out.println(min+" "+max);
    }
}
