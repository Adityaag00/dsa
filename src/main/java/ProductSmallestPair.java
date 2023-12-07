import java.util.Arrays;
import java.util.Scanner;

public class ProductSmallestPair {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int n =in.nextInt();

        int[] arr = new int[n];

        for(int i =0;i<n;i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;

        if(n<2) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(i+1>=n) {
                    break;
                }
                if(arr[i]+arr[j]<=sum) {
                    ans = Math.min(ans,arr[i]*arr[j]);
                }
                else {
                    break;
                }
            }
        }

        System.out.println(ans==Integer.MAX_VALUE?0:ans);
    }
}
