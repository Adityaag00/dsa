import java.util.Scanner;

public class Subarray {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int arr[] = new int[n];

        for(int i=0;i<n;i++) {
            arr[i]=in.nextInt();
        }
        countSubarrays(arr, n);
    }

    static void countSubarrays(int a[], int n)
    {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            int count=0;
            for (int j = i; j < n; j++)
            {
                sum+=a[j];
                count++;
                if (perfectCube(sum)) {
                    ans=Math.min(ans,count);
                }
            }
        }

        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
    }
    static boolean perfectCube(int N)
    {
        int cube_root;
        cube_root = (int)Math.round(Math.pow(N, 1.0 / 3.0));
        if (cube_root * cube_root * cube_root == N)
        {
            return true;
        }
        return false;
    }
}
