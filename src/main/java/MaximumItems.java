import java.util.*;

public class MaximumItems {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        int k=in.nextInt();

        ArrayList<pair> a = new ArrayList<>(n);
        int curr=n;
        for (int i = 0; i <n; i++) {
            a.add(new pair(arr[i],curr));
            curr--;
        }

        Collections.sort(a, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if(o1.first==o2.first) {
                    return o1.second-o2.second;
                }
                return o1.first- o2.first;
            }
        });
        int total=0;
        for (pair p:a) {
            if (p.first*p.second>k) {
                p.second=k/p.first;
            }
            total+=p.second;
            k-=(p.first*p.second);
        }
        System.out.println(total);
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
