import java.util.Scanner;

public class DiceOddsAB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b= in.nextInt();

        System.out.println(Math.pow(2, a ) - 2);
        //H HT||| TH
        //HTH TTH
    }
}
