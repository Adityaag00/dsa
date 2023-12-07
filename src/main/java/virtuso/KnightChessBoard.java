package virtuso;

import java.util.Scanner;

public class KnightChessBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += countWays(i, j, n, m);
            }
        }
        System.out.println(count);
    }

    private static int countWays(int row, int col, int n, int m) {
        int count = 0;
        int[][] moves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                count++;
            }
        }
        return count;
    }
}
