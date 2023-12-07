import java.util.Scanner;

public class CocubesShreyash1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(solve(10,20,4));
    }

    public static int solve(int a,int b , int n) {
        int ans=0;
        for (int i = a; i <= b; i++) {
            if(isPrime(i)) {
                if(getSum(i)%n==0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    static int getSum(int n)
    {
        int sum = 0;

        while (n != 0)
        {
            sum = sum + n % 10;
            n = n/10;
        }

        return sum;
    }

    public static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        // Check if n=2 or n=3
        if (n == 2 || n == 3)
            return true;

        // Check whether n is divisible by 2 or 3
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        // Check from 5 to square root of n
        // Iterate i by (i+6)
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;

    }
}
