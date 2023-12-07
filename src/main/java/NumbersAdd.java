import java.util.Scanner;

public class NumbersAdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        int ans=0;
        for(char c:s.toCharArray()) {
            if(Character.isDigit(c)) {
                ans+=(c-'0');
            }
        }
        System.out.println(ans);
    }
}
