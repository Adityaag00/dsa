import java.util.Scanner;

public class PatternX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n*2; j++) {
                if(j==n*2-i || j==i) {
                    System.out.print(i);
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j < n*2; j++) {
                if(j==n*2-i || j==i) {
                    System.out.print(i);
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
