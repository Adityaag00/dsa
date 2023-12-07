import java.util.Scanner;

public class DivisiblePrimeCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        int ans = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                int sum = getSum(i);
                if (sum % n == 0) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        return sum;
    }

    static boolean isPrime(int n) {

        if (n <= 1)
            return false;

        else if (n == 2)
            return true;

        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
