import java.util.Scanner;

public class Ones {
    static int[] seg = new int[4 * 100000];
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n= in.nextInt();
        int[] arr = new int[n];

        for (int i=0;i<n;i++) {
            arr[i]=in.nextInt();
        }
        int q = in.nextInt();
        pair[] queries = new pair[q];
        for (int i = 0; i < q; i++) {
            queries[i]=new pair(in.nextInt(),0);
        }
        for (int i = 0; i < q; i++) {
            queries[i].second=in.nextInt();
        }
        constructST(arr,arr.length);
        int mod=1000000007;
        for(pair p:queries) {
            int one=query(0,n-1,p.first-1,p.second-1,0);
            int total = p.second-p.first+1;
            int zero=total-one;
            int t= (1<<(one))-1;
            int zerosans=0;
            if(zero>0) {
                zerosans=((t%mod)*((1<<(zero)-1)%mod)%mod);
            }
            int ans=((t%mod)+(zerosans%mod))%mod;
            System.out.println(ans);
        }
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

    static int query(int ss, int se, int qs, int qe, int index)
    {
        if (qs <= ss && qe >= se) {
            return seg[index];
        }

        if (se < qs || ss > qe)
            return 0;
        int mid = getMid(ss, se);
        return query(ss, mid, qs, qe, 2 * index + 1)+
                query(mid + 1, se, qs, qe, 2 * index + 2);
    }

    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }
    static void build(int[] ar,int ss, int se, int ind) {
        if (ss == se) {
            if(ar[ss]==1) {
                seg[ind] = ar[ss];
                return;
            }
            seg[ind]=0;
            return;
        }
        int mid = ss + (se - ss) / 2;
        build(ar,ss, mid, ind * 2 + 1);
        build(ar,mid + 1, se, ind * 2 + 2);
        seg[ind] = (seg[ind * 2 + 1]+ seg[ind * 2 + 2]);
    }

    static void constructST(int arr[], int n)
    {
        build(arr, 0, n - 1, 0);
    }
}
