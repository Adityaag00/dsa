import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MaxCoins {

    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int dp[][] = new int[n + 1][1001];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }
        int maxor = Max_Xor(arr, 0, 0, n, dp);
        System.out.println((k%mod*maxPar(maxor*2,"",new HashMap<>())%mod)%mod);
    }

    static long maxPar(int n, String s, HashMap<String,Long> m) {
        if(n==0) {
            if(isValid(s)) {
                return 1;
            }
            return 0;
        }
        long ans= (maxPar(n-1,s+"(",m)%mod+maxPar(n-1,s+")",m)%mod)%mod;
        m.put(n+s,ans);
        return ans%mod;
    }

    static int Max_Xor(int arr[], int i, int mask, int n, int dp[][]) {
        if(i==n) {
            return mask;
        }

        if (dp[i][mask] != -1)
            return dp[i][mask];

        int ans = 0;

        ans = Max_Xor(arr, i + 1,
                mask ^ arr[i], n, dp);

        ans = Math.max(ans, Max_Xor(arr, i + 1,
                mask, n, dp));

        return dp[i][mask] = ans;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
