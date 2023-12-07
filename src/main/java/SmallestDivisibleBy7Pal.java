import java.util.List;
import java.util.Scanner;

public class SmallestDivisibleBy7Pal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            List<Integer> pals = getPalindrome(n);
            int res = 0;
            for (int i = pals.get(0); i < pals.get(1); i++) {
                StringBuilder tempBuilder = new StringBuilder(""+i);
                String temp = ""+i;
                String tempRev = tempBuilder.reverse().toString();
                if(!temp.equals(tempRev)) {
                    continue;
                }
                if (i % 7 == 0) {
                    res = i;
                    break;
                }
            }
            System.out.println(res);
        }
    }

    static List<Integer> getPalindrome(int n) {
        if (n == 1) {
            return List.of(0, 9);
        } else {
            return List.of(((int) (Math.pow(10, n - 1))) + 1, (((int) (Math.pow(10, n))) - 1));
        }
    }
}
