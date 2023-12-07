import java.util.Scanner;

public class LittleJohny {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int x=1;
        while(true) {
            int sumOfDigits = getSumOfDigits(x);
            if(sumOfDigits!=n) {
                x++;
                continue;
            }
            if(x%n!=0) {
                x++;
                continue;
            }
            if(x==n) {
                x++;
                continue;
            }
            break;
        }
        System.out.println(x);
    }

    static int getSumOfDigits(int n) {
        int sum;

        /* Single line that calculates sum */
        for (sum = 0; n > 0; sum += n % 10,
                n /= 10);

        return sum;
    }
}
