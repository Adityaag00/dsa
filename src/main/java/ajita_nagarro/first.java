package ajita_nagarro;

import java.util.Scanner;

public class first {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        Boolean flag = null;

        StringBuilder sb = new StringBuilder();
        Boolean nextCapital = false;
        for (char ch : s.toCharArray()) {
            if (ch == '_') {
                flag = false;
                break;
            } else if (Character.isUpperCase(ch)) {
                flag = true;
                break;
            }
        }
        for (char ch : s.toCharArray()) {
            if (!flag) {
                if (ch == '_') {
                    nextCapital = true;
                } else if (nextCapital == true) {
                    sb.append(Character.toUpperCase(ch));
                    nextCapital = false;
                } else {
                    sb.append(ch);
                }
            } else if (flag) {
                if (Character.isUpperCase(ch)) {
                    sb.append('_');
                    sb.append(Character.toLowerCase(ch));
                } else {
                    sb.append(ch);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
