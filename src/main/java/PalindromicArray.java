import java.util.Scanner;

public class PalindromicArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i]=longestPalindrome(in.next());
        }
        int dp[][] = new int[n+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j]=-1;
            }
        }

        System.out.println( min(0,nums.length-1,nums,dp ));
    }

    public static int min(int l,int h,int[] nums,int[][] dp) {
        if(l==h) {
            return 0;
        }
        if(l>h || l>nums.length || h<0) {
            return 0;
        }
        if(dp[l][h]!=-1) {
            return dp[l][h];
        }
        int ans=0;
        if(nums[l]!=nums[h]) {
            ans = Math.min(min(l,h-1,nums,dp),min(l+1,h,nums,dp));
            ans++;
        }
        else {
            ans=min(l+1,h-1,nums,dp);
        }
        return dp[l][h]=ans;
    }


    public static int longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res.length();
    }
}
