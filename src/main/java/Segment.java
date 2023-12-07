

import java.util.*;

public class Segment {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int m= in.nextInt();
        pair[] pairs = new pair[n];
        int[] p = new int[m];

        for (int i = 0; i < n; i++) {
            pairs[i]= new pair(in.nextInt(),0);
        }
        for (int i = 0; i < n; i++) {
            pairs[i].second=in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            p[i]=in.nextInt();
        }

        Arrays.sort(pairs, (o1, o2) ->
        {
            if(o1.first-o2.first==0) {
                return o1.second-o2.second;
            }
            return o1.first- o2.first;
        });

        Arrays.sort(p);
        HashSet<Integer> set = new HashSet<>();
        int ans=0;
        for(int x:p) {
            int l= search(pairs,x,0,pairs.length-1);
            for (int i=l;i< pairs.length;i++) {
                if(set.contains(i)) {
                    continue;
                }
                set.add(i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static int search(pair[] arr,int key,int l,int r) {
        int ind=0;
        while(l<=r) {
            int mid=(l+r)/2;
            if (arr[mid].first>key) {
                ind=mid;
                r=mid-1;
            }
            else if(arr[mid].first<key) {
                l=mid+1;
            }
            else
                return mid;
        }
        return ind;
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
}
