import java.util.Scanner;

public class SpecialSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int prev = 0;
            int k = in.nextInt();
            String ans = "";
            if (k % 2 != 0) {
                prev = 1;
            }
            for (int i = 1; i < n; i++) {
                int tmp = in.nextInt();
                if (tmp % 2 == 0) {
                    if (prev == 1) {
                        prev = 0;
                    } else {
                        ans = "NO";
                    }
                } else {
                    if (prev == 0) {
                        prev = 1;
                    } else {
                        ans = "NO";
                    }
                }
            }
            if(ans.equals("")) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
