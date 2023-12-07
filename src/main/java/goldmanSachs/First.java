package goldmanSachs;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] dishes = sc.nextLine().split(" ");

        for (String dish : dishes) {
            int itemNumber = Integer.parseInt(dish);
            int daysToRepeat = getDaysToRepeat(itemNumber);

            if (daysToRepeat > 60) {
                System.out.print("F ");
            } else {
                System.out.print(daysToRepeat + " ");
            }
        }

        sc.close();
    }

    public static int getDaysToRepeat(int itemNumber) {
        int sum = 0;
        int temp = itemNumber;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        if (sum == itemNumber) {
            return 1;
        }

        int[] memo = new int[3000000]; // memoization array for faster lookups
        memo[sum] = 1; // initialize memoization array

        for (int i = 2; i <= 60; i++) {
            sum = getSumOfFactorials(sum);
            if (sum == itemNumber) {
                return i;
            }
            if (memo[sum] != 0) { // if the sum has already been calculated, we can skip the rest of the iterations
                return 61;
            }
            memo[sum] = i; // update memoization array
        }

        return 61;
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 6;
        }
        if (n == 4) {
            return 24;
        }
        if (n == 5) {
            return 120;
        }
        if (n == 6) {
            return 720;
        }
        if (n == 7) {
            return 5040;
        }
        if (n == 8) {
            return 40320;
        }
        if (n == 9) {
            return 362880;
        }
        return 3628800; // n = 10
    }

    public static int getSumOfFactorials(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += factorial(digit);
            n /= 10;
        }
        return sum;
    }

}
