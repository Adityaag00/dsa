import java.util.*;

public class infy1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int m= in.nextInt();
        int mat[][]  = new int[n][m];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j]=in.nextInt();
            }
        }
        palindromeMatrix(n,m,mat);
    }

    static class pair
    {
        int first, second;
        public pair(int first,
                    int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    static void palindromeMatrix(int N, int M,
                                 int[][] arr)
    {
        int ans = 0;

        for (int i = 0; i < (N + 1) / 2; i++)
        {
            for (int j = 0; j < (M + 1) / 2; j++)
            {
                HashSet<pair> s = new HashSet<>();
                s.add(new pair(i, j));
                s.add(new pair(i, M - j - 1));
                s.add(new pair(N - i - 1, j));
                s.add(new pair(N - i - 1, M - j - 1));

                Vector<Integer> values = new Vector<>();
                for (pair p : s)
                {
                    values.add(arr[p.first][p.second]);
                }

                int max = Collections.max(values)/2;

                for (int k = 1;
                     k < values.size(); k++)
                {
                    if(values.get(k)>=max) {
                        ans += values.get(k)-max;
                    }
                    else {
                        ans += max - values.get(k);
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
