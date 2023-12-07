package virtuso;

import java.util.Scanner;

public class HardikJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        scanner.close();

        int hardikGoals = 0;
        int jackGoals = 0;
        while (z > 1 && (x > 1 || y > 1)) {
            if (x > 1 && x % z == 0) {
                hardikGoals++;
                x--;
                continue;
            }
            if (y > 1 && y % z == 0) {
                jackGoals++;
                y--;
                continue;
            }
            z--;
        }
        System.out.println(hardikGoals + " " + jackGoals);
    }
}
