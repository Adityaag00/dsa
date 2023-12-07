import java.util.Scanner;

public class MaximumPointsInsideRectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] mat = new int[10][10];

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            mat[x][y]++;
        }
        int l = in.nextInt();
        int b = in.nextInt();

        int[][] pre = prefixSum2D(mat);

//        for (int[] a : pre) {
//            for (int x : a) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }
        int ans = Integer.MIN_VALUE;
        int x = 0, y = 0;
        for (int i = l + 1; i < pre.length; i++) {
            for (int j = b + 1; j < pre[0].length; j++) {
                int val = pre[i][j] - pre[i][j - l - 1] - pre[i - b - 1][j] + pre[i - b - 1][j - l - 1];
                if (val > ans) {
                    x = i;
                    y = j;
                }
                ans = Math.max(ans, val);
            }
        }
        System.out.println(ans);
        System.out.println(x+" "+y);
    }

    public static int[][] prefixSum2D(int a[][]) {
        int R = a.length;
        int C = a[0].length;

        int[][] psa = new int[R][C];
        psa[0][0] = a[0][0];
        for (int i = 1; i < C; i++)
            psa[0][i] = psa[0][i - 1] + a[0][i];
        for (int i = 1; i < R; i++)
            psa[i][0] = psa[i - 1][0] + a[i][0];
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                psa[i][j] = psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1] + a[i][j];
            }
        }
        return psa;
    }
}
